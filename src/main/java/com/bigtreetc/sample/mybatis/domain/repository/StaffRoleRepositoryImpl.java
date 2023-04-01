package com.bigtreetc.sample.mybatis.domain.repository;

import com.bigtreetc.sample.mybatis.base.domain.dao.MyBatisContext;
import com.bigtreetc.sample.mybatis.domain.mapper.generated.StaffRoleMapper;
import com.bigtreetc.sample.mybatis.domain.model.generated.StaffRole;
import com.bigtreetc.sample.mybatis.domain.model.generated.StaffRoleExample;
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
public class StaffRoleRepositoryImpl implements StaffRoleRepository {
  @NonNull final SqlSession sqlSession;

  @NonNull final StaffRoleMapper staffRoleMapper;

  @Override
  public StaffRole findById(Long pk1) {
    return staffRoleMapper.selectByPrimaryKey(pk1);
  }

  @Override
  public Optional<StaffRole> findOne(StaffRoleExample example) {
    String namespacePrefix = StaffRoleRepository.class.getName();
    List<StaffRole> list =
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
  public Page<StaffRole> findAll(StaffRoleExample example, Pageable pageable) {
    String namespacePrefix = StaffRoleRepository.class.getName();
    List<StaffRole> list =
        sqlSession.selectList(namespacePrefix + ".findAll", new MyBatisContext(example, pageable));
    Long count = sqlSession.selectOne(namespacePrefix + ".count", example);
    return new PageImpl<>(list, pageable, count);
  }

  @Override
  public Cursor<StaffRole> findAll(StaffRoleExample example) {
    return staffRoleMapper.selectWithCursorByExample(example);
  }

  @Override
  public int create(StaffRole staffRole) {
    return staffRoleMapper.insert(staffRole);
  }

  @Override
  public int createAll(List<StaffRole> list) {
    return staffRoleMapper.batchInsert(list);
  }

  @Override
  public int update(StaffRole staffRole) {
    return staffRoleMapper.updateByPrimaryKey(staffRole);
  }

  @Override
  public int delete(Long pk1) {
    return staffRoleMapper.deleteByPrimaryKey(pk1);
  }
}
