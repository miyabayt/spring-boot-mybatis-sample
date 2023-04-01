package com.bigtreetc.mybatis.sample.domain.mapper;

import com.bigtreetc.mybatis.sample.domain.model.SendMailQueue;
import com.bigtreetc.mybatis.sample.domain.model.SendMailQueueExample;
import com.bigtreetc.mybatis.sample.domain.model.SendMailQueueKey;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface SendMailQueueMapper {
  long countByExample(SendMailQueueExample example);

  int deleteByExample(SendMailQueueExample example);

  int deleteByPrimaryKey(SendMailQueueKey key);

  int insert(SendMailQueue record);

  int insertSelective(SendMailQueue record);

  List<SendMailQueue> selectByExampleWithBLOBsWithRowbounds(
      SendMailQueueExample example, RowBounds rowBounds);

  List<SendMailQueue> selectByExampleWithBLOBs(SendMailQueueExample example);

  List<SendMailQueue> selectByExampleWithRowbounds(
      SendMailQueueExample example, RowBounds rowBounds);

  List<SendMailQueue> selectByExample(SendMailQueueExample example);

  SendMailQueue selectByPrimaryKey(SendMailQueueKey key);

  int updateByExampleSelective(
      @Param("record") SendMailQueue record, @Param("example") SendMailQueueExample example);

  int updateByExampleWithBLOBs(
      @Param("record") SendMailQueue record, @Param("example") SendMailQueueExample example);

  int updateByExample(
      @Param("record") SendMailQueue record, @Param("example") SendMailQueueExample example);

  int updateByPrimaryKeySelective(SendMailQueue record);

  int updateByPrimaryKeyWithBLOBs(SendMailQueue record);

  int updateByPrimaryKey(SendMailQueue record);

  int upsert(SendMailQueue record);

  int upsertSelective(SendMailQueue record);

  int upsertWithBLOBs(SendMailQueue record);
}
