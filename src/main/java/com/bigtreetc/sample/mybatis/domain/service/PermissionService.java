package com.bigtreetc.sample.mybatis.domain.service;

import com.bigtreetc.sample.mybatis.base.domain.service.BaseTransactionalService;
import com.bigtreetc.sample.mybatis.base.util.CsvUtils;
import com.bigtreetc.sample.mybatis.domain.model.generated.Permission;
import com.bigtreetc.sample.mybatis.domain.model.generated.PermissionExample;
import com.bigtreetc.sample.mybatis.domain.repository.PermissionRepository;
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
public class PermissionService extends BaseTransactionalService {

  @NonNull final PermissionRepository permissionRepository;

  /**
   * 権限マスタを検索します。
   *
   * @param example
   * @param pageable
   * @return
   */
  @Transactional(readOnly = true) // 読み取りのみの場合は指定する
  public Page<Permission> findAll(PermissionExample example, Pageable pageable) {
    Assert.notNull(example, "example must not be null");
    return permissionRepository.findAll(example, pageable);
  }

  /**
   * 権限マスタを取得します。
   *
   * @return
   */
  @Transactional(readOnly = true)
  public Optional<Permission> findOne(PermissionExample example) {
    Assert.notNull(example, "example must not be null");
    return permissionRepository.findOne(example);
  }

  /**
   * 権限マスタを取得します。
   *
   * @return
   */
  @Transactional(readOnly = true)
  public Permission findById(final Long id) {
    Assert.notNull(id, "id must not be null");
    return permissionRepository.findById(id);
  }

  /**
   * 権限マスタを登録します。
   *
   * @param inputPermission
   * @return
   */
  public Permission create(final Permission inputPermission) {
    Assert.notNull(inputPermission, "inputPermission must not be null");
    permissionRepository.create(inputPermission);
    return inputPermission;
  }

  /**
   * 権限マスタを一括登録します。
   *
   * @param permissions
   * @return
   */
  public int createAll(final List<Permission> permissions) {
    Assert.notNull(permissions, "permissions must not be null");
    return permissionRepository.createAll(permissions);
  }

  /**
   * 権限マスタを更新します。
   *
   * @param inputPermission
   * @return
   */
  public Permission update(final Permission inputPermission) {
    Assert.notNull(inputPermission, "inputPermission must not be null");
    val permissionId = inputPermission.getId();
    val version = inputPermission.getVersion();

    PermissionExample example = new PermissionExample();
    example.createCriteria().andIdEqualTo(permissionId).andVersionEqualTo(version);

    // 暫定
    val permission = permissionRepository.findById(permissionId);
    inputPermission.setCreatedAt(permission.getCreatedAt());
    inputPermission.setCreatedBy(permission.getCreatedBy());
    inputPermission.setUpdatedBy("test");
    permissionRepository.update(inputPermission);

    return inputPermission;
  }

  /**
   * 権限マスタを一括更新します。
   *
   * @param permissions
   * @return
   */
  public int updateAll(final List<Permission> permissions) {
    Assert.notNull(permissions, "permission must not be null");

    int count = 0;
    for (val permission : permissions) {
      count += permissionRepository.update(permission);
    }

    return count;
  }

  /**
   * 権限マスタを削除します。
   *
   * @return
   */
  public Permission delete(final Long id) {
    Assert.notNull(id, "id must not be null");
    val permission = permissionRepository.findById(id);
    permissionRepository.delete(id);
    return permission;
  }

  /**
   * 権限マスタを一括削除します。
   *
   * @param permissions
   * @return
   */
  public int deleteAll(final List<Permission> permissions) {
    Assert.notNull(permissions, "permissions must not be null");

    int count = 0;
    for (val permission : permissions) {
      val id = permission.getId();
      count += permissionRepository.delete(id);
    }

    return count;
  }

  /**
   * 権限マスタを書き出します。
   *
   * @param outputStream
   * @param
   * @return
   */
  @Transactional(readOnly = true) // 読み取りのみの場合は指定する
  public void writeToOutputStream(
      OutputStream outputStream, PermissionExample example, Class<?> clazz) throws IOException {
    Assert.notNull(example, "example must not be null");
    try (val data = permissionRepository.findAll(example)) {
      val stream = StreamSupport.stream(data.spliterator(), false);
      CsvUtils.writeCsv(
          outputStream, clazz, stream, permission -> modelMapper.map(permission, clazz));
    }
  }
}
