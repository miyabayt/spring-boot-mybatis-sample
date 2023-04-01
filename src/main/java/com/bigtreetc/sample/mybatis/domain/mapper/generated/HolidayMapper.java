package com.bigtreetc.sample.mybatis.domain.mapper.generated;

import com.bigtreetc.sample.mybatis.domain.model.generated.Holiday;
import com.bigtreetc.sample.mybatis.domain.model.generated.HolidayExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cursor.Cursor;

@Mapper
public interface HolidayMapper {
  long countByExample(HolidayExample example);

  int deleteByExample(HolidayExample example);

  int deleteByPrimaryKey(Long id);

  int insert(Holiday record);

  int insertSelective(Holiday record);

  List<Holiday> selectByExample(HolidayExample example);

  Holiday selectByPrimaryKey(Long id);

  int updateByExampleSelective(
      @Param("record") Holiday record, @Param("example") HolidayExample example);

  int updateByExample(@Param("record") Holiday record, @Param("example") HolidayExample example);

  int updateByPrimaryKeySelective(Holiday record);

  int updateByPrimaryKey(Holiday record);

  int batchInsert(@Param("list") List<Holiday> list);

  int batchInsertSelective(
      @Param("list") List<Holiday> list, @Param("selective") Holiday.Column... selective);

  int upsert(Holiday record);

  int upsertSelective(Holiday record);

  Cursor<Holiday> selectWithCursorByExample(HolidayExample example);
}
