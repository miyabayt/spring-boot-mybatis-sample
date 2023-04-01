package com.bigtreetc.sample.mybatis.domain.repository;

import com.bigtreetc.sample.mybatis.base.domain.dao.MyBatisContext;
import com.bigtreetc.sample.mybatis.domain.mapper.generated.UserMapper;
import com.bigtreetc.sample.mybatis.domain.model.generated.User;
import com.bigtreetc.sample.mybatis.domain.model.generated.UserExample;
import java.util.List;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {
  @NonNull final SqlSession sqlSession;

  @NonNull final UserMapper userMapper;

  @Override
  public User findById(Long pk1) {
    return userMapper.selectByPrimaryKey(pk1);
  }

  @Override
  public Optional<User> findOne(UserExample example) {
    String namespacePrefix = UserRepository.class.getName();
    List<User> list =
        sqlSession.selectList(
            namespacePrefix + ".findAll", new MyBatisContext(example, Pageable.ofSize(2)));
    if (list.isEmpty()) {
      return Optional.empty();
    }
    if (list.size() >= 2) {
      throw new IncorrectResultSizeDataAccessException(1);
    }
    return Optional.of(list.get(0));
  }

  @Override
  public Page<User> findAll(UserExample example, Pageable pageable) {
    String namespacePrefix = UserRepository.class.getName();
    List<User> list =
        sqlSession.selectList(namespacePrefix + ".findAll", new MyBatisContext(example, pageable));
    Long count = sqlSession.selectOne(namespacePrefix + ".count", example);
    return new PageImpl<>(list, pageable, count);
  }

  @Override
  public Cursor<User> findAll(UserExample example) {
    return userMapper.selectWithCursorByExample(example);
  }

  @Override
  public int create(User user) {
    return userMapper.insert(user);
  }

  @Override
  public int createAll(List<User> list) {
    return userMapper.batchInsert(list);
  }

  @Override
  public int update(User user) {
    return userMapper.updateByPrimaryKey(user);
  }

  @Override
  public int delete(Long pk1) {
    return userMapper.deleteByPrimaryKey(pk1);
  }
}
