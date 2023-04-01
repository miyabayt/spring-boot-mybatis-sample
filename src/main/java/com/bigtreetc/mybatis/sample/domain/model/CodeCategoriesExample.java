package com.bigtreetc.mybatis.sample.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CodeCategoriesExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public CodeCategoriesExample() {
    oredCriteria = new ArrayList<Criteria>();
  }

  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  public String getOrderByClause() {
    return orderByClause;
  }

  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  public boolean isDistinct() {
    return distinct;
  }

  public List<Criteria> getOredCriteria() {
    return oredCriteria;
  }

  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  public Criteria or() {
    Criteria criteria = createCriteriaInternal();
    oredCriteria.add(criteria);
    return criteria;
  }

  public Criteria createCriteria() {
    Criteria criteria = createCriteriaInternal();
    if (oredCriteria.size() == 0) {
      oredCriteria.add(criteria);
    }
    return criteria;
  }

  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  public void clear() {
    oredCriteria.clear();
    orderByClause = null;
    distinct = false;
  }

  protected abstract static class GeneratedCriteria {
    protected List<Criterion> criteria;

    protected GeneratedCriteria() {
      super();
      criteria = new ArrayList<Criterion>();
    }

    public boolean isValid() {
      return criteria.size() > 0;
    }

    public List<Criterion> getAllCriteria() {
      return criteria;
    }

    public List<Criterion> getCriteria() {
      return criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      criteria.add(new Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      criteria.add(new Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if (value1 == null || value2 == null) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      criteria.add(new Criterion(condition, value1, value2));
    }

    public Criteria andCodeCategoryIdIsNull() {
      addCriterion("code_category_id is null");
      return (Criteria) this;
    }

    public Criteria andCodeCategoryIdIsNotNull() {
      addCriterion("code_category_id is not null");
      return (Criteria) this;
    }

    public Criteria andCodeCategoryIdEqualTo(Long value) {
      addCriterion("code_category_id =", value, "codeCategoryId");
      return (Criteria) this;
    }

    public Criteria andCodeCategoryIdNotEqualTo(Long value) {
      addCriterion("code_category_id <>", value, "codeCategoryId");
      return (Criteria) this;
    }

    public Criteria andCodeCategoryIdGreaterThan(Long value) {
      addCriterion("code_category_id >", value, "codeCategoryId");
      return (Criteria) this;
    }

    public Criteria andCodeCategoryIdGreaterThanOrEqualTo(Long value) {
      addCriterion("code_category_id >=", value, "codeCategoryId");
      return (Criteria) this;
    }

    public Criteria andCodeCategoryIdLessThan(Long value) {
      addCriterion("code_category_id <", value, "codeCategoryId");
      return (Criteria) this;
    }

    public Criteria andCodeCategoryIdLessThanOrEqualTo(Long value) {
      addCriterion("code_category_id <=", value, "codeCategoryId");
      return (Criteria) this;
    }

    public Criteria andCodeCategoryIdIn(List<Long> values) {
      addCriterion("code_category_id in", values, "codeCategoryId");
      return (Criteria) this;
    }

    public Criteria andCodeCategoryIdNotIn(List<Long> values) {
      addCriterion("code_category_id not in", values, "codeCategoryId");
      return (Criteria) this;
    }

    public Criteria andCodeCategoryIdBetween(Long value1, Long value2) {
      addCriterion("code_category_id between", value1, value2, "codeCategoryId");
      return (Criteria) this;
    }

    public Criteria andCodeCategoryIdNotBetween(Long value1, Long value2) {
      addCriterion("code_category_id not between", value1, value2, "codeCategoryId");
      return (Criteria) this;
    }

    public Criteria andCategoryCodeIsNull() {
      addCriterion("category_code is null");
      return (Criteria) this;
    }

    public Criteria andCategoryCodeIsNotNull() {
      addCriterion("category_code is not null");
      return (Criteria) this;
    }

    public Criteria andCategoryCodeEqualTo(String value) {
      addCriterion("category_code =", value, "categoryCode");
      return (Criteria) this;
    }

    public Criteria andCategoryCodeNotEqualTo(String value) {
      addCriterion("category_code <>", value, "categoryCode");
      return (Criteria) this;
    }

    public Criteria andCategoryCodeGreaterThan(String value) {
      addCriterion("category_code >", value, "categoryCode");
      return (Criteria) this;
    }

    public Criteria andCategoryCodeGreaterThanOrEqualTo(String value) {
      addCriterion("category_code >=", value, "categoryCode");
      return (Criteria) this;
    }

    public Criteria andCategoryCodeLessThan(String value) {
      addCriterion("category_code <", value, "categoryCode");
      return (Criteria) this;
    }

    public Criteria andCategoryCodeLessThanOrEqualTo(String value) {
      addCriterion("category_code <=", value, "categoryCode");
      return (Criteria) this;
    }

    public Criteria andCategoryCodeLike(String value) {
      addCriterion("category_code like", value, "categoryCode");
      return (Criteria) this;
    }

    public Criteria andCategoryCodeNotLike(String value) {
      addCriterion("category_code not like", value, "categoryCode");
      return (Criteria) this;
    }

    public Criteria andCategoryCodeIn(List<String> values) {
      addCriterion("category_code in", values, "categoryCode");
      return (Criteria) this;
    }

    public Criteria andCategoryCodeNotIn(List<String> values) {
      addCriterion("category_code not in", values, "categoryCode");
      return (Criteria) this;
    }

    public Criteria andCategoryCodeBetween(String value1, String value2) {
      addCriterion("category_code between", value1, value2, "categoryCode");
      return (Criteria) this;
    }

    public Criteria andCategoryCodeNotBetween(String value1, String value2) {
      addCriterion("category_code not between", value1, value2, "categoryCode");
      return (Criteria) this;
    }

    public Criteria andCategoryNameIsNull() {
      addCriterion("category_name is null");
      return (Criteria) this;
    }

    public Criteria andCategoryNameIsNotNull() {
      addCriterion("category_name is not null");
      return (Criteria) this;
    }

    public Criteria andCategoryNameEqualTo(String value) {
      addCriterion("category_name =", value, "categoryName");
      return (Criteria) this;
    }

    public Criteria andCategoryNameNotEqualTo(String value) {
      addCriterion("category_name <>", value, "categoryName");
      return (Criteria) this;
    }

    public Criteria andCategoryNameGreaterThan(String value) {
      addCriterion("category_name >", value, "categoryName");
      return (Criteria) this;
    }

    public Criteria andCategoryNameGreaterThanOrEqualTo(String value) {
      addCriterion("category_name >=", value, "categoryName");
      return (Criteria) this;
    }

    public Criteria andCategoryNameLessThan(String value) {
      addCriterion("category_name <", value, "categoryName");
      return (Criteria) this;
    }

    public Criteria andCategoryNameLessThanOrEqualTo(String value) {
      addCriterion("category_name <=", value, "categoryName");
      return (Criteria) this;
    }

    public Criteria andCategoryNameLike(String value) {
      addCriterion("category_name like", value, "categoryName");
      return (Criteria) this;
    }

    public Criteria andCategoryNameNotLike(String value) {
      addCriterion("category_name not like", value, "categoryName");
      return (Criteria) this;
    }

    public Criteria andCategoryNameIn(List<String> values) {
      addCriterion("category_name in", values, "categoryName");
      return (Criteria) this;
    }

    public Criteria andCategoryNameNotIn(List<String> values) {
      addCriterion("category_name not in", values, "categoryName");
      return (Criteria) this;
    }

    public Criteria andCategoryNameBetween(String value1, String value2) {
      addCriterion("category_name between", value1, value2, "categoryName");
      return (Criteria) this;
    }

    public Criteria andCategoryNameNotBetween(String value1, String value2) {
      addCriterion("category_name not between", value1, value2, "categoryName");
      return (Criteria) this;
    }

    public Criteria andCreatedByIsNull() {
      addCriterion("created_by is null");
      return (Criteria) this;
    }

    public Criteria andCreatedByIsNotNull() {
      addCriterion("created_by is not null");
      return (Criteria) this;
    }

    public Criteria andCreatedByEqualTo(String value) {
      addCriterion("created_by =", value, "createdBy");
      return (Criteria) this;
    }

    public Criteria andCreatedByNotEqualTo(String value) {
      addCriterion("created_by <>", value, "createdBy");
      return (Criteria) this;
    }

    public Criteria andCreatedByGreaterThan(String value) {
      addCriterion("created_by >", value, "createdBy");
      return (Criteria) this;
    }

    public Criteria andCreatedByGreaterThanOrEqualTo(String value) {
      addCriterion("created_by >=", value, "createdBy");
      return (Criteria) this;
    }

    public Criteria andCreatedByLessThan(String value) {
      addCriterion("created_by <", value, "createdBy");
      return (Criteria) this;
    }

    public Criteria andCreatedByLessThanOrEqualTo(String value) {
      addCriterion("created_by <=", value, "createdBy");
      return (Criteria) this;
    }

    public Criteria andCreatedByLike(String value) {
      addCriterion("created_by like", value, "createdBy");
      return (Criteria) this;
    }

    public Criteria andCreatedByNotLike(String value) {
      addCriterion("created_by not like", value, "createdBy");
      return (Criteria) this;
    }

    public Criteria andCreatedByIn(List<String> values) {
      addCriterion("created_by in", values, "createdBy");
      return (Criteria) this;
    }

    public Criteria andCreatedByNotIn(List<String> values) {
      addCriterion("created_by not in", values, "createdBy");
      return (Criteria) this;
    }

    public Criteria andCreatedByBetween(String value1, String value2) {
      addCriterion("created_by between", value1, value2, "createdBy");
      return (Criteria) this;
    }

    public Criteria andCreatedByNotBetween(String value1, String value2) {
      addCriterion("created_by not between", value1, value2, "createdBy");
      return (Criteria) this;
    }

    public Criteria andCreatedAtIsNull() {
      addCriterion("created_at is null");
      return (Criteria) this;
    }

    public Criteria andCreatedAtIsNotNull() {
      addCriterion("created_at is not null");
      return (Criteria) this;
    }

    public Criteria andCreatedAtEqualTo(LocalDateTime value) {
      addCriterion("created_at =", value, "createdAt");
      return (Criteria) this;
    }

    public Criteria andCreatedAtNotEqualTo(LocalDateTime value) {
      addCriterion("created_at <>", value, "createdAt");
      return (Criteria) this;
    }

    public Criteria andCreatedAtGreaterThan(LocalDateTime value) {
      addCriterion("created_at >", value, "createdAt");
      return (Criteria) this;
    }

    public Criteria andCreatedAtGreaterThanOrEqualTo(LocalDateTime value) {
      addCriterion("created_at >=", value, "createdAt");
      return (Criteria) this;
    }

    public Criteria andCreatedAtLessThan(LocalDateTime value) {
      addCriterion("created_at <", value, "createdAt");
      return (Criteria) this;
    }

    public Criteria andCreatedAtLessThanOrEqualTo(LocalDateTime value) {
      addCriterion("created_at <=", value, "createdAt");
      return (Criteria) this;
    }

    public Criteria andCreatedAtIn(List<LocalDateTime> values) {
      addCriterion("created_at in", values, "createdAt");
      return (Criteria) this;
    }

    public Criteria andCreatedAtNotIn(List<LocalDateTime> values) {
      addCriterion("created_at not in", values, "createdAt");
      return (Criteria) this;
    }

    public Criteria andCreatedAtBetween(LocalDateTime value1, LocalDateTime value2) {
      addCriterion("created_at between", value1, value2, "createdAt");
      return (Criteria) this;
    }

    public Criteria andCreatedAtNotBetween(LocalDateTime value1, LocalDateTime value2) {
      addCriterion("created_at not between", value1, value2, "createdAt");
      return (Criteria) this;
    }

    public Criteria andUpdatedByIsNull() {
      addCriterion("updated_by is null");
      return (Criteria) this;
    }

    public Criteria andUpdatedByIsNotNull() {
      addCriterion("updated_by is not null");
      return (Criteria) this;
    }

    public Criteria andUpdatedByEqualTo(String value) {
      addCriterion("updated_by =", value, "updatedBy");
      return (Criteria) this;
    }

    public Criteria andUpdatedByNotEqualTo(String value) {
      addCriterion("updated_by <>", value, "updatedBy");
      return (Criteria) this;
    }

    public Criteria andUpdatedByGreaterThan(String value) {
      addCriterion("updated_by >", value, "updatedBy");
      return (Criteria) this;
    }

    public Criteria andUpdatedByGreaterThanOrEqualTo(String value) {
      addCriterion("updated_by >=", value, "updatedBy");
      return (Criteria) this;
    }

    public Criteria andUpdatedByLessThan(String value) {
      addCriterion("updated_by <", value, "updatedBy");
      return (Criteria) this;
    }

    public Criteria andUpdatedByLessThanOrEqualTo(String value) {
      addCriterion("updated_by <=", value, "updatedBy");
      return (Criteria) this;
    }

    public Criteria andUpdatedByLike(String value) {
      addCriterion("updated_by like", value, "updatedBy");
      return (Criteria) this;
    }

    public Criteria andUpdatedByNotLike(String value) {
      addCriterion("updated_by not like", value, "updatedBy");
      return (Criteria) this;
    }

    public Criteria andUpdatedByIn(List<String> values) {
      addCriterion("updated_by in", values, "updatedBy");
      return (Criteria) this;
    }

    public Criteria andUpdatedByNotIn(List<String> values) {
      addCriterion("updated_by not in", values, "updatedBy");
      return (Criteria) this;
    }

    public Criteria andUpdatedByBetween(String value1, String value2) {
      addCriterion("updated_by between", value1, value2, "updatedBy");
      return (Criteria) this;
    }

    public Criteria andUpdatedByNotBetween(String value1, String value2) {
      addCriterion("updated_by not between", value1, value2, "updatedBy");
      return (Criteria) this;
    }

    public Criteria andUpdatedAtIsNull() {
      addCriterion("updated_at is null");
      return (Criteria) this;
    }

    public Criteria andUpdatedAtIsNotNull() {
      addCriterion("updated_at is not null");
      return (Criteria) this;
    }

    public Criteria andUpdatedAtEqualTo(LocalDateTime value) {
      addCriterion("updated_at =", value, "updatedAt");
      return (Criteria) this;
    }

    public Criteria andUpdatedAtNotEqualTo(LocalDateTime value) {
      addCriterion("updated_at <>", value, "updatedAt");
      return (Criteria) this;
    }

    public Criteria andUpdatedAtGreaterThan(LocalDateTime value) {
      addCriterion("updated_at >", value, "updatedAt");
      return (Criteria) this;
    }

    public Criteria andUpdatedAtGreaterThanOrEqualTo(LocalDateTime value) {
      addCriterion("updated_at >=", value, "updatedAt");
      return (Criteria) this;
    }

    public Criteria andUpdatedAtLessThan(LocalDateTime value) {
      addCriterion("updated_at <", value, "updatedAt");
      return (Criteria) this;
    }

    public Criteria andUpdatedAtLessThanOrEqualTo(LocalDateTime value) {
      addCriterion("updated_at <=", value, "updatedAt");
      return (Criteria) this;
    }

    public Criteria andUpdatedAtIn(List<LocalDateTime> values) {
      addCriterion("updated_at in", values, "updatedAt");
      return (Criteria) this;
    }

    public Criteria andUpdatedAtNotIn(List<LocalDateTime> values) {
      addCriterion("updated_at not in", values, "updatedAt");
      return (Criteria) this;
    }

    public Criteria andUpdatedAtBetween(LocalDateTime value1, LocalDateTime value2) {
      addCriterion("updated_at between", value1, value2, "updatedAt");
      return (Criteria) this;
    }

    public Criteria andUpdatedAtNotBetween(LocalDateTime value1, LocalDateTime value2) {
      addCriterion("updated_at not between", value1, value2, "updatedAt");
      return (Criteria) this;
    }

    public Criteria andVersionIsNull() {
      addCriterion("version is null");
      return (Criteria) this;
    }

    public Criteria andVersionIsNotNull() {
      addCriterion("version is not null");
      return (Criteria) this;
    }

    public Criteria andVersionEqualTo(Long value) {
      addCriterion("version =", value, "version");
      return (Criteria) this;
    }

    public Criteria andVersionNotEqualTo(Long value) {
      addCriterion("version <>", value, "version");
      return (Criteria) this;
    }

    public Criteria andVersionGreaterThan(Long value) {
      addCriterion("version >", value, "version");
      return (Criteria) this;
    }

    public Criteria andVersionGreaterThanOrEqualTo(Long value) {
      addCriterion("version >=", value, "version");
      return (Criteria) this;
    }

    public Criteria andVersionLessThan(Long value) {
      addCriterion("version <", value, "version");
      return (Criteria) this;
    }

    public Criteria andVersionLessThanOrEqualTo(Long value) {
      addCriterion("version <=", value, "version");
      return (Criteria) this;
    }

    public Criteria andVersionIn(List<Long> values) {
      addCriterion("version in", values, "version");
      return (Criteria) this;
    }

    public Criteria andVersionNotIn(List<Long> values) {
      addCriterion("version not in", values, "version");
      return (Criteria) this;
    }

    public Criteria andVersionBetween(Long value1, Long value2) {
      addCriterion("version between", value1, value2, "version");
      return (Criteria) this;
    }

    public Criteria andVersionNotBetween(Long value1, Long value2) {
      addCriterion("version not between", value1, value2, "version");
      return (Criteria) this;
    }
  }

  public static class Criteria extends GeneratedCriteria {

    protected Criteria() {
      super();
    }
  }

  public static class Criterion {
    private String condition;

    private Object value;

    private Object secondValue;

    private boolean noValue;

    private boolean singleValue;

    private boolean betweenValue;

    private boolean listValue;

    private String typeHandler;

    public String getCondition() {
      return condition;
    }

    public Object getValue() {
      return value;
    }

    public Object getSecondValue() {
      return secondValue;
    }

    public boolean isNoValue() {
      return noValue;
    }

    public boolean isSingleValue() {
      return singleValue;
    }

    public boolean isBetweenValue() {
      return betweenValue;
    }

    public boolean isListValue() {
      return listValue;
    }

    public String getTypeHandler() {
      return typeHandler;
    }

    protected Criterion(String condition) {
      super();
      this.condition = condition;
      this.typeHandler = null;
      this.noValue = true;
    }

    protected Criterion(String condition, Object value, String typeHandler) {
      super();
      this.condition = condition;
      this.value = value;
      this.typeHandler = typeHandler;
      if (value instanceof List<?>) {
        this.listValue = true;
      } else {
        this.singleValue = true;
      }
    }

    protected Criterion(String condition, Object value) {
      this(condition, value, null);
    }

    protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
      super();
      this.condition = condition;
      this.value = value;
      this.secondValue = secondValue;
      this.typeHandler = typeHandler;
      this.betweenValue = true;
    }

    protected Criterion(String condition, Object value, Object secondValue) {
      this(condition, value, secondValue, null);
    }
  }
}
