package com.bigtreetc.sample.mybatis.domain.mapper.generated;

import com.bigtreetc.sample.mybatis.domain.model.generated.UserRole;
import com.bigtreetc.sample.mybatis.domain.model.generated.UserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cursor.Cursor;

@Mapper
public interface UserRoleMapper {
  long countByExample(UserRoleExample example);

  int deleteByExample(UserRoleExample example);

  int deleteByPrimaryKey(Long id);

  int insert(UserRole record);

  int insertSelective(UserRole record);

  List<UserRole> selectByExample(UserRoleExample example);

  UserRole selectByPrimaryKey(Long id);

  int updateByExampleSelective(
      @Param("record") UserRole record, @Param("example") UserRoleExample example);

  int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleExample example);

  int updateByPrimaryKeySelective(UserRole record);

  int updateByPrimaryKey(UserRole record);

  int batchInsert(@Param("list") List<UserRole> list);

  int batchInsertSelective(
      @Param("list") List<UserRole> list, @Param("selective") UserRole.Column... selective);

  int upsert(UserRole record);

  int upsertSelective(UserRole record);

  Cursor<UserRole> selectWithCursorByExample(UserRoleExample example);
}
