package com.bigtreetc.mybatis.sample.domain.mapper.generated;

import com.bigtreetc.mybatis.sample.domain.model.generated.CodeCategories;
import com.bigtreetc.mybatis.sample.domain.model.generated.CodeCategoriesExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CodeCategoriesMapper {
  long countByExample(CodeCategoriesExample example);

  int deleteByExample(CodeCategoriesExample example);

  int deleteByPrimaryKey(Long codeCategoryId);

  int insert(CodeCategories record);

  int insertSelective(CodeCategories record);

  List<CodeCategories> selectByExample(CodeCategoriesExample example);

  CodeCategories selectByPrimaryKey(Long codeCategoryId);

  int updateByExampleSelective(
      @Param("record") CodeCategories record, @Param("example") CodeCategoriesExample example);

  int updateByExample(
      @Param("record") CodeCategories record, @Param("example") CodeCategoriesExample example);

  int updateByPrimaryKeySelective(CodeCategories record);

  int updateByPrimaryKey(CodeCategories record);

  int batchInsert(@Param("list") List<CodeCategories> list);

  int batchInsertSelective(
      @Param("list") List<CodeCategories> list,
      @Param("selective") CodeCategories.Column... selective);

  int upsert(CodeCategories record);

  int upsertSelective(CodeCategories record);
}
