package com.bigtreetc.mybatis.sample.base.domain.model;

import java.time.LocalDateTime;

public interface BaseEntity {

  String getCreatedBy();

  void setCreatedBy(String createdBy);

  LocalDateTime getCreatedAt();

  void setCreatedAt(LocalDateTime createdAt);

  String getUpdatedBy();

  void setUpdatedBy(String updatedBy);

  LocalDateTime getUpdatedAt();

  void setUpdatedAt(LocalDateTime updatedAt);

  Long getVersion();

  void setVersion(Long version);
}
