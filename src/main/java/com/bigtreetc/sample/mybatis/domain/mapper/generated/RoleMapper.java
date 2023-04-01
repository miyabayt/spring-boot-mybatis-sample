package com.bigtreetc.sample.mybatis.domain.mapper.generated;

import com.bigtreetc.sample.mybatis.domain.model.generated.Role;
import com.bigtreetc.sample.mybatis.domain.model.generated.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cursor.Cursor;

@Mapper
public interface RoleMapper {
  long countByExample(RoleExample example);

  int deleteByExample(RoleExample example);

  int deleteByPrimaryKey(Long id);

  int insert(Role record);

  int insertSelective(Role record);

  List<Role> selectByExample(RoleExample example);

  Role selectByPrimaryKey(Long id);

  int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

  int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

  int updateByPrimaryKeySelective(Role record);

  int updateByPrimaryKey(Role record);

  int batchInsert(@Param("list") List<Role> list);

  int batchInsertSelective(
      @Param("list") List<Role> list, @Param("selective") Role.Column... selective);

  int upsert(Role record);

  int upsertSelective(Role record);

  Cursor<Role> selectWithCursorByExample(RoleExample example);
}
