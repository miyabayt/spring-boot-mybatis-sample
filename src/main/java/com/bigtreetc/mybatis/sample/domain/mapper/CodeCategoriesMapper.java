package com.bigtreetc.mybatis.sample.domain.mapper;

import com.bigtreetc.mybatis.sample.domain.model.CodeCategories;
import com.bigtreetc.mybatis.sample.domain.model.CodeCategoriesExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface CodeCategoriesMapper {
  long countByExample(CodeCategoriesExample example);

  int deleteByExample(CodeCategoriesExample example);

  int deleteByPrimaryKey(Long codeCategoryId);

  int insert(CodeCategories record);

  int insertSelective(CodeCategories record);

  List<CodeCategories> selectByExampleWithRowbounds(
      CodeCategoriesExample example, RowBounds rowBounds);

  List<CodeCategories> selectByExample(CodeCategoriesExample example);

  CodeCategories selectByPrimaryKey(Long codeCategoryId);

  int updateByExampleSelective(
      @Param("record") CodeCategories record, @Param("example") CodeCategoriesExample example);

  int updateByExample(
      @Param("record") CodeCategories record, @Param("example") CodeCategoriesExample example);

  int updateByPrimaryKeySelective(CodeCategories record);

  int updateByPrimaryKey(CodeCategories record);

  int upsert(CodeCategories record);

  int upsertSelective(CodeCategories record);
}
