package com.bigtreetc.sample.mybatis;

import com.bigtreetc.sample.mybatis.base.domain.dao.AuditInterceptor;
import com.bigtreetc.sample.mybatis.base.domain.dao.VersionColumnOptimisticLockInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisConfig {

  @Bean
  public AuditInterceptor auditInterceptor() {
    return new AuditInterceptor();
  }

  @Bean
  public VersionColumnOptimisticLockInterceptor optimisticLockInterceptor() {
    return new VersionColumnOptimisticLockInterceptor();
  }
}
