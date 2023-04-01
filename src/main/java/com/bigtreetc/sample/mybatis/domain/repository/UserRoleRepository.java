package com.bigtreetc.sample.mybatis.domain.repository;

import com.bigtreetc.sample.mybatis.domain.model.generated.UserRole;
import com.bigtreetc.sample.mybatis.domain.model.generated.UserRoleExample;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRoleRepository {
  UserRole findById(Long pk1);

  Optional<UserRole> findOne(UserRoleExample example);

  Page<UserRole> findAll(UserRoleExample example, Pageable pageable);

  Cursor<UserRole> findAll(UserRoleExample example);

  int create(UserRole userRole);

  int createAll(List<UserRole> list);

  int update(UserRole userRole);

  int delete(Long pk1);
}
