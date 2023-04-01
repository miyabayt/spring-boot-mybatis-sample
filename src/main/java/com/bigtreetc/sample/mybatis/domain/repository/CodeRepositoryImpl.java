package com.bigtreetc.sample.mybatis.domain.repository;

import com.bigtreetc.sample.mybatis.base.domain.dao.MyBatisContext;
import com.bigtreetc.sample.mybatis.domain.mapper.generated.CodeMapper;
import com.bigtreetc.sample.mybatis.domain.model.generated.Code;
import com.bigtreetc.sample.mybatis.domain.model.generated.CodeExample;
import java.util.List;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CodeRepositoryImpl implements CodeRepository {
  @NonNull final SqlSession sqlSession;

  @NonNull final CodeMapper codeMapper;

  @Override
  public Code findById(Long pk1) {
    return codeMapper.selectByPrimaryKey(pk1);
  }

  @Override
  public Optional<Code> findOne(CodeExample example) {
    String namespacePrefix = CodeRepository.class.getName();
    List<Code> list =
        sqlSession.selectList(
            namespacePrefix + ".findAll", new MyBatisContext(example, Pageable.ofSize(2)));
    if (list.isEmpty()) {
      return Optional.empty();
    }
    if (list.size() >= 2) {
      throw new IncorrectResultSizeDataAccessException(1);
    }
    return Optional.of(list.get(0));
  }

  @Override
  public Page<Code> findAll(CodeExample example, Pageable pageable) {
    String namespacePrefix = CodeRepository.class.getName();
    List<Code> list =
        sqlSession.selectList(namespacePrefix + ".findAll", new MyBatisContext(example, pageable));
    Long count = sqlSession.selectOne(namespacePrefix + ".count", example);
    return new PageImpl<>(list, pageable, count);
  }

  @Override
  public Cursor<Code> findAll(CodeExample example) {
    return codeMapper.selectWithCursorByExample(example);
  }

  @Override
  public int create(Code code) {
    return codeMapper.insert(code);
  }

  @Override
  public int createAll(List<Code> list) {
    return codeMapper.batchInsert(list);
  }

  @Override
  public int update(Code code) {
    return codeMapper.updateByPrimaryKey(code);
  }

  @Override
  public int delete(Long pk1) {
    return codeMapper.deleteByPrimaryKey(pk1);
  }
}
