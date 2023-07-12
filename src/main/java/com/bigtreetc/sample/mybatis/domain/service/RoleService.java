package com.bigtreetc.sample.mybatis.domain.service;

import com.bigtreetc.sample.mybatis.base.domain.service.BaseTransactionalService;
import com.bigtreetc.sample.mybatis.base.util.CsvUtils;
import com.bigtreetc.sample.mybatis.domain.model.generated.Role;
import com.bigtreetc.sample.mybatis.domain.model.generated.RoleExample;
import com.bigtreetc.sample.mybatis.domain.repository.RoleRepository;
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
public class RoleService extends BaseTransactionalService {

  @NonNull final RoleRepository roleRepository;

  /**
   * ロールマスタを検索します。
   *
   * @param example
   * @param pageable
   * @return
   */
  @Transactional(readOnly = true) // 読み取りのみの場合は指定する
  public Page<Role> findAll(RoleExample example, Pageable pageable) {
    Assert.notNull(example, "example must not be null");
    return roleRepository.findAll(example, pageable);
  }

  /**
   * ロールマスタを取得します。
   *
   * @return
   */
  @Transactional(readOnly = true)
  public Optional<Role> findOne(RoleExample example) {
    Assert.notNull(example, "example must not be null");
    return roleRepository.findOne(example);
  }

  /**
   * ロールマスタを取得します。
   *
   * @return
   */
  @Transactional(readOnly = true)
  public Role findById(final Long id) {
    Assert.notNull(id, "id must not be null");
    return roleRepository.findById(id);
  }

  /**
   * ロールマスタを登録します。
   *
   * @param inputRole
   * @return
   */
  public Role create(final Role inputRole) {
    Assert.notNull(inputRole, "inputRole must not be null");
    roleRepository.create(inputRole);
    return inputRole;
  }

  /**
   * ロールマスタを一括登録します。
   *
   * @param roles
   * @return
   */
  public int createAll(final List<Role> roles) {
    Assert.notNull(roles, "roles must not be null");
    return roleRepository.createAll(roles);
  }

  /**
   * ロールマスタを更新します。
   *
   * @param inputRole
   * @return
   */
  public Role update(final Role inputRole) {
    Assert.notNull(inputRole, "inputRole must not be null");
    val roleId = inputRole.getId();
    val role = roleRepository.findById(roleId);
    modelMapper.map(inputRole, role);
    roleRepository.update(role);
    return role;
  }

  /**
   * ロールマスタを一括更新します。
   *
   * @param roles
   * @return
   */
  public int updateAll(final List<Role> roles) {
    Assert.notNull(roles, "roles must not be null");

    int count = 0;
    for (val role : roles) {
      count += roleRepository.update(role);
    }

    return count;
  }

  /**
   * ロールマスタを削除します。
   *
   * @return
   */
  public Role delete(final Long id) {
    Assert.notNull(id, "id must not be null");
    val role = roleRepository.findById(id);
    roleRepository.delete(id);
    return role;
  }

  /**
   * ロールマスタを一括削除します。
   *
   * @param roles
   * @return
   */
  public int deleteAll(final List<Role> roles) {
    Assert.notNull(roles, "roles must not be null");

    int count = 0;
    for (val role : roles) {
      val id = role.getId();
      count += roleRepository.delete(id);
    }

    return count;
  }

  /**
   * ロールマスタを書き出します。
   *
   * @param outputStream
   * @param
   * @return
   */
  @Transactional(readOnly = true) // 読み取りのみの場合は指定する
  public void writeToOutputStream(OutputStream outputStream, RoleExample example, Class<?> clazz)
      throws IOException {
    Assert.notNull(example, "example must not be null");
    try (val data = roleRepository.findAll(example)) {
      val stream = StreamSupport.stream(data.spliterator(), false);
      CsvUtils.writeCsv(outputStream, clazz, stream, role -> modelMapper.map(role, clazz));
    }
  }
}
