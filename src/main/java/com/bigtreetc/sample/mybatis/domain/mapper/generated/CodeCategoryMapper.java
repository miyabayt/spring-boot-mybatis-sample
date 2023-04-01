package com.bigtreetc.sample.mybatis.domain.mapper.generated;

import com.bigtreetc.sample.mybatis.domain.model.generated.CodeCategory;
import com.bigtreetc.sample.mybatis.domain.model.generated.CodeCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cursor.Cursor;

@Mapper
public interface CodeCategoryMapper {
  long countByExample(CodeCategoryExample example);

  int deleteByExample(CodeCategoryExample example);

  int deleteByPrimaryKey(Long id);

  int insert(CodeCategory record);

  int insertSelective(CodeCategory record);

  List<CodeCategory> selectByExample(CodeCategoryExample example);

  CodeCategory selectByPrimaryKey(Long id);

  int updateByExampleSelective(
      @Param("record") CodeCategory record, @Param("example") CodeCategoryExample example);

  int updateByExample(
      @Param("record") CodeCategory record, @Param("example") CodeCategoryExample example);

  int updateByPrimaryKeySelective(CodeCategory record);

  int updateByPrimaryKey(CodeCategory record);

  int batchInsert(@Param("list") List<CodeCategory> list);

  int batchInsertSelective(
      @Param("list") List<CodeCategory> list, @Param("selective") CodeCategory.Column... selective);

  int upsert(CodeCategory record);

  int upsertSelective(CodeCategory record);

  Cursor<CodeCategory> selectWithCursorByExample(CodeCategoryExample example);
}
