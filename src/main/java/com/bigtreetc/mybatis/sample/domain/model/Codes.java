package com.bigtreetc.mybatis.sample.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;

@Getter
@Setter
public class Codes implements Serializable {
  private Long codeId;

  private String categoryCode;

  private String codeValue;

  private String codeName;

  private String codeAlias;

  private Integer displayOrder;

  private Boolean isInvalid;

  @JsonIgnore @CreatedBy private String createdBy;

  @CreatedDate private LocalDateTime createdAt;

  @JsonIgnore @LastModifiedBy private String updatedBy;

  @LastModifiedDate private LocalDateTime updatedAt;

  @Version private Long version;

  private static final long serialVersionUID = 1L;
}
