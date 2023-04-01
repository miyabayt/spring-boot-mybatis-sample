package com.bigtreetc.mybatis.sample.domain.repository;

import com.bigtreetc.mybatis.sample.domain.model.generated.CodeCategories;
import com.bigtreetc.mybatis.sample.domain.model.generated.CodeCategoriesExample;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CodeCategoriesRepository {
  Page<CodeCategories> findAll(CodeCategoriesExample example, Pageable pageable);
}
