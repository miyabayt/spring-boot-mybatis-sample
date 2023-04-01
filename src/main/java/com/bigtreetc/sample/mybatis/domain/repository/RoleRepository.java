package com.bigtreetc.sample.mybatis.domain.repository;

import com.bigtreetc.sample.mybatis.domain.model.generated.Role;
import com.bigtreetc.sample.mybatis.domain.model.generated.RoleExample;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoleRepository {
  Role findById(Long pk1);

  Optional<Role> findOne(RoleExample example);

  Page<Role> findAll(RoleExample example, Pageable pageable);

  Cursor<Role> findAll(RoleExample example);

  int create(Role role);

  int createAll(List<Role> list);

  int update(Role role);

  int delete(Long pk1);
}
