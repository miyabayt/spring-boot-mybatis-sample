package com.bigtreetc.mybatis.sample.domain.mapper;

import com.bigtreetc.mybatis.sample.domain.model.Permissions;
import com.bigtreetc.mybatis.sample.domain.model.PermissionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface PermissionsMapper {
  long countByExample(PermissionsExample example);

  int deleteByExample(PermissionsExample example);

  int deleteByPrimaryKey(Long permissionId);

  int insert(Permissions record);

  int insertSelective(Permissions record);

  List<Permissions> selectByExampleWithRowbounds(PermissionsExample example, RowBounds rowBounds);

  List<Permissions> selectByExample(PermissionsExample example);

  Permissions selectByPrimaryKey(Long permissionId);

  int updateByExampleSelective(
      @Param("record") Permissions record, @Param("example") PermissionsExample example);

  int updateByExample(
      @Param("record") Permissions record, @Param("example") PermissionsExample example);

  int updateByPrimaryKeySelective(Permissions record);

  int updateByPrimaryKey(Permissions record);

  int upsert(Permissions record);

  int upsertSelective(Permissions record);
}
