package com.bigtreetc.sample.mybatis.domain.repository;

import com.bigtreetc.sample.mybatis.base.domain.dao.MyBatisContext;
import com.bigtreetc.sample.mybatis.domain.mapper.generated.SendMailQueueMapper;
import com.bigtreetc.sample.mybatis.domain.model.generated.SendMailQueue;
import com.bigtreetc.sample.mybatis.domain.model.generated.SendMailQueueExample;
import com.bigtreetc.sample.mybatis.domain.model.generated.SendMailQueueKey;
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
public class SendMailQueueRepositoryImpl implements SendMailQueueRepository {
  @NonNull final SqlSession sqlSession;

  @NonNull final SendMailQueueMapper sendMailQueueMapper;

  @Override
  public SendMailQueue findById(SendMailQueueKey key) {
    return sendMailQueueMapper.selectByPrimaryKey(key);
  }

  @Override
  public Optional<SendMailQueue> findOne(SendMailQueueExample example) {
    String namespacePrefix = SendMailQueueRepository.class.getName();
    List<SendMailQueue> list =
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
  public Page<SendMailQueue> findAll(SendMailQueueExample example, Pageable pageable) {
    String namespacePrefix = SendMailQueueRepository.class.getName();
    List<SendMailQueue> list =
        sqlSession.selectList(namespacePrefix + ".findAll", new MyBatisContext(example, pageable));
    Long count = sqlSession.selectOne(namespacePrefix + ".count", example);
    return new PageImpl<>(list, pageable, count);
  }

  @Override
  public Cursor<SendMailQueue> findAll(SendMailQueueExample example) {
    return sendMailQueueMapper.selectWithCursorByExample(example);
  }

  @Override
  public int create(SendMailQueue sendMailQueue) {
    return sendMailQueueMapper.insert(sendMailQueue);
  }

  @Override
  public int createAll(List<SendMailQueue> list) {
    return sendMailQueueMapper.batchInsert(list);
  }

  @Override
  public int update(SendMailQueue sendMailQueue) {
    return sendMailQueueMapper.updateByPrimaryKey(sendMailQueue);
  }

  @Override
  public int delete(SendMailQueueKey key) {
    return sendMailQueueMapper.deleteByPrimaryKey(key);
  }
}
