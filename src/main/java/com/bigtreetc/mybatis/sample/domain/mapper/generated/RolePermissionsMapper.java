package com.bigtreetc.mybatis.sample.domain.mapper.generated;

import com.bigtreetc.mybatis.sample.domain.model.generated.RolePermissions;
import com.bigtreetc.mybatis.sample.domain.model.generated.RolePermissionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RolePermissionsMapper {
  long countByExample(RolePermissionsExample example);

  int deleteByExample(RolePermissionsExample example);

  int deleteByPrimaryKey(Long rolePermissionId);

  int insert(RolePermissions record);

  int insertSelective(RolePermissions record);

  List<RolePermissions> selectByExample(RolePermissionsExample example);

  RolePermissions selectByPrimaryKey(Long rolePermissionId);

  int updateByExampleSelective(
      @Param("record") RolePermissions record, @Param("example") RolePermissionsExample example);

  int updateByExample(
      @Param("record") RolePermissions record, @Param("example") RolePermissionsExample example);

  int updateByPrimaryKeySelective(RolePermissions record);

  int updateByPrimaryKey(RolePermissions record);

  int batchInsert(@Param("list") List<RolePermissions> list);

  int batchInsertSelective(
      @Param("list") List<RolePermissions> list,
      @Param("selective") RolePermissions.Column... selective);

  int upsert(RolePermissions record);

  int upsertSelective(RolePermissions record);
}
