package com.bigtreetc.mybatis.sample.domain.mapper;

import com.bigtreetc.mybatis.sample.domain.model.RolePermissions;
import com.bigtreetc.mybatis.sample.domain.model.RolePermissionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface RolePermissionsMapper {
  long countByExample(RolePermissionsExample example);

  int deleteByExample(RolePermissionsExample example);

  int deleteByPrimaryKey(Long rolePermissionId);

  int insert(RolePermissions record);

  int insertSelective(RolePermissions record);

  List<RolePermissions> selectByExampleWithRowbounds(
      RolePermissionsExample example, RowBounds rowBounds);

  List<RolePermissions> selectByExample(RolePermissionsExample example);

  RolePermissions selectByPrimaryKey(Long rolePermissionId);

  int updateByExampleSelective(
      @Param("record") RolePermissions record, @Param("example") RolePermissionsExample example);

  int updateByExample(
      @Param("record") RolePermissions record, @Param("example") RolePermissionsExample example);

  int updateByPrimaryKeySelective(RolePermissions record);

  int updateByPrimaryKey(RolePermissions record);

  int upsert(RolePermissions record);

  int upsertSelective(RolePermissions record);
}
