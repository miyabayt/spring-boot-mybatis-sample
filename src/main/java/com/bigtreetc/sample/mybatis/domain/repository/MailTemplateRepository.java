package com.bigtreetc.sample.mybatis.domain.repository;

import com.bigtreetc.sample.mybatis.domain.model.generated.MailTemplate;
import com.bigtreetc.sample.mybatis.domain.model.generated.MailTemplateExample;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MailTemplateRepository {
  MailTemplate findById(Long pk1);

  Optional<MailTemplate> findOne(MailTemplateExample example);

  Page<MailTemplate> findAll(MailTemplateExample example, Pageable pageable);

  Cursor<MailTemplate> findAll(MailTemplateExample example);

  int create(MailTemplate mailTemplate);

  int createAll(List<MailTemplate> list);

  int update(MailTemplate mailTemplate);

  int delete(Long pk1);
}
