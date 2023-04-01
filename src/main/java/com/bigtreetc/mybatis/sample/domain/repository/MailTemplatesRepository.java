package com.bigtreetc.mybatis.sample.domain.repository;

import com.bigtreetc.mybatis.sample.domain.model.generated.MailTemplates;
import com.bigtreetc.mybatis.sample.domain.model.generated.MailTemplatesExample;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MailTemplatesRepository {
  Page<MailTemplates> findAll(MailTemplatesExample example, Pageable pageable);
}
