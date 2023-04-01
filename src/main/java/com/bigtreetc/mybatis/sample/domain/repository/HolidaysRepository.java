package com.bigtreetc.mybatis.sample.domain.repository;

import com.bigtreetc.mybatis.sample.domain.model.generated.Holidays;
import com.bigtreetc.mybatis.sample.domain.model.generated.HolidaysExample;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HolidaysRepository {
  Page<Holidays> findAll(HolidaysExample example, Pageable pageable);
}
