package com.bigtreetc.sample.mybatis.domain.repository;

import com.bigtreetc.sample.mybatis.domain.model.generated.SendMailQueue;
import com.bigtreetc.sample.mybatis.domain.model.generated.SendMailQueueExample;
import com.bigtreetc.sample.mybatis.domain.model.generated.SendMailQueueKey;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SendMailQueueRepository {
  SendMailQueue findById(SendMailQueueKey key);

  Optional<SendMailQueue> findOne(SendMailQueueExample example);

  Page<SendMailQueue> findAll(SendMailQueueExample example, Pageable pageable);

  Cursor<SendMailQueue> findAll(SendMailQueueExample example);

  int create(SendMailQueue sendMailQueue);

  int createAll(List<SendMailQueue> list);

  int update(SendMailQueue sendMailQueue);

  int delete(SendMailQueueKey key);
}
