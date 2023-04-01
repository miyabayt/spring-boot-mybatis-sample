package com.bigtreetc.sample.mybatis.domain.service;

import com.bigtreetc.sample.mybatis.base.domain.service.BaseTransactionalService;
import com.bigtreetc.sample.mybatis.base.util.CsvUtils;
import com.bigtreetc.sample.mybatis.domain.model.generated.Staff;
import com.bigtreetc.sample.mybatis.domain.model.generated.StaffExample;
import com.bigtreetc.sample.mybatis.domain.repository.StaffRepository;
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

/** 担当者サービス */
@RequiredArgsConstructor
@Service
public class StaffService extends BaseTransactionalService {

  @NonNull final StaffRepository staffRepository;

  /**
   * 担当者マスタを検索します。
   *
   * @param example
   * @param pageable
   * @return
   */
  @Transactional(readOnly = true) // 読み取りのみの場合は指定する
  public Page<Staff> findAll(StaffExample example, Pageable pageable) {
    Assert.notNull(example, "example must not be null");
    return staffRepository.findAll(example, pageable);
  }

  /**
   * 担当者マスタを取得します。
   *
   * @return
   */
  @Transactional(readOnly = true)
  public Optional<Staff> findOne(StaffExample example) {
    Assert.notNull(example, "example must not be null");
    return staffRepository.findOne(example);
  }

  /**
   * 担当者マスタを取得します。
   *
   * @return
   */
  @Transactional(readOnly = true)
  public Staff findById(final Long id) {
    Assert.notNull(id, "id must not be null");
    return staffRepository.findById(id);
  }

  /**
   * 担当者マスタを登録します。
   *
   * @param inputStaff
   * @return
   */
  public Staff create(final Staff inputStaff) {
    Assert.notNull(inputStaff, "inputStaff must not be null");
    staffRepository.create(inputStaff);
    return inputStaff;
  }

  /**
   * 担当者マスタを一括登録します。
   *
   * @param staffs
   * @return
   */
  public int createAll(final List<Staff> staffs) {
    Assert.notNull(staffs, "staffs must not be null");
    return staffRepository.createAll(staffs);
  }

  /**
   * 担当者マスタを更新します。
   *
   * @param inputStaff
   * @return
   */
  public Staff update(final Staff inputStaff) {
    Assert.notNull(inputStaff, "inputStaff must not be null");
    val staffId = inputStaff.getId();
    val version = inputStaff.getVersion();

    StaffExample example = new StaffExample();
    example.createCriteria().andIdEqualTo(staffId).andVersionEqualTo(version);

    // 暫定
    val staff = staffRepository.findById(staffId);
    inputStaff.setCreatedAt(staff.getCreatedAt());
    inputStaff.setCreatedBy(staff.getCreatedBy());
    inputStaff.setUpdatedBy("test");
    staffRepository.update(inputStaff);

    return inputStaff;
  }

  /**
   * 担当者マスタを一括更新します。
   *
   * @param staffs
   * @return
   */
  public int updateAll(final List<Staff> staffs) {
    Assert.notNull(staffs, "staff must not be null");

    int count = 0;
    for (val staff : staffs) {
      count += staffRepository.update(staff);
    }

    return count;
  }

  /**
   * 担当者マスタを削除します。
   *
   * @return
   */
  public Staff delete(final Long id) {
    Assert.notNull(id, "id must not be null");
    val staff = staffRepository.findById(id);
    staffRepository.delete(id);
    return staff;
  }

  /**
   * 担当者マスタを一括削除します。
   *
   * @param staffs
   * @return
   */
  public int deleteAll(final List<Staff> staffs) {
    Assert.notNull(staffs, "staffs must not be null");

    int count = 0;
    for (val staff : staffs) {
      val id = staff.getId();
      count += staffRepository.delete(id);
    }

    return count;
  }

  /**
   * 担当者マスタを書き出します。
   *
   * @param outputStream
   * @param
   * @return
   */
  @Transactional(readOnly = true) // 読み取りのみの場合は指定する
  public void writeToOutputStream(OutputStream outputStream, StaffExample example, Class<?> clazz)
      throws IOException {
    Assert.notNull(example, "example must not be null");
    try (val data = staffRepository.findAll(example)) {
      val stream = StreamSupport.stream(data.spliterator(), false);
      CsvUtils.writeCsv(outputStream, clazz, stream, staff -> modelMapper.map(staff, clazz));
    }
  }
}
