package com.bigtreetc.sample.mybatis.domain.repository;

import com.bigtreetc.sample.mybatis.domain.model.generated.Permission;
import com.bigtreetc.sample.mybatis.domain.model.generated.PermissionExample;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PermissionRepository {
  Permission findById(Long pk1);

  Optional<Permission> findOne(PermissionExample example);

  Page<Permission> findAll(PermissionExample example, Pageable pageable);

  Cursor<Permission> findAll(PermissionExample example);

  int create(Permission permission);

  int createAll(List<Permission> list);

  int update(Permission permission);

  int delete(Long pk1);
}
