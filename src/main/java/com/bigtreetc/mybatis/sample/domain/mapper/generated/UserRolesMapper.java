package com.bigtreetc.mybatis.sample.domain.mapper.generated;

import com.bigtreetc.mybatis.sample.domain.model.generated.UserRoles;
import com.bigtreetc.mybatis.sample.domain.model.generated.UserRolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRolesMapper {
  long countByExample(UserRolesExample example);

  int deleteByExample(UserRolesExample example);

  int deleteByPrimaryKey(Long userRoleId);

  int insert(UserRoles record);

  int insertSelective(UserRoles record);

  List<UserRoles> selectByExample(UserRolesExample example);

  UserRoles selectByPrimaryKey(Long userRoleId);

  int updateByExampleSelective(
      @Param("record") UserRoles record, @Param("example") UserRolesExample example);

  int updateByExample(
      @Param("record") UserRoles record, @Param("example") UserRolesExample example);

  int updateByPrimaryKeySelective(UserRoles record);

  int updateByPrimaryKey(UserRoles record);

  int batchInsert(@Param("list") List<UserRoles> list);

  int batchInsertSelective(
      @Param("list") List<UserRoles> list, @Param("selective") UserRoles.Column... selective);

  int upsert(UserRoles record);

  int upsertSelective(UserRoles record);
}
