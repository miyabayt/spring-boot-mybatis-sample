package com.bigtreetc.sample.mybatis.domain.repository;

import com.bigtreetc.sample.mybatis.domain.model.generated.User;
import com.bigtreetc.sample.mybatis.domain.model.generated.UserExample;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepository {
  User findById(Long pk1);

  Optional<User> findOne(UserExample example);

  Page<User> findAll(UserExample example, Pageable pageable);

  Cursor<User> findAll(UserExample example);

  int create(User user);

  int createAll(List<User> list);

  int update(User user);

  int delete(Long pk1);
}
