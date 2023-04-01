package com.bigtreetc.sample.mybatis.domain.mapper.generated;

import com.bigtreetc.sample.mybatis.domain.model.generated.Staff;
import com.bigtreetc.sample.mybatis.domain.model.generated.StaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cursor.Cursor;

@Mapper
public interface StaffMapper {
  long countByExample(StaffExample example);

  int deleteByExample(StaffExample example);

  int deleteByPrimaryKey(Long id);

  int insert(Staff record);

  int insertSelective(Staff record);

  List<Staff> selectByExample(StaffExample example);

  Staff selectByPrimaryKey(Long id);

  int updateByExampleSelective(
      @Param("record") Staff record, @Param("example") StaffExample example);

  int updateByExample(@Param("record") Staff record, @Param("example") StaffExample example);

  int updateByPrimaryKeySelective(Staff record);

  int updateByPrimaryKey(Staff record);

  int batchInsert(@Param("list") List<Staff> list);

  int batchInsertSelective(
      @Param("list") List<Staff> list, @Param("selective") Staff.Column... selective);

  int upsert(Staff record);

  int upsertSelective(Staff record);

  Cursor<Staff> selectWithCursorByExample(StaffExample example);
}
