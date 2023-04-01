package com.bigtreetc.sample.mybatis.controller.holidays;

import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HolidayRequest {

  private static final long serialVersionUID = -1L;

  Long id;

  // 祝日名
  @NotEmpty String holidayName;

  // 日付
  LocalDate holidayDate;

  // 更新日付（日付で排他制御する場合に使う）
  LocalDateTime updatedAt;

  // 改定番号（バージョンカラムで排他制御する場合に使う）
  Integer version;
}
