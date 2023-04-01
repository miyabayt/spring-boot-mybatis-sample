package com.bigtreetc.sample.mybatis.domain.mapper.generated;

import com.bigtreetc.sample.mybatis.domain.model.generated.Permission;
import com.bigtreetc.sample.mybatis.domain.model.generated.PermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cursor.Cursor;

@Mapper
public interface PermissionMapper {
  long countByExample(PermissionExample example);

  int deleteByExample(PermissionExample example);

  int deleteByPrimaryKey(Long id);

  int insert(Permission record);

  int insertSelective(Permission record);

  List<Permission> selectByExample(PermissionExample example);

  Permission selectByPrimaryKey(Long id);

  int updateByExampleSelective(
      @Param("record") Permission record, @Param("example") PermissionExample example);

  int updateByExample(
      @Param("record") Permission record, @Param("example") PermissionExample example);

  int updateByPrimaryKeySelective(Permission record);

  int updateByPrimaryKey(Permission record);

  int batchInsert(@Param("list") List<Permission> list);

  int batchInsertSelective(
      @Param("list") List<Permission> list, @Param("selective") Permission.Column... selective);

  int upsert(Permission record);

  int upsertSelective(Permission record);

  Cursor<Permission> selectWithCursorByExample(PermissionExample example);
}
