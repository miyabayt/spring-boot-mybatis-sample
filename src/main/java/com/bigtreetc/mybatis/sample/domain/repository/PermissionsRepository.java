package com.bigtreetc.mybatis.sample.domain.repository;

import com.bigtreetc.mybatis.sample.domain.model.generated.Permissions;
import com.bigtreetc.mybatis.sample.domain.model.generated.PermissionsExample;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PermissionsRepository {
  Page<Permissions> findAll(PermissionsExample example, Pageable pageable);
}
