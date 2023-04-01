package com.bigtreetc.sample.mybatis.domain.service;

import static com.bigtreetc.sample.mybatis.base.util.ValidateUtils.isEmpty;

import com.bigtreetc.sample.mybatis.base.domain.service.BaseTransactionalService;
import com.bigtreetc.sample.mybatis.base.exception.NoDataFoundException;
import com.bigtreetc.sample.mybatis.base.helper.SendMailHelper;
import com.bigtreetc.sample.mybatis.domain.model.generated.MailTemplate;
import com.bigtreetc.sample.mybatis.domain.model.generated.MailTemplateExample;
import com.bigtreetc.sample.mybatis.domain.model.generated.StaffExample;
import com.bigtreetc.sample.mybatis.domain.repository.MailTemplateRepository;
import com.bigtreetc.sample.mybatis.domain.repository.StaffRepository;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/** ログインサービス */
@RequiredArgsConstructor
@Service
public class LoginService extends BaseTransactionalService {

  @Value("${spring.mail.properties.mail.from}")
  String fromAddress;

  @NonNull final StaffRepository staffRepository;

  @NonNull final MailTemplateRepository mailTemplateRepository;

  @NonNull final SendMailHelper sendMailHelper;

  /**
   * パスワードリセットメールを送信します。
   *
   * @param email
   * @param url
   */
  public void sendResetPasswordMail(String email, String url) {
    Assert.notNull(fromAddress, "fromAddress must be set.");

    val example = new StaffExample();
    example.createCriteria().andEmailEqualTo(email);
    val staffOpt = staffRepository.findOne(example);

    staffOpt.ifPresent(
        s -> {
          // トークンを発行する
          val token = UUID.randomUUID().toString();
          s.setPasswordResetToken(token);
          s.setTokenExpiresAt(LocalDateTime.now().plusHours(2)); // 2時間後に失効させる
          staffRepository.update(s);

          // メールを作成する
          val mailTemplate = getMailTemplate("passwordReset");
          val subject = mailTemplate.getSubject();
          val templateBody = mailTemplate.getTemplateBody();

          Map<String, Object> objects = new HashMap<>();
          objects.put("staffOpt", s);
          objects.put("url", url + "?token=" + token);

          // テンプレートエンジンにかける
          val body = sendMailHelper.getMailBody(templateBody, objects);

          // メールを送信する
          sendMailHelper.sendMail(fromAddress, new String[] {s.getEmail()}, subject, body);
        });
  }

  /**
   * トークンの有効性をチェックします。
   *
   * @param token
   * @return
   */
  public boolean isValidPasswordResetToken(String token) {
    if (isEmpty(token)) {
      return false;
    }

    // トークンの一致と有効期限をチェックする
    val example = new StaffExample();
    example.createCriteria().andPasswordResetTokenEqualTo(token);
    val staffOpt = staffRepository.findOne(example);

    if (staffOpt.isEmpty()) {
      return false;
    }

    return true;
  }

  /**
   * パスワードを更新します。
   *
   * @param token
   * @param password
   * @return
   */
  public boolean updatePassword(String token, String password) {
    // トークンの一致と有効期限をチェックする
    val example = new StaffExample();
    example.createCriteria().andPasswordResetTokenEqualTo(token);
    val staffOpt = staffRepository.findOne(example);

    if (staffOpt.isEmpty()) {
      return false;
    }

    staffOpt.ifPresent(
        s -> {
          // パスワードをリセットする
          s.setPasswordResetToken(null);
          s.setTokenExpiresAt(null);
          s.setPassword(password);
          staffRepository.update(s);
        });

    return true;
  }

  /**
   * メールテンプレートを取得する。
   *
   * @return
   */
  protected MailTemplate getMailTemplate(String templateCode) {
    val example = new MailTemplateExample();
    example.createCriteria().andTemplateCodeEqualTo(templateCode);
    return mailTemplateRepository
        .findOne(example)
        .orElseThrow(
            () -> new NoDataFoundException("templateCode=" + templateCode + " のデータが見つかりません。"));
  }
}
