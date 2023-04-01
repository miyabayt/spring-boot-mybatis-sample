package com.bigtreetc.sample.mybatis.domain.repository;

import com.bigtreetc.sample.mybatis.base.domain.dao.MyBatisContext;
import com.bigtreetc.sample.mybatis.domain.mapper.generated.PermissionMapper;
import com.bigtreetc.sample.mybatis.domain.model.generated.Permission;
import com.bigtreetc.sample.mybatis.domain.model.generated.PermissionExample;
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
public class PermissionRepositoryImpl implements PermissionRepository {
  @NonNull final SqlSession sqlSession;

  @NonNull final PermissionMapper permissionMapper;

  @Override
  public Permission findById(Long pk1) {
    return permissionMapper.selectByPrimaryKey(pk1);
  }

  @Override
  public Optional<Permission> findOne(PermissionExample example) {
    String namespacePrefix = PermissionRepository.class.getName();
    List<Permission> list =
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
  public Page<Permission> findAll(PermissionExample example, Pageable pageable) {
    String namespacePrefix = PermissionRepository.class.getName();
    List<Permission> list =
        sqlSession.selectList(namespacePrefix + ".findAll", new MyBatisContext(example, pageable));
    Long count = sqlSession.selectOne(namespacePrefix + ".count", example);
    return new PageImpl<>(list, pageable, count);
  }

  @Override
  public Cursor<Permission> findAll(PermissionExample example) {
    return permissionMapper.selectWithCursorByExample(example);
  }

  @Override
  public int create(Permission permission) {
    return permissionMapper.insert(permission);
  }

  @Override
  public int createAll(List<Permission> list) {
    return permissionMapper.batchInsert(list);
  }

  @Override
  public int update(Permission permission) {
    return permissionMapper.updateByPrimaryKey(permission);
  }

  @Override
  public int delete(Long pk1) {
    return permissionMapper.deleteByPrimaryKey(pk1);
  }
}
