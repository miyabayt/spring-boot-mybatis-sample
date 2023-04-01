package com.bigtreetc.mybatis.sample.domain.mapper.generated;

import com.bigtreetc.mybatis.sample.domain.model.generated.Permissions;
import com.bigtreetc.mybatis.sample.domain.model.generated.PermissionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PermissionsMapper {
  long countByExample(PermissionsExample example);

  int deleteByExample(PermissionsExample example);

  int deleteByPrimaryKey(Long permissionId);

  int insert(Permissions record);

  int insertSelective(Permissions record);

  List<Permissions> selectByExample(PermissionsExample example);

  Permissions selectByPrimaryKey(Long permissionId);

  int updateByExampleSelective(
      @Param("record") Permissions record, @Param("example") PermissionsExample example);

  int updateByExample(
      @Param("record") Permissions record, @Param("example") PermissionsExample example);

  int updateByPrimaryKeySelective(Permissions record);

  int updateByPrimaryKey(Permissions record);

  int batchInsert(@Param("list") List<Permissions> list);

  int batchInsertSelective(
      @Param("list") List<Permissions> list, @Param("selective") Permissions.Column... selective);

  int upsert(Permissions record);

  int upsertSelective(Permissions record);
}
