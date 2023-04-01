package com.bigtreetc.sample.mybatis.domain.repository;

import com.bigtreetc.sample.mybatis.base.domain.dao.MyBatisContext;
import com.bigtreetc.sample.mybatis.domain.mapper.generated.StaffMapper;
import com.bigtreetc.sample.mybatis.domain.model.generated.Staff;
import com.bigtreetc.sample.mybatis.domain.model.generated.StaffExample;
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
public class StaffRepositoryImpl implements StaffRepository {
  @NonNull final SqlSession sqlSession;

  @NonNull final StaffMapper staffMapper;

  @Override
  public Staff findById(Long pk1) {
    return staffMapper.selectByPrimaryKey(pk1);
  }

  @Override
  public Optional<Staff> findOne(StaffExample example) {
    String namespacePrefix = StaffRepository.class.getName();
    List<Staff> list =
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
  public Page<Staff> findAll(StaffExample example, Pageable pageable) {
    String namespacePrefix = StaffRepository.class.getName();
    List<Staff> list =
        sqlSession.selectList(namespacePrefix + ".findAll", new MyBatisContext(example, pageable));
    Long count = sqlSession.selectOne(namespacePrefix + ".count", example);
    return new PageImpl<>(list, pageable, count);
  }

  @Override
  public Cursor<Staff> findAll(StaffExample example) {
    return staffMapper.selectWithCursorByExample(example);
  }

  @Override
  public int create(Staff staff) {
    return staffMapper.insert(staff);
  }

  @Override
  public int createAll(List<Staff> list) {
    return staffMapper.batchInsert(list);
  }

  @Override
  public int update(Staff staff) {
    return staffMapper.updateByPrimaryKey(staff);
  }

  @Override
  public int delete(Long pk1) {
    return staffMapper.deleteByPrimaryKey(pk1);
  }
}
