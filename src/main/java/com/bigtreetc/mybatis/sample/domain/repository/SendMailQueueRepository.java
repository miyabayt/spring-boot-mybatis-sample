package com.bigtreetc.mybatis.sample.domain.repository;

import com.bigtreetc.mybatis.sample.domain.model.generated.SendMailQueue;
import com.bigtreetc.mybatis.sample.domain.model.generated.SendMailQueueExample;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SendMailQueueRepository {
  Page<SendMailQueue> findAll(SendMailQueueExample example, Pageable pageable);
}
