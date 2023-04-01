package com.bigtreetc.mybatis.sample.domain.mapper;

import com.bigtreetc.mybatis.sample.domain.model.Staffs;
import com.bigtreetc.mybatis.sample.domain.model.StaffsExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface StaffsMapper {
  long countByExample(StaffsExample example);

  int deleteByExample(StaffsExample example);

  int deleteByPrimaryKey(Long staffId);

  int insert(Staffs record);

  int insertSelective(Staffs record);

  List<Staffs> selectByExampleWithRowbounds(StaffsExample example, RowBounds rowBounds);

  List<Staffs> selectByExample(StaffsExample example);

  Staffs selectByPrimaryKey(Long staffId);

  int updateByExampleSelective(
      @Param("record") Staffs record, @Param("example") StaffsExample example);

  int updateByExample(@Param("record") Staffs record, @Param("example") StaffsExample example);

  int updateByPrimaryKeySelective(Staffs record);

  int updateByPrimaryKey(Staffs record);

  int upsert(Staffs record);

  int upsertSelective(Staffs record);
}
