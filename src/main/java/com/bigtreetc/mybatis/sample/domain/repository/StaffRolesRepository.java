package com.bigtreetc.mybatis.sample.domain.repository;

import com.bigtreetc.mybatis.sample.domain.model.generated.StaffRoles;
import com.bigtreetc.mybatis.sample.domain.model.generated.StaffRolesExample;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StaffRolesRepository {
  Page<StaffRoles> findAll(StaffRolesExample example, Pageable pageable);
}
