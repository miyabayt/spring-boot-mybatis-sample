package com.bigtreetc.mybatis.sample.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;

@Getter
@Setter
public class SendMailQueueKey implements Serializable {
  private Long sendMailQueueId;

  @CreatedDate private LocalDateTime createdAt;

  private static final long serialVersionUID = 1L;
}
