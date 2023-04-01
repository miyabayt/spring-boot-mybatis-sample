package com.bigtreetc.mybatis.sample.domain.mapper;

import com.bigtreetc.mybatis.sample.domain.model.StaffRoles;
import com.bigtreetc.mybatis.sample.domain.model.StaffRolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface StaffRolesMapper {
  long countByExample(StaffRolesExample example);

  int deleteByExample(StaffRolesExample example);

  int deleteByPrimaryKey(Long staffRoleId);

  int insert(StaffRoles record);

  int insertSelective(StaffRoles record);

  List<StaffRoles> selectByExampleWithRowbounds(StaffRolesExample example, RowBounds rowBounds);

  List<StaffRoles> selectByExample(StaffRolesExample example);

  StaffRoles selectByPrimaryKey(Long staffRoleId);

  int updateByExampleSelective(
      @Param("record") StaffRoles record, @Param("example") StaffRolesExample example);

  int updateByExample(
      @Param("record") StaffRoles record, @Param("example") StaffRolesExample example);

  int updateByPrimaryKeySelective(StaffRoles record);

  int updateByPrimaryKey(StaffRoles record);

  int upsert(StaffRoles record);

  int upsertSelective(StaffRoles record);
}
