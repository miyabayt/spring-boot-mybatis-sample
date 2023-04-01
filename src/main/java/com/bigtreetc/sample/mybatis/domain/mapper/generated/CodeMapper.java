package com.bigtreetc.sample.mybatis.domain.mapper.generated;

import com.bigtreetc.sample.mybatis.domain.model.generated.Code;
import com.bigtreetc.sample.mybatis.domain.model.generated.CodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cursor.Cursor;

@Mapper
public interface CodeMapper {
  long countByExample(CodeExample example);

  int deleteByExample(CodeExample example);

  int deleteByPrimaryKey(Long id);

  int insert(Code record);

  int insertSelective(Code record);

  List<Code> selectByExample(CodeExample example);

  Code selectByPrimaryKey(Long id);

  int updateByExampleSelective(@Param("record") Code record, @Param("example") CodeExample example);

  int updateByExample(@Param("record") Code record, @Param("example") CodeExample example);

  int updateByPrimaryKeySelective(Code record);

  int updateByPrimaryKey(Code record);

  int batchInsert(@Param("list") List<Code> list);

  int batchInsertSelective(
      @Param("list") List<Code> list, @Param("selective") Code.Column... selective);

  int upsert(Code record);

  int upsertSelective(Code record);

  Cursor<Code> selectWithCursorByExample(CodeExample example);
}
