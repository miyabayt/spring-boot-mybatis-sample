package com.bigtreetc.sample.mybatis.domain.repository;

import com.bigtreetc.sample.mybatis.base.domain.dao.MyBatisContext;
import com.bigtreetc.sample.mybatis.domain.mapper.generated.RoleMapper;
import com.bigtreetc.sample.mybatis.domain.model.generated.Role;
import com.bigtreetc.sample.mybatis.domain.model.generated.RoleExample;
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
public class RoleRepositoryImpl implements RoleRepository {
  @NonNull final SqlSession sqlSession;

  @NonNull final RoleMapper roleMapper;

  @Override
  public Role findById(Long pk1) {
    return roleMapper.selectByPrimaryKey(pk1);
  }

  @Override
  public Optional<Role> findOne(RoleExample example) {
    String namespacePrefix = RoleRepository.class.getName();
    List<Role> list =
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
  public Page<Role> findAll(RoleExample example, Pageable pageable) {
    String namespacePrefix = RoleRepository.class.getName();
    List<Role> list =
        sqlSession.selectList(namespacePrefix + ".findAll", new MyBatisContext(example, pageable));
    Long count = sqlSession.selectOne(namespacePrefix + ".count", example);
    return new PageImpl<>(list, pageable, count);
  }

  @Override
  public Cursor<Role> findAll(RoleExample example) {
    return roleMapper.selectWithCursorByExample(example);
  }

  @Override
  public int create(Role role) {
    return roleMapper.insert(role);
  }

  @Override
  public int createAll(List<Role> list) {
    return roleMapper.batchInsert(list);
  }

  @Override
  public int update(Role role) {
    return roleMapper.updateByPrimaryKey(role);
  }

  @Override
  public int delete(Long pk1) {
    return roleMapper.deleteByPrimaryKey(pk1);
  }
}
