package com.bigtreetc.mybatis.sample.controller.holidays;

import com.bigtreetc.mybatis.sample.base.web.controller.api.response.ApiResponse;
import com.bigtreetc.mybatis.sample.base.web.controller.api.response.PageableApiResponseImpl;
import com.bigtreetc.mybatis.sample.base.web.controller.api.response.SimpleApiResponseImpl;
import com.bigtreetc.mybatis.sample.domain.mapper.HolidaysMapper;
import com.bigtreetc.mybatis.sample.domain.model.Holidays;
import com.bigtreetc.mybatis.sample.domain.model.HolidaysExample;
import com.bigtreetc.mybatis.sample.domain.repository.CountRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.ibatis.session.RowBounds;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/system", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class HolidayController {

  @NonNull final ModelMapper modelMapper;

  @NonNull final HolidaysMapper holidaysMapper;

  @NonNull final CountRepository countRepository;

  /**
   * 祝日を登録します。
   *
   * @param request
   * @return
   */
  @PostMapping("/holiday")
  public ApiResponse create(@RequestBody HolidayRequest request) {
    // 入力値からモデルを作成する
    val holiday = modelMapper.map(request, Holidays.class);

    // 1件登録する
    val data = holidaysMapper.insert(holiday);

    val response = new SimpleApiResponseImpl();
    response.success(data);

    return response;
  }

  /**
   * 祝日を検索します。
   *
   * @param request
   * @param pageable
   * @return
   */
  @GetMapping("/holidays")
  public ApiResponse search(@ModelAttribute SearchHolidayRequest request, Pageable pageable) {
    // 入力値からDTOを作成する
    val criteria = modelMapper.map(request, HolidaysExample.class);

    // 10件で区切って取得する
    val rowBounds = new RowBounds((int) pageable.getOffset(), pageable.getPageSize());
    val data = holidaysMapper.selectByExampleWithRowbounds(criteria, rowBounds);
    val count = countRepository.countFoundRows();

    val response = new PageableApiResponseImpl();
    response.success(data);
    response.setCount(count);

    return response;
  }

  /**
   * 祝日を検索します。（POST版）
   *
   * @param request
   * @param pageable
   * @return
   */
  @PostMapping("/holidays/search")
  public ApiResponse searchByPost(@RequestBody SearchHolidayRequest request, Pageable pageable) {
    return search(request, pageable);
  }

  /**
   * 祝日を取得します。
   *
   * @param holidayId
   * @return
   */
  @GetMapping("/holiday/{holidayId}")
  public ApiResponse findOne(@PathVariable Long holidayId) {
    // 1件取得する
    val data = holidaysMapper.selectByPrimaryKey(holidayId);

    val response = new SimpleApiResponseImpl();
    response.success(data);

    return response;
  }

  /**
   * 祝日を更新します。
   *
   * @param holidayId
   * @param request
   * @return
   */
  @PutMapping("/holiday/{holidayId}")
  public ApiResponse update(@PathVariable Long holidayId, @RequestBody HolidayRequest request) {
    // 入力値からDTOを作成する
    val holiday = modelMapper.map(request, Holidays.class);

    // 1件更新する（ない場合は作成する）
    holiday.setHolidayId(holidayId);
    val data = holidaysMapper.upsert(holiday);

    val response = new SimpleApiResponseImpl();
    response.success(data);

    return response;
  }

  /**
   * 祝日を削除します。
   *
   * @param holidayId
   * @return
   */
  @DeleteMapping("/holiday/{holidayId}")
  public ApiResponse delete(@PathVariable Long holidayId) {
    // 1件取得する
    val data = holidaysMapper.deleteByPrimaryKey(holidayId);

    val response = new SimpleApiResponseImpl();
    response.success(data);

    return response;
  }
}
