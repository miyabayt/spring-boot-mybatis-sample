package com.bigtreetc.mybatis.sample;

import com.bigtreetc.mybatis.sample.base.domain.dao.MySqlLimitOffsetInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jdbc.repository.config.MyBatisJdbcConfiguration;

@Configuration
@EnableJdbcRepositories
@Import(MyBatisJdbcConfiguration.class)
public class MybatisConfig {

  @Bean
  public MySqlLimitOffsetInterceptor withRowboundsQueryInterceptor() {
    return new MySqlLimitOffsetInterceptor();
  }
}
