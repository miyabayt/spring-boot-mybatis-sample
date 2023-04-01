package com.bigtreetc.sample.mybatis.domain.repository;

import com.bigtreetc.sample.mybatis.domain.model.generated.StaffRole;
import com.bigtreetc.sample.mybatis.domain.model.generated.StaffRoleExample;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StaffRoleRepository {
  StaffRole findById(Long pk1);

  Optional<StaffRole> findOne(StaffRoleExample example);

  Page<StaffRole> findAll(StaffRoleExample example, Pageable pageable);

  Cursor<StaffRole> findAll(StaffRoleExample example);

  int create(StaffRole staffRole);

  int createAll(List<StaffRole> list);

  int update(StaffRole staffRole);

  int delete(Long pk1);
}
