package com.bigtreetc.mybatis.sample.domain.service;

import com.bigtreetc.mybatis.sample.base.domain.service.BaseTransactionalService;
import com.bigtreetc.mybatis.sample.domain.mapper.generated.HolidaysMapper;
import com.bigtreetc.mybatis.sample.domain.model.generated.Holidays;
import com.bigtreetc.mybatis.sample.domain.model.generated.HolidaysExample;
import com.bigtreetc.mybatis.sample.domain.repository.HolidaysRepository;
import java.util.List;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/** 祝日サービス */
@RequiredArgsConstructor
@Service
public class HolidayService extends BaseTransactionalService {

  @NonNull final HolidaysMapper holidaysMapper; // TODO

  @NonNull final HolidaysRepository holidaysRepository;

  /**
   * 祝日を複数取得します。
   *
   * @param example
   * @param pageable
   * @return
   */
  @Transactional(readOnly = true) // 読み取りのみの場合は指定する
  public Page<Holidays> findAll(HolidaysExample example, Pageable pageable) {
    Assert.notNull(example, "example must not be null");
    return holidaysRepository.findAll(example, pageable);
  }

  /**
   * 祝日を取得します。
   *
   * @return
   */
  @Transactional(readOnly = true)
  public Optional<Holidays> findOne(HolidaysExample example) {
    Assert.notNull(example, "example must not be null");
    val holidays = holidaysMapper.selectByExample(example);

    if (holidays.size() > 1) {
      throw new IncorrectResultSizeDataAccessException(holidays.size());
    }

    return Optional.of(holidays.get(0));
  }

  /**
   * 祝日を取得します。
   *
   * @return
   */
  @Transactional(readOnly = true)
  public Holidays findById(final Long id) {
    Assert.notNull(id, "id must not be null");
    return holidaysMapper.selectByPrimaryKey(id);
  }

  /**
   * 祝日を登録します。
   *
   * @param inputHoliday
   * @return
   */
  public Holidays create(final Holidays inputHoliday) {
    Assert.notNull(inputHoliday, "inputHoliday must not be null");
    holidaysMapper.insert(inputHoliday);
    return inputHoliday;
  }

  /**
   * コードを一括登録します。
   *
   * @param holidays
   * @return
   */
  public int createAll(final List<Holidays> holidays) {
    Assert.notNull(holidays, "holidays must not be null");
    return holidaysMapper.batchInsert(holidays);
  }

  /**
   * 祝日を更新します。
   *
   * @param inputHoliday
   * @return
   */
  public Holidays update(final Holidays inputHoliday) {
    Assert.notNull(inputHoliday, "inputHoliday must not be null");
    holidaysMapper.updateByPrimaryKey(inputHoliday);
    return inputHoliday;
  }

  /**
   * コードを一括更新します。
   *
   * @param holidays
   * @return
   */
  public int updateAll(final List<Holidays> holidays) {
    Assert.notNull(holidays, "holiday must not be null");

    int count = 0;
    for (val holiday : holidays) {
      count += holidaysMapper.updateByPrimaryKey(holiday);
    }

    return count;
  }

  /**
   * 祝日を削除します。
   *
   * @return
   */
  public Holidays delete(final Long id) {
    Assert.notNull(id, "id must not be null");
    val holiday = holidaysMapper.selectByPrimaryKey(id);
    holidaysMapper.deleteByPrimaryKey(id);
    return holiday;
  }

  /**
   * コードを一括削除します。
   *
   * @param holidays
   * @return
   */
  public int deleteAll(final List<Holidays> holidays) {
    Assert.notNull(holidays, "holidays must not be null");

    int count = 0;
    for (val holiday : holidays) {
      val id = holiday.getHolidayId();
      count += holidaysMapper.deleteByPrimaryKey(id);
    }

    return count;
  }
}
