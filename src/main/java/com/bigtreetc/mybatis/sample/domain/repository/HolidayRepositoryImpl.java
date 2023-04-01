package com.bigtreetc.mybatis.sample.domain.repository;

import com.bigtreetc.mybatis.sample.base.domain.dao.MyBatisContext;
import com.bigtreetc.mybatis.sample.domain.model.generated.Holidays;
import com.bigtreetc.mybatis.sample.domain.model.generated.HolidaysExample;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class HolidayRepositoryImpl implements HolidaysRepository {

  @NonNull final SqlSession sqlSession;

  @Override
  public Page<Holidays> findAll(HolidaysExample example, Pageable pageable) {
    String namespacePrefix = HolidaysRepository.class.getName();
    List<Holidays> list =
        sqlSession.selectList(namespacePrefix + ".findAll", new MyBatisContext(example, pageable));
    Long count = sqlSession.selectOne(namespacePrefix + ".count", example);
    return new PageImpl<>(list, pageable, count);
  }
}
