package com.bigtreetc.sample.mybatis.domain.service;

import com.bigtreetc.sample.mybatis.base.domain.service.BaseTransactionalService;
import com.bigtreetc.sample.mybatis.base.util.CsvUtils;
import com.bigtreetc.sample.mybatis.domain.model.generated.Holiday;
import com.bigtreetc.sample.mybatis.domain.model.generated.HolidayExample;
import com.bigtreetc.sample.mybatis.domain.repository.HolidayRepository;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/** 祝日サービス */
@RequiredArgsConstructor
@Service
public class HolidayService extends BaseTransactionalService {

  @NonNull final HolidayRepository holidayRepository;

  /**
   * 祝日マスタを検索します。
   *
   * @param example
   * @param pageable
   * @return
   */
  @Transactional(readOnly = true) // 読み取りのみの場合は指定する
  public Page<Holiday> findAll(HolidayExample example, Pageable pageable) {
    Assert.notNull(example, "example must not be null");
    return holidayRepository.findAll(example, pageable);
  }

  /**
   * 祝日マスタを取得します。
   *
   * @return
   */
  @Transactional(readOnly = true)
  public Optional<Holiday> findOne(HolidayExample example) {
    Assert.notNull(example, "example must not be null");
    return holidayRepository.findOne(example);
  }

  /**
   * 祝日マスタを取得します。
   *
   * @return
   */
  @Transactional(readOnly = true)
  public Holiday findById(final Long id) {
    Assert.notNull(id, "id must not be null");
    return holidayRepository.findById(id);
  }

  /**
   * 祝日マスタを登録します。
   *
   * @param inputHoliday
   * @return
   */
  public Holiday create(final Holiday inputHoliday) {
    Assert.notNull(inputHoliday, "inputHoliday must not be null");
    holidayRepository.create(inputHoliday);
    return inputHoliday;
  }

  /**
   * 祝日マスタを一括登録します。
   *
   * @param holidays
   * @return
   */
  public int createAll(final List<Holiday> holidays) {
    Assert.notNull(holidays, "holidays must not be null");
    return holidayRepository.createAll(holidays);
  }

  /**
   * 祝日マスタを更新します。
   *
   * @param inputHoliday
   * @return
   */
  public Holiday update(final Holiday inputHoliday) {
    Assert.notNull(inputHoliday, "inputHoliday must not be null");
    val holidayId = inputHoliday.getId();
    val version = inputHoliday.getVersion();

    HolidayExample example = new HolidayExample();
    example.createCriteria().andIdEqualTo(holidayId).andVersionEqualTo(version);

    val holiday = holidayRepository.findById(holidayId);
    modelMapper.map(inputHoliday, holiday);
    holidayRepository.update(holiday);

    return holiday;
  }

  /**
   * 祝日マスタを一括更新します。
   *
   * @param holidays
   * @return
   */
  public int updateAll(final List<Holiday> holidays) {
    Assert.notNull(holidays, "holiday must not be null");

    int count = 0;
    for (val holiday : holidays) {
      count += holidayRepository.update(holiday);
    }

    return count;
  }

  /**
   * 祝日マスタを削除します。
   *
   * @return
   */
  public Holiday delete(final Long id) {
    Assert.notNull(id, "id must not be null");
    val holiday = holidayRepository.findById(id);
    holidayRepository.delete(id);
    return holiday;
  }

  /**
   * 祝日マスタを一括削除します。
   *
   * @param holidays
   * @return
   */
  public int deleteAll(final List<Holiday> holidays) {
    Assert.notNull(holidays, "holidays must not be null");

    int count = 0;
    for (val holiday : holidays) {
      val id = holiday.getId();
      count += holidayRepository.delete(id);
    }

    return count;
  }

  /**
   * 祝日マスタを書き出します。
   *
   * @param outputStream
   * @param
   * @return
   */
  @Transactional(readOnly = true) // 読み取りのみの場合は指定する
  public void writeToOutputStream(OutputStream outputStream, HolidayExample example, Class<?> clazz)
      throws IOException {
    Assert.notNull(example, "example must not be null");
    try (val data = holidayRepository.findAll(example)) {
      val stream = StreamSupport.stream(data.spliterator(), false);
      CsvUtils.writeCsv(outputStream, clazz, stream, holiday -> modelMapper.map(holiday, clazz));
    }
  }
}
