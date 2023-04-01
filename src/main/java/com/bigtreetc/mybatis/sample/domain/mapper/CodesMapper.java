package com.bigtreetc.mybatis.sample.domain.mapper;

import com.bigtreetc.mybatis.sample.domain.model.Codes;
import com.bigtreetc.mybatis.sample.domain.model.CodesExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface CodesMapper {
  long countByExample(CodesExample example);

  int deleteByExample(CodesExample example);

  int deleteByPrimaryKey(Long codeId);

  int insert(Codes record);

  int insertSelective(Codes record);

  List<Codes> selectByExampleWithRowbounds(CodesExample example, RowBounds rowBounds);

  List<Codes> selectByExample(CodesExample example);

  Codes selectByPrimaryKey(Long codeId);

  int updateByExampleSelective(
      @Param("record") Codes record, @Param("example") CodesExample example);

  int updateByExample(@Param("record") Codes record, @Param("example") CodesExample example);

  int updateByPrimaryKeySelective(Codes record);

  int updateByPrimaryKey(Codes record);

  int upsert(Codes record);

  int upsertSelective(Codes record);
}
