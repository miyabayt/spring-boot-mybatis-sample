package com.bigtreetc.mybatis.sample.domain.mapper;

import com.bigtreetc.mybatis.sample.domain.model.Users;
import com.bigtreetc.mybatis.sample.domain.model.UsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface UsersMapper {
  long countByExample(UsersExample example);

  int deleteByExample(UsersExample example);

  int deleteByPrimaryKey(Long userId);

  int insert(Users record);

  int insertSelective(Users record);

  List<Users> selectByExampleWithRowbounds(UsersExample example, RowBounds rowBounds);

  List<Users> selectByExample(UsersExample example);

  Users selectByPrimaryKey(Long userId);

  int updateByExampleSelective(
      @Param("record") Users record, @Param("example") UsersExample example);

  int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

  int updateByPrimaryKeySelective(Users record);

  int updateByPrimaryKey(Users record);

  int upsert(Users record);

  int upsertSelective(Users record);
}
