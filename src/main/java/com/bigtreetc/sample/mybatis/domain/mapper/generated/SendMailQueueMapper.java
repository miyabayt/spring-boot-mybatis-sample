package com.bigtreetc.sample.mybatis.domain.mapper.generated;

import com.bigtreetc.sample.mybatis.domain.model.generated.SendMailQueue;
import com.bigtreetc.sample.mybatis.domain.model.generated.SendMailQueueExample;
import com.bigtreetc.sample.mybatis.domain.model.generated.SendMailQueueKey;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cursor.Cursor;

@Mapper
public interface SendMailQueueMapper {
  long countByExample(SendMailQueueExample example);

  int deleteByExample(SendMailQueueExample example);

  int deleteByPrimaryKey(SendMailQueueKey key);

  int insert(SendMailQueue record);

  int insertSelective(SendMailQueue record);

  List<SendMailQueue> selectByExampleWithBLOBs(SendMailQueueExample example);

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

  int batchInsert(@Param("list") List<SendMailQueue> list);

  int batchInsertSelective(
      @Param("list") List<SendMailQueue> list,
      @Param("selective") SendMailQueue.Column... selective);

  int upsert(SendMailQueue record);

  int upsertSelective(SendMailQueue record);

  int upsertWithBLOBs(SendMailQueue record);

  Cursor<SendMailQueue> selectWithCursorByExample(SendMailQueueExample example);
}
