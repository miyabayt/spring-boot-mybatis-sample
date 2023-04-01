package com.bigtreetc.mybatis.sample.domain.mapper;

import com.bigtreetc.mybatis.sample.domain.model.Roles;
import com.bigtreetc.mybatis.sample.domain.model.RolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface RolesMapper {
  long countByExample(RolesExample example);

  int deleteByExample(RolesExample example);

  int deleteByPrimaryKey(Long roleId);

  int insert(Roles record);

  int insertSelective(Roles record);

  List<Roles> selectByExampleWithRowbounds(RolesExample example, RowBounds rowBounds);

  List<Roles> selectByExample(RolesExample example);

  Roles selectByPrimaryKey(Long roleId);

  int updateByExampleSelective(
      @Param("record") Roles record, @Param("example") RolesExample example);

  int updateByExample(@Param("record") Roles record, @Param("example") RolesExample example);

  int updateByPrimaryKeySelective(Roles record);

  int updateByPrimaryKey(Roles record);

  int upsert(Roles record);

  int upsertSelective(Roles record);
}
