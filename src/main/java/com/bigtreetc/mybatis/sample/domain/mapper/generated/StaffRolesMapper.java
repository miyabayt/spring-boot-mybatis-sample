package com.bigtreetc.mybatis.sample.domain.mapper.generated;

import com.bigtreetc.mybatis.sample.domain.model.generated.StaffRoles;
import com.bigtreetc.mybatis.sample.domain.model.generated.StaffRolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StaffRolesMapper {
  long countByExample(StaffRolesExample example);

  int deleteByExample(StaffRolesExample example);

  int deleteByPrimaryKey(Long staffRoleId);

  int insert(StaffRoles record);

  int insertSelective(StaffRoles record);

  List<StaffRoles> selectByExample(StaffRolesExample example);

  StaffRoles selectByPrimaryKey(Long staffRoleId);

  int updateByExampleSelective(
      @Param("record") StaffRoles record, @Param("example") StaffRolesExample example);

  int updateByExample(
      @Param("record") StaffRoles record, @Param("example") StaffRolesExample example);

  int updateByPrimaryKeySelective(StaffRoles record);

  int updateByPrimaryKey(StaffRoles record);

  int batchInsert(@Param("list") List<StaffRoles> list);

  int batchInsertSelective(
      @Param("list") List<StaffRoles> list, @Param("selective") StaffRoles.Column... selective);

  int upsert(StaffRoles record);

  int upsertSelective(StaffRoles record);
}
