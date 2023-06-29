package com.bigtreetc.sample.mybatis.domain.service;

import com.bigtreetc.sample.mybatis.base.domain.service.BaseTransactionalService;
import com.bigtreetc.sample.mybatis.base.util.CsvUtils;
import com.bigtreetc.sample.mybatis.domain.model.generated.CodeCategory;
import com.bigtreetc.sample.mybatis.domain.model.generated.CodeCategoryExample;
import com.bigtreetc.sample.mybatis.domain.repository.CodeCategoryRepository;
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
public class CodeCategoryService extends BaseTransactionalService {

  @NonNull final CodeCategoryRepository codeCategoryRepository;

  /**
   * コード分類マスタを検索します。
   *
   * @param example
   * @param pageable
   * @return
   */
  @Transactional(readOnly = true) // 読み取りのみの場合は指定する
  public Page<CodeCategory> findAll(CodeCategoryExample example, Pageable pageable) {
    Assert.notNull(example, "example must not be null");
    return codeCategoryRepository.findAll(example, pageable);
  }

  /**
   * コード分類マスタを取得します。
   *
   * @return
   */
  @Transactional(readOnly = true)
  public Optional<CodeCategory> findOne(CodeCategoryExample example) {
    Assert.notNull(example, "example must not be null");
    return codeCategoryRepository.findOne(example);
  }

  /**
   * コード分類マスタを取得します。
   *
   * @return
   */
  @Transactional(readOnly = true)
  public CodeCategory findById(final Long id) {
    Assert.notNull(id, "id must not be null");
    return codeCategoryRepository.findById(id);
  }

  /**
   * コード分類マスタを登録します。
   *
   * @param inputCodeCategory
   * @return
   */
  public CodeCategory create(final CodeCategory inputCodeCategory) {
    Assert.notNull(inputCodeCategory, "inputCodeCategory must not be null");
    codeCategoryRepository.create(inputCodeCategory);
    return inputCodeCategory;
  }

  /**
   * コード分類マスタを一括登録します。
   *
   * @param codeCategories
   * @return
   */
  public int createAll(final List<CodeCategory> codeCategories) {
    Assert.notNull(codeCategories, "codeCategories must not be null");
    return codeCategoryRepository.createAll(codeCategories);
  }

  /**
   * コード分類マスタを更新します。
   *
   * @param inputCodeCategory
   * @return
   */
  public CodeCategory update(final CodeCategory inputCodeCategory) {
    Assert.notNull(inputCodeCategory, "inputCodeCategory must not be null");
    val codeCategoryId = inputCodeCategory.getId();
    val version = inputCodeCategory.getVersion();

    CodeCategoryExample example = new CodeCategoryExample();
    example.createCriteria().andIdEqualTo(codeCategoryId).andVersionEqualTo(version);

    val codeCategory = codeCategoryRepository.findById(codeCategoryId);
    modelMapper.map(inputCodeCategory, codeCategory);
    codeCategoryRepository.update(codeCategory);

    return codeCategory;
  }

  /**
   * コード分類マスタを一括更新します。
   *
   * @param codeCategories
   * @return
   */
  public int updateAll(final List<CodeCategory> codeCategories) {
    Assert.notNull(codeCategories, "codeCategories must not be null");

    int count = 0;
    for (val codeCategory : codeCategories) {
      count += codeCategoryRepository.update(codeCategory);
    }

    return count;
  }

  /**
   * コード分類マスタを削除します。
   *
   * @return
   */
  public CodeCategory delete(final Long id) {
    Assert.notNull(id, "id must not be null");
    val codeCategory = codeCategoryRepository.findById(id);
    codeCategoryRepository.delete(id);
    return codeCategory;
  }

  /**
   * コード分類マスタを一括削除します。
   *
   * @param codeCategories
   * @return
   */
  public int deleteAll(final List<CodeCategory> codeCategories) {
    Assert.notNull(codeCategories, "codeCategories must not be null");

    int count = 0;
    for (val codeCategory : codeCategories) {
      val id = codeCategory.getId();
      count += codeCategoryRepository.delete(id);
    }

    return count;
  }

  /**
   * コード分類マスタを書き出します。
   *
   * @param outputStream
   * @param
   * @return
   */
  @Transactional(readOnly = true) // 読み取りのみの場合は指定する
  public void writeToOutputStream(
      OutputStream outputStream, CodeCategoryExample example, Class<?> clazz) throws IOException {
    Assert.notNull(example, "example must not be null");
    try (val data = codeCategoryRepository.findAll(example)) {
      val stream = StreamSupport.stream(data.spliterator(), false);
      CsvUtils.writeCsv(outputStream, clazz, stream, holiday -> modelMapper.map(holiday, clazz));
    }
  }
}
