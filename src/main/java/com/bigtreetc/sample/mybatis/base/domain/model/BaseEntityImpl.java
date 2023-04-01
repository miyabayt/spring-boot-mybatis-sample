package com.bigtreetc.sample.mybatis.base.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Setter
@Getter
public abstract class BaseEntityImpl implements BaseEntity, Serializable {

  // 作成者
  @JsonIgnore String createdBy;

  // 作成日時
  LocalDateTime createdAt;

  // 更新者
  @JsonIgnore String updatedBy;

  // 更新日時
  LocalDateTime updatedAt;

  // 楽観的排他制御で使用する改定番号
  Long version;
}
