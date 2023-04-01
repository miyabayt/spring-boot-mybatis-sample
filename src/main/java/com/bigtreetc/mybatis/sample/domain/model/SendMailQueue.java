package com.bigtreetc.mybatis.sample.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;

@Getter
@Setter
public class SendMailQueue extends SendMailQueueKey implements Serializable {
  private String fromAddress;

  private String toAddress;

  private String ccAddress;

  private String bccAddress;

  private String subject;

  private LocalDateTime sentAt;

  @JsonIgnore @CreatedBy private String createdBy;

  @JsonIgnore @LastModifiedBy private String updatedBy;

  @LastModifiedDate private LocalDateTime updatedAt;

  @Version private Long version;

  private String body;

  private static final long serialVersionUID = 1L;
}
