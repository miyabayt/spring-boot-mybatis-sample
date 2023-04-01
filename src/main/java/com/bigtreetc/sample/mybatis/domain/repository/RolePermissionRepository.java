package com.bigtreetc.sample.mybatis.domain.repository;

import com.bigtreetc.sample.mybatis.domain.model.generated.RolePermission;
import com.bigtreetc.sample.mybatis.domain.model.generated.RolePermissionExample;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RolePermissionRepository {
  RolePermission findById(Long pk1);

  Optional<RolePermission> findOne(RolePermissionExample example);

  Page<RolePermission> findAll(RolePermissionExample example, Pageable pageable);

  Cursor<RolePermission> findAll(RolePermissionExample example);

  int create(RolePermission rolePermission);

  int createAll(List<RolePermission> list);

  int update(RolePermission rolePermission);

  int delete(Long pk1);
}
