package com.bigtreetc.mybatis.sample.domain.repository;

import com.bigtreetc.mybatis.sample.domain.model.generated.Users;
import com.bigtreetc.mybatis.sample.domain.model.generated.UsersExample;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsersRepository {
  Page<Users> findAll(UsersExample example, Pageable pageable);
}
