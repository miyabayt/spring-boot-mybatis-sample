package com.bigtreetc.sample.mybatis.domain.repository;

import com.bigtreetc.sample.mybatis.base.domain.dao.MyBatisContext;
import com.bigtreetc.sample.mybatis.domain.mapper.generated.MailTemplateMapper;
import com.bigtreetc.sample.mybatis.domain.model.generated.MailTemplate;
import com.bigtreetc.sample.mybatis.domain.model.generated.MailTemplateExample;
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
public class MailTemplateRepositoryImpl implements MailTemplateRepository {
  @NonNull final SqlSession sqlSession;

  @NonNull final MailTemplateMapper mailTemplateMapper;

  @Override
  public MailTemplate findById(Long pk1) {
    return mailTemplateMapper.selectByPrimaryKey(pk1);
  }

  @Override
  public Optional<MailTemplate> findOne(MailTemplateExample example) {
    String namespacePrefix = MailTemplateRepository.class.getName();
    List<MailTemplate> list =
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
  public Page<MailTemplate> findAll(MailTemplateExample example, Pageable pageable) {
    String namespacePrefix = MailTemplateRepository.class.getName();
    List<MailTemplate> list =
        sqlSession.selectList(namespacePrefix + ".findAll", new MyBatisContext(example, pageable));
    Long count = sqlSession.selectOne(namespacePrefix + ".count", example);
    return new PageImpl<>(list, pageable, count);
  }

  @Override
  public Cursor<MailTemplate> findAll(MailTemplateExample example) {
    return mailTemplateMapper.selectWithCursorByExample(example);
  }

  @Override
  public int create(MailTemplate mailTemplate) {
    return mailTemplateMapper.insert(mailTemplate);
  }

  @Override
  public int createAll(List<MailTemplate> list) {
    return mailTemplateMapper.batchInsert(list);
  }

  @Override
  public int update(MailTemplate mailTemplate) {
    return mailTemplateMapper.updateByPrimaryKey(mailTemplate);
  }

  @Override
  public int delete(Long pk1) {
    return mailTemplateMapper.deleteByPrimaryKey(pk1);
  }
}
