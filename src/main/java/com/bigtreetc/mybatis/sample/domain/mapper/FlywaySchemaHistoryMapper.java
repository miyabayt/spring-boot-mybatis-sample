package com.bigtreetc.mybatis.sample.domain.mapper;

import com.bigtreetc.mybatis.sample.domain.model.FlywaySchemaHistory;
import com.bigtreetc.mybatis.sample.domain.model.FlywaySchemaHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface FlywaySchemaHistoryMapper {
  long countByExample(FlywaySchemaHistoryExample example);

  int deleteByExample(FlywaySchemaHistoryExample example);

  int deleteByPrimaryKey(Integer installedRank);

  int insert(FlywaySchemaHistory record);

  int insertSelective(FlywaySchemaHistory record);

  List<FlywaySchemaHistory> selectByExampleWithRowbounds(
      FlywaySchemaHistoryExample example, RowBounds rowBounds);

  List<FlywaySchemaHistory> selectByExample(FlywaySchemaHistoryExample example);

  FlywaySchemaHistory selectByPrimaryKey(Integer installedRank);

  int updateByExampleSelective(
      @Param("record") FlywaySchemaHistory record,
      @Param("example") FlywaySchemaHistoryExample example);

  int updateByExample(
      @Param("record") FlywaySchemaHistory record,
      @Param("example") FlywaySchemaHistoryExample example);

  int updateByPrimaryKeySelective(FlywaySchemaHistory record);

  int updateByPrimaryKey(FlywaySchemaHistory record);

  int upsert(FlywaySchemaHistory record);

  int upsertSelective(FlywaySchemaHistory record);
}
