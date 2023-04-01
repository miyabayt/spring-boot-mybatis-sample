package com.bigtreetc.sample.mybatis.domain.mapper.generated;

import com.bigtreetc.sample.mybatis.domain.model.generated.StaffRole;
import com.bigtreetc.sample.mybatis.domain.model.generated.StaffRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cursor.Cursor;

@Mapper
public interface StaffRoleMapper {
  long countByExample(StaffRoleExample example);

  int deleteByExample(StaffRoleExample example);

  int deleteByPrimaryKey(Long id);

  int insert(StaffRole record);

  int insertSelective(StaffRole record);

  List<StaffRole> selectByExample(StaffRoleExample example);

  StaffRole selectByPrimaryKey(Long id);

  int updateByExampleSelective(
      @Param("record") StaffRole record, @Param("example") StaffRoleExample example);

  int updateByExample(
      @Param("record") StaffRole record, @Param("example") StaffRoleExample example);

  int updateByPrimaryKeySelective(StaffRole record);

  int updateByPrimaryKey(StaffRole record);

  int batchInsert(@Param("list") List<StaffRole> list);

  int batchInsertSelective(
      @Param("list") List<StaffRole> list, @Param("selective") StaffRole.Column... selective);

  int upsert(StaffRole record);

  int upsertSelective(StaffRole record);

  Cursor<StaffRole> selectWithCursorByExample(StaffRoleExample example);
}
