package com.bigtreetc.mybatis.sample.domain.mapper;

import com.bigtreetc.mybatis.sample.domain.model.MailTemplates;
import com.bigtreetc.mybatis.sample.domain.model.MailTemplatesExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface MailTemplatesMapper {
  long countByExample(MailTemplatesExample example);

  int deleteByExample(MailTemplatesExample example);

  int deleteByPrimaryKey(Long mailTemplateId);

  int insert(MailTemplates record);

  int insertSelective(MailTemplates record);

  List<MailTemplates> selectByExampleWithBLOBsWithRowbounds(
      MailTemplatesExample example, RowBounds rowBounds);

  List<MailTemplates> selectByExampleWithBLOBs(MailTemplatesExample example);

  List<MailTemplates> selectByExampleWithRowbounds(
      MailTemplatesExample example, RowBounds rowBounds);

  List<MailTemplates> selectByExample(MailTemplatesExample example);

  MailTemplates selectByPrimaryKey(Long mailTemplateId);

  int updateByExampleSelective(
      @Param("record") MailTemplates record, @Param("example") MailTemplatesExample example);

  int updateByExampleWithBLOBs(
      @Param("record") MailTemplates record, @Param("example") MailTemplatesExample example);

  int updateByExample(
      @Param("record") MailTemplates record, @Param("example") MailTemplatesExample example);

  int updateByPrimaryKeySelective(MailTemplates record);

  int updateByPrimaryKeyWithBLOBs(MailTemplates record);

  int updateByPrimaryKey(MailTemplates record);

  int upsert(MailTemplates record);

  int upsertSelective(MailTemplates record);

  int upsertWithBLOBs(MailTemplates record);
}
