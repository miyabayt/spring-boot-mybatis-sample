package com.bigtreetc.mybatis.sample.domain.repository;

import com.bigtreetc.mybatis.sample.domain.model.generated.UserRoles;
import com.bigtreetc.mybatis.sample.domain.model.generated.UserRolesExample;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRolesRepository {
  Page<UserRoles> findAll(UserRolesExample example, Pageable pageable);
}
