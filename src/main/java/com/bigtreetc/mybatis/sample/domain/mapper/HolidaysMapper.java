package com.bigtreetc.mybatis.sample.domain.mapper;

import com.bigtreetc.mybatis.sample.domain.model.Holidays;
import com.bigtreetc.mybatis.sample.domain.model.HolidaysExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface HolidaysMapper {
  long countByExample(HolidaysExample example);

  int deleteByExample(HolidaysExample example);

  int deleteByPrimaryKey(Long holidayId);

  int insert(Holidays record);

  int insertSelective(Holidays record);

  List<Holidays> selectByExampleWithRowbounds(HolidaysExample example, RowBounds rowBounds);

  List<Holidays> selectByExample(HolidaysExample example);

  Holidays selectByPrimaryKey(Long holidayId);

  int updateByExampleSelective(
      @Param("record") Holidays record, @Param("example") HolidaysExample example);

  int updateByExample(@Param("record") Holidays record, @Param("example") HolidaysExample example);

  int updateByPrimaryKeySelective(Holidays record);

  int updateByPrimaryKey(Holidays record);

  int upsert(Holidays record);

  int upsertSelective(Holidays record);
}
