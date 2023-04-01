package com.bigtreetc.mybatis.sample.domain.repository;

import com.bigtreetc.mybatis.sample.domain.model.generated.RolePermissions;
import com.bigtreetc.mybatis.sample.domain.model.generated.RolePermissionsExample;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RolePermissionsRepository {
  Page<RolePermissions> findAll(RolePermissionsExample example, Pageable pageable);
}
