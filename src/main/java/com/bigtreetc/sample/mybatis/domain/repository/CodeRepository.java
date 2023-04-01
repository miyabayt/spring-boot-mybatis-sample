package com.bigtreetc.sample.mybatis.domain.repository;

import com.bigtreetc.sample.mybatis.domain.model.generated.Code;
import com.bigtreetc.sample.mybatis.domain.model.generated.CodeExample;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CodeRepository {
  Code findById(Long pk1);

  Optional<Code> findOne(CodeExample example);

  Page<Code> findAll(CodeExample example, Pageable pageable);

  Cursor<Code> findAll(CodeExample example);

  int create(Code code);

  int createAll(List<Code> list);

  int update(Code code);

  int delete(Long pk1);
}
