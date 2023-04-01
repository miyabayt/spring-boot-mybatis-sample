package com.bigtreetc.sample.mybatis.domain.repository;

import com.bigtreetc.sample.mybatis.base.domain.dao.MyBatisContext;
import com.bigtreetc.sample.mybatis.domain.mapper.generated.UserRoleMapper;
import com.bigtreetc.sample.mybatis.domain.model.generated.UserRole;
import com.bigtreetc.sample.mybatis.domain.model.generated.UserRoleExample;
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
public class UserRoleRepositoryImpl implements UserRoleRepository {
  @NonNull final SqlSession sqlSession;

  @NonNull final UserRoleMapper userRoleMapper;

  @Override
  public UserRole findById(Long pk1) {
    return userRoleMapper.selectByPrimaryKey(pk1);
  }

  @Override
  public Optional<UserRole> findOne(UserRoleExample example) {
    String namespacePrefix = UserRoleRepository.class.getName();
    List<UserRole> list =
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
  public Page<UserRole> findAll(UserRoleExample example, Pageable pageable) {
    String namespacePrefix = UserRoleRepository.class.getName();
    List<UserRole> list =
        sqlSession.selectList(namespacePrefix + ".findAll", new MyBatisContext(example, pageable));
    Long count = sqlSession.selectOne(namespacePrefix + ".count", example);
    return new PageImpl<>(list, pageable, count);
  }

  @Override
  public Cursor<UserRole> findAll(UserRoleExample example) {
    return userRoleMapper.selectWithCursorByExample(example);
  }

  @Override
  public int create(UserRole userRole) {
    return userRoleMapper.insert(userRole);
  }

  @Override
  public int createAll(List<UserRole> list) {
    return userRoleMapper.batchInsert(list);
  }

  @Override
  public int update(UserRole userRole) {
    return userRoleMapper.updateByPrimaryKey(userRole);
  }

  @Override
  public int delete(Long pk1) {
    return userRoleMapper.deleteByPrimaryKey(pk1);
  }
}
