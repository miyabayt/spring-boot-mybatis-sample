package com.bigtreetc.sample.mybatis.domain.mapper.generated;

import com.bigtreetc.sample.mybatis.domain.model.generated.RolePermission;
import com.bigtreetc.sample.mybatis.domain.model.generated.RolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cursor.Cursor;

@Mapper
public interface RolePermissionMapper {
  long countByExample(RolePermissionExample example);

  int deleteByExample(RolePermissionExample example);

  int deleteByPrimaryKey(Long id);

  int insert(RolePermission record);

  int insertSelective(RolePermission record);

  List<RolePermission> selectByExample(RolePermissionExample example);

  RolePermission selectByPrimaryKey(Long id);

  int updateByExampleSelective(
      @Param("record") RolePermission record, @Param("example") RolePermissionExample example);

  int updateByExample(
      @Param("record") RolePermission record, @Param("example") RolePermissionExample example);

  int updateByPrimaryKeySelective(RolePermission record);

  int updateByPrimaryKey(RolePermission record);

  int batchInsert(@Param("list") List<RolePermission> list);

  int batchInsertSelective(
      @Param("list") List<RolePermission> list,
      @Param("selective") RolePermission.Column... selective);

  int upsert(RolePermission record);

  int upsertSelective(RolePermission record);

  Cursor<RolePermission> selectWithCursorByExample(RolePermissionExample example);
}
