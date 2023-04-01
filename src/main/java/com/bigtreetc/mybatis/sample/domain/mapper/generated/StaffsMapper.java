package com.bigtreetc.mybatis.sample.domain.mapper.generated;

import com.bigtreetc.mybatis.sample.domain.model.generated.Staffs;
import com.bigtreetc.mybatis.sample.domain.model.generated.StaffsExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StaffsMapper {
  long countByExample(StaffsExample example);

  int deleteByExample(StaffsExample example);

  int deleteByPrimaryKey(Long staffId);

  int insert(Staffs record);

  int insertSelective(Staffs record);

  List<Staffs> selectByExample(StaffsExample example);

  Staffs selectByPrimaryKey(Long staffId);

  int updateByExampleSelective(
      @Param("record") Staffs record, @Param("example") StaffsExample example);

  int updateByExample(@Param("record") Staffs record, @Param("example") StaffsExample example);

  int updateByPrimaryKeySelective(Staffs record);

  int updateByPrimaryKey(Staffs record);

  int batchInsert(@Param("list") List<Staffs> list);

  int batchInsertSelective(
      @Param("list") List<Staffs> list, @Param("selective") Staffs.Column... selective);

  int upsert(Staffs record);

  int upsertSelective(Staffs record);
}
