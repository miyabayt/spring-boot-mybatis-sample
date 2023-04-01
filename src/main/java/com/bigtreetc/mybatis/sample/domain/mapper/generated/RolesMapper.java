package com.bigtreetc.mybatis.sample.domain.mapper.generated;

import com.bigtreetc.mybatis.sample.domain.model.generated.Roles;
import com.bigtreetc.mybatis.sample.domain.model.generated.RolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RolesMapper {
  long countByExample(RolesExample example);

  int deleteByExample(RolesExample example);

  int deleteByPrimaryKey(Long roleId);

  int insert(Roles record);

  int insertSelective(Roles record);

  List<Roles> selectByExample(RolesExample example);

  Roles selectByPrimaryKey(Long roleId);

  int updateByExampleSelective(
      @Param("record") Roles record, @Param("example") RolesExample example);

  int updateByExample(@Param("record") Roles record, @Param("example") RolesExample example);

  int updateByPrimaryKeySelective(Roles record);

  int updateByPrimaryKey(Roles record);

  int batchInsert(@Param("list") List<Roles> list);

  int batchInsertSelective(
      @Param("list") List<Roles> list, @Param("selective") Roles.Column... selective);

  int upsert(Roles record);

  int upsertSelective(Roles record);
}
