package com.bigtreetc.sample.mybatis.domain.repository;

import com.bigtreetc.sample.mybatis.base.domain.dao.MyBatisContext;
import com.bigtreetc.sample.mybatis.domain.mapper.generated.CodeCategoryMapper;
import com.bigtreetc.sample.mybatis.domain.model.generated.CodeCategory;
import com.bigtreetc.sample.mybatis.domain.model.generated.CodeCategoryExample;
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
public class CodeCategoryRepositoryImpl implements CodeCategoryRepository {
  @NonNull final SqlSession sqlSession;

  @NonNull final CodeCategoryMapper codeCategoryMapper;

  @Override
  public CodeCategory findById(Long pk1) {
    return codeCategoryMapper.selectByPrimaryKey(pk1);
  }

  @Override
  public Optional<CodeCategory> findOne(CodeCategoryExample example) {
    String namespacePrefix = CodeCategoryRepository.class.getName();
    List<CodeCategory> list =
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
  public Page<CodeCategory> findAll(CodeCategoryExample example, Pageable pageable) {
    String namespacePrefix = CodeCategoryRepository.class.getName();
    List<CodeCategory> list =
        sqlSession.selectList(namespacePrefix + ".findAll", new MyBatisContext(example, pageable));
    Long count = sqlSession.selectOne(namespacePrefix + ".count", example);
    return new PageImpl<>(list, pageable, count);
  }

  @Override
  public Cursor<CodeCategory> findAll(CodeCategoryExample example) {
    return codeCategoryMapper.selectWithCursorByExample(example);
  }

  @Override
  public int create(CodeCategory codeCategory) {
    return codeCategoryMapper.insert(codeCategory);
  }

  @Override
  public int createAll(List<CodeCategory> list) {
    return codeCategoryMapper.batchInsert(list);
  }

  @Override
  public int update(CodeCategory codeCategory) {
    return codeCategoryMapper.updateByPrimaryKey(codeCategory);
  }

  @Override
  public int delete(Long pk1) {
    return codeCategoryMapper.deleteByPrimaryKey(pk1);
  }
}
