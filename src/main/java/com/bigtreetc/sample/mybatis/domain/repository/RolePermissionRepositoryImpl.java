package com.bigtreetc.sample.mybatis.domain.repository;

import com.bigtreetc.sample.mybatis.base.domain.dao.MyBatisContext;
import com.bigtreetc.sample.mybatis.domain.mapper.generated.RolePermissionMapper;
import com.bigtreetc.sample.mybatis.domain.model.generated.RolePermission;
import com.bigtreetc.sample.mybatis.domain.model.generated.RolePermissionExample;
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
public class RolePermissionRepositoryImpl implements RolePermissionRepository {
  @NonNull final SqlSession sqlSession;

  @NonNull final RolePermissionMapper rolePermissionMapper;

  @Override
  public RolePermission findById(Long pk1) {
    return rolePermissionMapper.selectByPrimaryKey(pk1);
  }

  @Override
  public Optional<RolePermission> findOne(RolePermissionExample example) {
    String namespacePrefix = RolePermissionRepository.class.getName();
    List<RolePermission> list =
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
  public Page<RolePermission> findAll(RolePermissionExample example, Pageable pageable) {
    String namespacePrefix = RolePermissionRepository.class.getName();
    List<RolePermission> list =
        sqlSession.selectList(namespacePrefix + ".findAll", new MyBatisContext(example, pageable));
    Long count = sqlSession.selectOne(namespacePrefix + ".count", example);
    return new PageImpl<>(list, pageable, count);
  }

  @Override
  public Cursor<RolePermission> findAll(RolePermissionExample example) {
    return rolePermissionMapper.selectWithCursorByExample(example);
  }

  @Override
  public int create(RolePermission rolePermission) {
    return rolePermissionMapper.insert(rolePermission);
  }

  @Override
  public int createAll(List<RolePermission> list) {
    return rolePermissionMapper.batchInsert(list);
  }

  @Override
  public int update(RolePermission rolePermission) {
    return rolePermissionMapper.updateByPrimaryKey(rolePermission);
  }

  @Override
  public int delete(Long pk1) {
    return rolePermissionMapper.deleteByPrimaryKey(pk1);
  }
}
