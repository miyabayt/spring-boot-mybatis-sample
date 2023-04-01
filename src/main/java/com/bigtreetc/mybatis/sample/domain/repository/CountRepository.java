package com.bigtreetc.mybatis.sample.domain.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CountRepository {

  @Select("select FOUND_ROWS()")
  long countFoundRows();
}
