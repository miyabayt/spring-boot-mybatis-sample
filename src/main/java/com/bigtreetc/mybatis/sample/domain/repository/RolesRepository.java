package com.bigtreetc.mybatis.sample.domain.repository;

import com.bigtreetc.mybatis.sample.domain.model.generated.Roles;
import com.bigtreetc.mybatis.sample.domain.model.generated.RolesExample;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RolesRepository {
  Page<Roles> findAll(RolesExample example, Pageable pageable);
}
