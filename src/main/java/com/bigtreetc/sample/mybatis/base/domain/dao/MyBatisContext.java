package com.bigtreetc.sample.mybatis.base.domain.dao;

public class MyBatisContext {

  private final Object example;
  private final Object pageable;

  public MyBatisContext(Object example) {
    this.example = example;
    this.pageable = null;
  }

  public MyBatisContext(Object example, Object pageable) {
    this.example = example;
    this.pageable = pageable;
  }

  public Object getExample() {
    return example;
  }

  public Object getPageable() {
    return pageable;
  }
}
