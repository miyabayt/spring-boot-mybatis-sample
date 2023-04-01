package com.bigtreetc.mybatis.sample.domain.mapper.generated;

import com.bigtreetc.mybatis.sample.domain.model.generated.Users;
import com.bigtreetc.mybatis.sample.domain.model.generated.UsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UsersMapper {
  long countByExample(UsersExample example);

  int deleteByExample(UsersExample example);

  int deleteByPrimaryKey(Long userId);

  int insert(Users record);

  int insertSelective(Users record);

  List<Users> selectByExample(UsersExample example);

  Users selectByPrimaryKey(Long userId);

  int updateByExampleSelective(
      @Param("record") Users record, @Param("example") UsersExample example);

  int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

  int updateByPrimaryKeySelective(Users record);

  int updateByPrimaryKey(Users record);

  int batchInsert(@Param("list") List<Users> list);

  int batchInsertSelective(
      @Param("list") List<Users> list, @Param("selective") Users.Column... selective);

  int upsert(Users record);

  int upsertSelective(Users record);
}
