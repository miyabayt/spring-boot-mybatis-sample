package com.bigtreetc.sample.mybatis.domain.repository;

import com.bigtreetc.sample.mybatis.domain.model.generated.Holiday;
import com.bigtreetc.sample.mybatis.domain.model.generated.HolidayExample;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HolidayRepository {
  Holiday findById(Long pk1);

  Optional<Holiday> findOne(HolidayExample example);

  Page<Holiday> findAll(HolidayExample example, Pageable pageable);

  Cursor<Holiday> findAll(HolidayExample example);

  int create(Holiday holiday);

  int createAll(List<Holiday> list);

  int update(Holiday holiday);

  int delete(Long pk1);
}
