package com.bigtreetc.sample.mybatis.domain.service;

import com.bigtreetc.sample.mybatis.base.domain.service.BaseTransactionalService;
import com.bigtreetc.sample.mybatis.base.util.CsvUtils;
import com.bigtreetc.sample.mybatis.domain.model.generated.User;
import com.bigtreetc.sample.mybatis.domain.model.generated.UserExample;
import com.bigtreetc.sample.mybatis.domain.repository.UserRepository;
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
public class UserService extends BaseTransactionalService {

  @NonNull final UserRepository userRepository;

  /**
   * 顧客マスタを検索します。
   *
   * @param example
   * @param pageable
   * @return
   */
  @Transactional(readOnly = true) // 読み取りのみの場合は指定する
  public Page<User> findAll(UserExample example, Pageable pageable) {
    Assert.notNull(example, "example must not be null");
    return userRepository.findAll(example, pageable);
  }

  /**
   * 顧客マスタを取得します。
   *
   * @return
   */
  @Transactional(readOnly = true)
  public Optional<User> findOne(UserExample example) {
    Assert.notNull(example, "example must not be null");
    return userRepository.findOne(example);
  }

  /**
   * 顧客マスタを取得します。
   *
   * @return
   */
  @Transactional(readOnly = true)
  public User findById(final Long id) {
    Assert.notNull(id, "id must not be null");
    return userRepository.findById(id);
  }

  /**
   * 顧客マスタを登録します。
   *
   * @param inputUser
   * @return
   */
  public User create(final User inputUser) {
    Assert.notNull(inputUser, "inputUser must not be null");
    userRepository.create(inputUser);
    return inputUser;
  }

  /**
   * 顧客マスタを一括登録します。
   *
   * @param users
   * @return
   */
  public int createAll(final List<User> users) {
    Assert.notNull(users, "users must not be null");
    return userRepository.createAll(users);
  }

  /**
   * 顧客マスタを更新します。
   *
   * @param inputUser
   * @return
   */
  public User update(final User inputUser) {
    Assert.notNull(inputUser, "inputUser must not be null");
    val userId = inputUser.getId();
    val version = inputUser.getVersion();

    UserExample example = new UserExample();
    example.createCriteria().andIdEqualTo(userId).andVersionEqualTo(version);

    // 暫定
    val user = userRepository.findById(userId);
    inputUser.setCreatedAt(user.getCreatedAt());
    inputUser.setCreatedBy(user.getCreatedBy());
    inputUser.setUpdatedBy("test");
    userRepository.update(inputUser);

    return inputUser;
  }

  /**
   * 顧客マスタを一括更新します。
   *
   * @param users
   * @return
   */
  public int updateAll(final List<User> users) {
    Assert.notNull(users, "users must not be null");

    int count = 0;
    for (val user : users) {
      count += userRepository.update(user);
    }

    return count;
  }

  /**
   * 顧客マスタを削除します。
   *
   * @return
   */
  public User delete(final Long id) {
    Assert.notNull(id, "id must not be null");
    val user = userRepository.findById(id);
    userRepository.delete(id);
    return user;
  }

  /**
   * 顧客マスタを一括削除します。
   *
   * @param users
   * @return
   */
  public int deleteAll(final List<User> users) {
    Assert.notNull(users, "users must not be null");

    int count = 0;
    for (val user : users) {
      val id = user.getId();
      count += userRepository.delete(id);
    }

    return count;
  }

  /**
   * 顧客マスタを書き出します。
   *
   * @param outputStream
   * @param
   * @return
   */
  @Transactional(readOnly = true) // 読み取りのみの場合は指定する
  public void writeToOutputStream(OutputStream outputStream, UserExample example, Class<?> clazz)
      throws IOException {
    Assert.notNull(example, "example must not be null");
    try (val data = userRepository.findAll(example)) {
      val stream = StreamSupport.stream(data.spliterator(), false);
      CsvUtils.writeCsv(outputStream, clazz, stream, user -> modelMapper.map(user, clazz));
    }
  }
}
