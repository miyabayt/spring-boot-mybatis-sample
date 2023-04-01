package com.bigtreetc.mybatis.sample.domain.repository;

import com.bigtreetc.mybatis.sample.domain.model.generated.Staffs;
import com.bigtreetc.mybatis.sample.domain.model.generated.StaffsExample;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StaffsRepository {
  Page<Staffs> findAll(StaffsExample example, Pageable pageable);
}
