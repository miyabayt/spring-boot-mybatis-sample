package com.bigtreetc.sample.mybatis.domain.repository.system;

import static org.assertj.core.api.Assertions.assertThat;

import com.bigtreetc.sample.mybatis.BaseTestContainerTest;
import com.bigtreetc.sample.mybatis.base.exception.NoDataFoundException;
import com.bigtreetc.sample.mybatis.domain.model.generated.CodeCategoryExample;
import com.bigtreetc.sample.mybatis.domain.repository.CodeCategoryRepository;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CodeCategoryRepositoryTest extends BaseTestContainerTest {

  @Autowired CodeCategoryRepository codeCategoryRepository;

  @Test
  @DisplayName("リポジトリがNULLではないこと")
  void test1() {
    assertThat(codeCategoryRepository).isNotNull();
  }

  @Test
  @DisplayName("指定した分類コードのレコードが取得できること")
  void test2() {
    val expectedCategoryCode = "target";
    val example = new CodeCategoryExample();
    example.createCriteria().andCategoryCodeEqualTo(expectedCategoryCode);

    val found =
        codeCategoryRepository
            .findOne(example)
            .orElseThrow(
                () ->
                    new NoDataFoundException(
                        "codeCategory_code=" + expectedCategoryCode + " のデータが見つかりません。"));

    assertThat(found).isNotNull();
    assertThat(found.getCategoryCode()).isEqualTo(expectedCategoryCode);
  }
}
