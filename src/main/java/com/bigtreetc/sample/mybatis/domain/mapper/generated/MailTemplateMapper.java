package com.bigtreetc.sample.mybatis.domain.mapper.generated;

import com.bigtreetc.sample.mybatis.domain.model.generated.MailTemplate;
import com.bigtreetc.sample.mybatis.domain.model.generated.MailTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cursor.Cursor;

@Mapper
public interface MailTemplateMapper {
  long countByExample(MailTemplateExample example);

  int deleteByExample(MailTemplateExample example);

  int deleteByPrimaryKey(Long id);

  int insert(MailTemplate record);

  int insertSelective(MailTemplate record);

  List<MailTemplate> selectByExampleWithBLOBs(MailTemplateExample example);

  List<MailTemplate> selectByExample(MailTemplateExample example);

  MailTemplate selectByPrimaryKey(Long id);

  int updateByExampleSelective(
      @Param("record") MailTemplate record, @Param("example") MailTemplateExample example);

  int updateByExampleWithBLOBs(
      @Param("record") MailTemplate record, @Param("example") MailTemplateExample example);

  int updateByExample(
      @Param("record") MailTemplate record, @Param("example") MailTemplateExample example);

  int updateByPrimaryKeySelective(MailTemplate record);

  int updateByPrimaryKeyWithBLOBs(MailTemplate record);

  int updateByPrimaryKey(MailTemplate record);

  int batchInsert(@Param("list") List<MailTemplate> list);

  int batchInsertSelective(
      @Param("list") List<MailTemplate> list, @Param("selective") MailTemplate.Column... selective);

  int upsert(MailTemplate record);

  int upsertSelective(MailTemplate record);

  int upsertWithBLOBs(MailTemplate record);

  Cursor<MailTemplate> selectWithCursorByExample(MailTemplateExample example);
}
