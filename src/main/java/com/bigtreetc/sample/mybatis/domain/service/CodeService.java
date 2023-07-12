package com.bigtreetc.sample.mybatis.domain.service;

import com.bigtreetc.sample.mybatis.base.domain.service.BaseTransactionalService;
import com.bigtreetc.sample.mybatis.base.util.CsvUtils;
import com.bigtreetc.sample.mybatis.domain.model.generated.Code;
import com.bigtreetc.sample.mybatis.domain.model.generated.CodeExample;
import com.bigtreetc.sample.mybatis.domain.repository.CodeRepository;
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

/** コードマスタサービス */
@RequiredArgsConstructor
@Service
public class CodeService extends BaseTransactionalService {

  @NonNull final CodeRepository codeRepository;

  /**
   * コードマスタを検索します。
   *
   * @param example
   * @param pageable
   * @return
   */
  @Transactional(readOnly = true) // 読み取りのみの場合は指定する
  public Page<Code> findAll(CodeExample example, Pageable pageable) {
    Assert.notNull(example, "example must not be null");
    return codeRepository.findAll(example, pageable);
  }

  /**
   * コードマスタを取得します。
   *
   * @return
   */
  @Transactional(readOnly = true)
  public Optional<Code> findOne(CodeExample example) {
    Assert.notNull(example, "example must not be null");
    return codeRepository.findOne(example);
  }

  /**
   * コードマスタを取得します。
   *
   * @return
   */
  @Transactional(readOnly = true)
  public Code findById(final Long id) {
    Assert.notNull(id, "id must not be null");
    return codeRepository.findById(id);
  }

  /**
   * コードマスタを登録します。
   *
   * @param inputCode
   * @return
   */
  public Code create(final Code inputCode) {
    Assert.notNull(inputCode, "inputCode must not be null");
    codeRepository.create(inputCode);
    return inputCode;
  }

  /**
   * コードマスタを一括登録します。
   *
   * @param codes
   * @return
   */
  public int createAll(final List<Code> codes) {
    Assert.notNull(codes, "codes must not be null");
    return codeRepository.createAll(codes);
  }

  /**
   * コードマスタを更新します。
   *
   * @param inputCode
   * @return
   */
  public Code update(final Code inputCode) {
    Assert.notNull(inputCode, "inputCode must not be null");
    val codeId = inputCode.getId();
    val code = codeRepository.findById(codeId);
    modelMapper.map(inputCode, code);
    codeRepository.update(code);
    return code;
  }

  /**
   * コードマスタを一括更新します。
   *
   * @param codes
   * @return
   */
  public int updateAll(final List<Code> codes) {
    Assert.notNull(codes, "code must not be null");

    int count = 0;
    for (val code : codes) {
      count += codeRepository.update(code);
    }

    return count;
  }

  /**
   * コードマスタを削除します。
   *
   * @return
   */
  public Code delete(final Long id) {
    Assert.notNull(id, "id must not be null");
    val code = codeRepository.findById(id);
    codeRepository.delete(id);
    return code;
  }

  /**
   * コードマスタを一括削除します。
   *
   * @param codes
   * @return
   */
  public int deleteAll(final List<Code> codes) {
    Assert.notNull(codes, "codes must not be null");

    int count = 0;
    for (val code : codes) {
      val id = code.getId();
      count += codeRepository.delete(id);
    }

    return count;
  }

  /**
   * コードマスタを書き出します。
   *
   * @param outputStream
   * @param
   * @return
   */
  @Transactional(readOnly = true) // 読み取りのみの場合は指定する
  public void writeToOutputStream(OutputStream outputStream, CodeExample example, Class<?> clazz)
      throws IOException {
    Assert.notNull(example, "example must not be null");
    try (val data = codeRepository.findAll(example)) {
      val stream = StreamSupport.stream(data.spliterator(), false);
      CsvUtils.writeCsv(outputStream, clazz, stream, code -> modelMapper.map(code, clazz));
    }
  }
}
