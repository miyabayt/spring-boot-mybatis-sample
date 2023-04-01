package com.bigtreetc.mybatis.sample.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;

@Getter
@Setter
public class FlywaySchemaHistory implements Serializable {
  private Integer installedRank;

  @Version private String version;

  private String description;

  private String type;

  private String script;

  private Integer checksum;

  private String installedBy;

  private LocalDateTime installedOn;

  private Integer executionTime;

  private Boolean success;

  private static final long serialVersionUID = 1L;
}
