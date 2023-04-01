package com.bigtreetc.mybatis.sample.domain.repository;

import com.bigtreetc.mybatis.sample.domain.model.generated.Codes;
import com.bigtreetc.mybatis.sample.domain.model.generated.CodesExample;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CodesRepository {
  Page<Codes> findAll(CodesExample example, Pageable pageable);
}
