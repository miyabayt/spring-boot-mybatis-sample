package com.bigtreetc.sample.mybatis.domain.repository;

import com.bigtreetc.sample.mybatis.domain.model.generated.CodeCategory;
import com.bigtreetc.sample.mybatis.domain.model.generated.CodeCategoryExample;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CodeCategoryRepository {
  CodeCategory findById(Long pk1);

  Optional<CodeCategory> findOne(CodeCategoryExample example);

  Page<CodeCategory> findAll(CodeCategoryExample example, Pageable pageable);

  Cursor<CodeCategory> findAll(CodeCategoryExample example);

  int create(CodeCategory codeCategory);

  int createAll(List<CodeCategory> list);

  int update(CodeCategory codeCategory);

  int delete(Long pk1);
}
