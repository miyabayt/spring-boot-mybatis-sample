package com.bigtreetc.sample.mybatis.domain.service;

import com.bigtreetc.sample.mybatis.base.domain.service.BaseTransactionalService;
import com.bigtreetc.sample.mybatis.base.util.CsvUtils;
import com.bigtreetc.sample.mybatis.domain.model.generated.MailTemplate;
import com.bigtreetc.sample.mybatis.domain.model.generated.MailTemplateExample;
import com.bigtreetc.sample.mybatis.domain.repository.MailTemplateRepository;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/** 担当者サービス */
@RequiredArgsConstructor
@Service
public class MailTemplateService extends BaseTransactionalService {

  @NonNull final MailTemplateRepository mailTemplateRepository;

  /**
   * メールテンプレートを検索します。
   *
   * @param example
   * @param pageable
   * @return
   */
  @Transactional(readOnly = true) // 読み取りのみの場合は指定する
  public Page<MailTemplate> findAll(MailTemplateExample example, Pageable pageable) {
    Assert.notNull(example, "example must not be null");
    return mailTemplateRepository.findAll(example, pageable);
  }

  /**
   * メールテンプレートを取得します。
   *
   * @return
   */
  @Transactional(readOnly = true)
  public Optional<MailTemplate> findOne(MailTemplateExample example) {
    Assert.notNull(example, "example must not be null");
    return mailTemplateRepository.findOne(example);
  }

  /**
   * メールテンプレートを取得します。
   *
   * @return
   */
  @Transactional(readOnly = true)
  public MailTemplate findById(final Long id) {
    Assert.notNull(id, "id must not be null");
    return mailTemplateRepository.findById(id);
  }

  /**
   * メールテンプレートを登録します。
   *
   * @param inputMailTemplate
   * @return
   */
  public MailTemplate create(final MailTemplate inputMailTemplate) {
    Assert.notNull(inputMailTemplate, "inputMailTemplate must not be null");
    mailTemplateRepository.create(inputMailTemplate);
    return inputMailTemplate;
  }

  /**
   * メールテンプレートを一括登録します。
   *
   * @param mailTemplates
   * @return
   */
  public int createAll(final List<MailTemplate> mailTemplates) {
    Assert.notNull(mailTemplates, "mailTemplates must not be null");
    return mailTemplateRepository.createAll(mailTemplates);
  }

  /**
   * メールテンプレートを更新します。
   *
   * @param inputMailTemplate
   * @return
   */
  public MailTemplate update(final MailTemplate inputMailTemplate) {
    Assert.notNull(inputMailTemplate, "inputMailTemplate must not be null");
    val mailTemplateId = inputMailTemplate.getId();
    val version = inputMailTemplate.getVersion();

    MailTemplateExample example = new MailTemplateExample();
    example.createCriteria().andIdEqualTo(mailTemplateId).andVersionEqualTo(version);

    // 暫定
    val mailTemplate = mailTemplateRepository.findById(mailTemplateId);
    inputMailTemplate.setCreatedAt(mailTemplate.getCreatedAt());
    inputMailTemplate.setCreatedBy(mailTemplate.getCreatedBy());
    inputMailTemplate.setUpdatedBy("test");
    mailTemplateRepository.update(inputMailTemplate);

    return inputMailTemplate;
  }

  /**
   * メールテンプレートを一括更新します。
   *
   * @param mailTemplates
   * @return
   */
  public int updateAll(final List<MailTemplate> mailTemplates) {
    Assert.notNull(mailTemplates, "mailTemplate must not be null");

    int count = 0;
    for (val mailTemplate : mailTemplates) {
      count += mailTemplateRepository.update(mailTemplate);
    }

    return count;
  }

  /**
   * メールテンプレートを削除します。
   *
   * @return
   */
  public MailTemplate delete(final Long id) {
    Assert.notNull(id, "id must not be null");
    val mailTemplate = mailTemplateRepository.findById(id);
    mailTemplateRepository.delete(id);
    return mailTemplate;
  }

  /**
   * メールテンプレートを一括削除します。
   *
   * @param mailTemplates
   * @return
   */
  public int deleteAll(final List<MailTemplate> mailTemplates) {
    Assert.notNull(mailTemplates, "mailTemplates must not be null");

    int count = 0;
    for (val mailTemplate : mailTemplates) {
      val id = mailTemplate.getId();
      count += mailTemplateRepository.delete(id);
    }

    return count;
  }

  /**
   * メールテンプレートを書き出します。
   *
   * @param outputStream
   * @param
   * @return
   */
  @Transactional(readOnly = true) // 読み取りのみの場合は指定する
  public void writeToOutputStream(
      OutputStream outputStream, MailTemplateExample example, Class<?> clazz) throws IOException {
    Assert.notNull(example, "example must not be null");
    try (val data = mailTemplateRepository.findAll(example)) {
      val stream = StreamSupport.stream(data.spliterator(), false);
      CsvUtils.writeCsv(
          outputStream, clazz, stream, mailTemplate -> modelMapper.map(mailTemplate, clazz));
    }
  }
}
