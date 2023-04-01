package com.bigtreetc.mybatis.sample.domain.mapper;

import com.bigtreetc.mybatis.sample.domain.model.UserRoles;
import com.bigtreetc.mybatis.sample.domain.model.UserRolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface UserRolesMapper {
  long countByExample(UserRolesExample example);

  int deleteByExample(UserRolesExample example);

  int deleteByPrimaryKey(Long userRoleId);

  int insert(UserRoles record);

  int insertSelective(UserRoles record);

  List<UserRoles> selectByExampleWithRowbounds(UserRolesExample example, RowBounds rowBounds);

  List<UserRoles> selectByExample(UserRolesExample example);

  UserRoles selectByPrimaryKey(Long userRoleId);

  int updateByExampleSelective(
      @Param("record") UserRoles record, @Param("example") UserRolesExample example);

  int updateByExample(
      @Param("record") UserRoles record, @Param("example") UserRolesExample example);

  int updateByPrimaryKeySelective(UserRoles record);

  int updateByPrimaryKey(UserRoles record);

  int upsert(UserRoles record);

  int upsertSelective(UserRoles record);
}
