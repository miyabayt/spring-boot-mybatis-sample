package com.bigtreetc.sample.mybatis.domain.repository;

import com.bigtreetc.sample.mybatis.base.domain.dao.MyBatisContext;
import com.bigtreetc.sample.mybatis.domain.mapper.generated.HolidayMapper;
import com.bigtreetc.sample.mybatis.domain.model.generated.Holiday;
import com.bigtreetc.sample.mybatis.domain.model.generated.HolidayExample;
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
public class HolidayRepositoryImpl implements HolidayRepository {
  @NonNull final SqlSession sqlSession;

  @NonNull final HolidayMapper holidayMapper;

  @Override
  public Holiday findById(Long pk1) {
    return holidayMapper.selectByPrimaryKey(pk1);
  }

  @Override
  public Optional<Holiday> findOne(HolidayExample example) {
    String namespacePrefix = HolidayRepository.class.getName();
    List<Holiday> list =
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
  public Page<Holiday> findAll(HolidayExample example, Pageable pageable) {
    String namespacePrefix = HolidayRepository.class.getName();
    List<Holiday> list =
        sqlSession.selectList(namespacePrefix + ".findAll", new MyBatisContext(example, pageable));
    Long count = sqlSession.selectOne(namespacePrefix + ".count", example);
    return new PageImpl<>(list, pageable, count);
  }

  @Override
  public Cursor<Holiday> findAll(HolidayExample example) {
    return holidayMapper.selectWithCursorByExample(example);
  }

  @Override
  public int create(Holiday holiday) {
    return holidayMapper.insert(holiday);
  }

  @Override
  public int createAll(List<Holiday> list) {
    return holidayMapper.batchInsert(list);
  }

  @Override
  public int update(Holiday holiday) {
    return holidayMapper.updateByPrimaryKey(holiday);
  }

  @Override
  public int delete(Long pk1) {
    return holidayMapper.deleteByPrimaryKey(pk1);
  }
}
