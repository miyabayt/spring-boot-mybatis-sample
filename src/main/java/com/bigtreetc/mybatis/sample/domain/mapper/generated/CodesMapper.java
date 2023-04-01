package com.bigtreetc.mybatis.sample.domain.mapper.generated;

import com.bigtreetc.mybatis.sample.domain.model.generated.Codes;
import com.bigtreetc.mybatis.sample.domain.model.generated.CodesExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CodesMapper {
  long countByExample(CodesExample example);

  int deleteByExample(CodesExample example);

  int deleteByPrimaryKey(Long codeId);

  int insert(Codes record);

  int insertSelective(Codes record);

  List<Codes> selectByExample(CodesExample example);

  Codes selectByPrimaryKey(Long codeId);

  int updateByExampleSelective(
      @Param("record") Codes record, @Param("example") CodesExample example);

  int updateByExample(@Param("record") Codes record, @Param("example") CodesExample example);

  int updateByPrimaryKeySelective(Codes record);

  int updateByPrimaryKey(Codes record);

  int batchInsert(@Param("list") List<Codes> list);

  int batchInsertSelective(
      @Param("list") List<Codes> list, @Param("selective") Codes.Column... selective);

  int upsert(Codes record);

  int upsertSelective(Codes record);
}
