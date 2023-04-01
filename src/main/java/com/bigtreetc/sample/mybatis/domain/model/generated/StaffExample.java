package com.bigtreetc.sample.mybatis.domain.model.generated;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StaffExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public StaffExample() {
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

    public Criteria andIdIsNull() {
      addCriterion("staff_id is null");
      return (Criteria) this;
    }

    public Criteria andIdIsNotNull() {
      addCriterion("staff_id is not null");
      return (Criteria) this;
    }

    public Criteria andIdEqualTo(Long value) {
      addCriterion("staff_id =", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotEqualTo(Long value) {
      addCriterion("staff_id <>", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThan(Long value) {
      addCriterion("staff_id >", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("staff_id >=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThan(Long value) {
      addCriterion("staff_id <", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("staff_id <=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdIn(List<Long> values) {
      addCriterion("staff_id in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotIn(List<Long> values) {
      addCriterion("staff_id not in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("staff_id between", value1, value2, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("staff_id not between", value1, value2, "id");
      return (Criteria) this;
    }

    public Criteria andFirstNameIsNull() {
      addCriterion("first_name is null");
      return (Criteria) this;
    }

    public Criteria andFirstNameIsNotNull() {
      addCriterion("first_name is not null");
      return (Criteria) this;
    }

    public Criteria andFirstNameEqualTo(String value) {
      addCriterion("first_name =", value, "firstName");
      return (Criteria) this;
    }

    public Criteria andFirstNameNotEqualTo(String value) {
      addCriterion("first_name <>", value, "firstName");
      return (Criteria) this;
    }

    public Criteria andFirstNameGreaterThan(String value) {
      addCriterion("first_name >", value, "firstName");
      return (Criteria) this;
    }

    public Criteria andFirstNameGreaterThanOrEqualTo(String value) {
      addCriterion("first_name >=", value, "firstName");
      return (Criteria) this;
    }

    public Criteria andFirstNameLessThan(String value) {
      addCriterion("first_name <", value, "firstName");
      return (Criteria) this;
    }

    public Criteria andFirstNameLessThanOrEqualTo(String value) {
      addCriterion("first_name <=", value, "firstName");
      return (Criteria) this;
    }

    public Criteria andFirstNameLike(String value) {
      addCriterion("first_name like", value, "firstName");
      return (Criteria) this;
    }

    public Criteria andFirstNameNotLike(String value) {
      addCriterion("first_name not like", value, "firstName");
      return (Criteria) this;
    }

    public Criteria andFirstNameIn(List<String> values) {
      addCriterion("first_name in", values, "firstName");
      return (Criteria) this;
    }

    public Criteria andFirstNameNotIn(List<String> values) {
      addCriterion("first_name not in", values, "firstName");
      return (Criteria) this;
    }

    public Criteria andFirstNameBetween(String value1, String value2) {
      addCriterion("first_name between", value1, value2, "firstName");
      return (Criteria) this;
    }

    public Criteria andFirstNameNotBetween(String value1, String value2) {
      addCriterion("first_name not between", value1, value2, "firstName");
      return (Criteria) this;
    }

    public Criteria andLastNameIsNull() {
      addCriterion("last_name is null");
      return (Criteria) this;
    }

    public Criteria andLastNameIsNotNull() {
      addCriterion("last_name is not null");
      return (Criteria) this;
    }

    public Criteria andLastNameEqualTo(String value) {
      addCriterion("last_name =", value, "lastName");
      return (Criteria) this;
    }

    public Criteria andLastNameNotEqualTo(String value) {
      addCriterion("last_name <>", value, "lastName");
      return (Criteria) this;
    }

    public Criteria andLastNameGreaterThan(String value) {
      addCriterion("last_name >", value, "lastName");
      return (Criteria) this;
    }

    public Criteria andLastNameGreaterThanOrEqualTo(String value) {
      addCriterion("last_name >=", value, "lastName");
      return (Criteria) this;
    }

    public Criteria andLastNameLessThan(String value) {
      addCriterion("last_name <", value, "lastName");
      return (Criteria) this;
    }

    public Criteria andLastNameLessThanOrEqualTo(String value) {
      addCriterion("last_name <=", value, "lastName");
      return (Criteria) this;
    }

    public Criteria andLastNameLike(String value) {
      addCriterion("last_name like", value, "lastName");
      return (Criteria) this;
    }

    public Criteria andLastNameNotLike(String value) {
      addCriterion("last_name not like", value, "lastName");
      return (Criteria) this;
    }

    public Criteria andLastNameIn(List<String> values) {
      addCriterion("last_name in", values, "lastName");
      return (Criteria) this;
    }

    public Criteria andLastNameNotIn(List<String> values) {
      addCriterion("last_name not in", values, "lastName");
      return (Criteria) this;
    }

    public Criteria andLastNameBetween(String value1, String value2) {
      addCriterion("last_name between", value1, value2, "lastName");
      return (Criteria) this;
    }

    public Criteria andLastNameNotBetween(String value1, String value2) {
      addCriterion("last_name not between", value1, value2, "lastName");
      return (Criteria) this;
    }

    public Criteria andFullNameIsNull() {
      addCriterion("full_name is null");
      return (Criteria) this;
    }

    public Criteria andFullNameIsNotNull() {
      addCriterion("full_name is not null");
      return (Criteria) this;
    }

    public Criteria andFullNameEqualTo(String value) {
      addCriterion("full_name =", value, "fullName");
      return (Criteria) this;
    }

    public Criteria andFullNameNotEqualTo(String value) {
      addCriterion("full_name <>", value, "fullName");
      return (Criteria) this;
    }

    public Criteria andFullNameGreaterThan(String value) {
      addCriterion("full_name >", value, "fullName");
      return (Criteria) this;
    }

    public Criteria andFullNameGreaterThanOrEqualTo(String value) {
      addCriterion("full_name >=", value, "fullName");
      return (Criteria) this;
    }

    public Criteria andFullNameLessThan(String value) {
      addCriterion("full_name <", value, "fullName");
      return (Criteria) this;
    }

    public Criteria andFullNameLessThanOrEqualTo(String value) {
      addCriterion("full_name <=", value, "fullName");
      return (Criteria) this;
    }

    public Criteria andFullNameLike(String value) {
      addCriterion("full_name like", value, "fullName");
      return (Criteria) this;
    }

    public Criteria andFullNameNotLike(String value) {
      addCriterion("full_name not like", value, "fullName");
      return (Criteria) this;
    }

    public Criteria andFullNameIn(List<String> values) {
      addCriterion("full_name in", values, "fullName");
      return (Criteria) this;
    }

    public Criteria andFullNameNotIn(List<String> values) {
      addCriterion("full_name not in", values, "fullName");
      return (Criteria) this;
    }

    public Criteria andFullNameBetween(String value1, String value2) {
      addCriterion("full_name between", value1, value2, "fullName");
      return (Criteria) this;
    }

    public Criteria andFullNameNotBetween(String value1, String value2) {
      addCriterion("full_name not between", value1, value2, "fullName");
      return (Criteria) this;
    }

    public Criteria andEmailIsNull() {
      addCriterion("email is null");
      return (Criteria) this;
    }

    public Criteria andEmailIsNotNull() {
      addCriterion("email is not null");
      return (Criteria) this;
    }

    public Criteria andEmailEqualTo(String value) {
      addCriterion("email =", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailNotEqualTo(String value) {
      addCriterion("email <>", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailGreaterThan(String value) {
      addCriterion("email >", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailGreaterThanOrEqualTo(String value) {
      addCriterion("email >=", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailLessThan(String value) {
      addCriterion("email <", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailLessThanOrEqualTo(String value) {
      addCriterion("email <=", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailLike(String value) {
      addCriterion("email like", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailNotLike(String value) {
      addCriterion("email not like", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailIn(List<String> values) {
      addCriterion("email in", values, "email");
      return (Criteria) this;
    }

    public Criteria andEmailNotIn(List<String> values) {
      addCriterion("email not in", values, "email");
      return (Criteria) this;
    }

    public Criteria andEmailBetween(String value1, String value2) {
      addCriterion("email between", value1, value2, "email");
      return (Criteria) this;
    }

    public Criteria andEmailNotBetween(String value1, String value2) {
      addCriterion("email not between", value1, value2, "email");
      return (Criteria) this;
    }

    public Criteria andPasswordIsNull() {
      addCriterion("password is null");
      return (Criteria) this;
    }

    public Criteria andPasswordIsNotNull() {
      addCriterion("password is not null");
      return (Criteria) this;
    }

    public Criteria andPasswordEqualTo(String value) {
      addCriterion("password =", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordNotEqualTo(String value) {
      addCriterion("password <>", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordGreaterThan(String value) {
      addCriterion("password >", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordGreaterThanOrEqualTo(String value) {
      addCriterion("password >=", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordLessThan(String value) {
      addCriterion("password <", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordLessThanOrEqualTo(String value) {
      addCriterion("password <=", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordLike(String value) {
      addCriterion("password like", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordNotLike(String value) {
      addCriterion("password not like", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordIn(List<String> values) {
      addCriterion("password in", values, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordNotIn(List<String> values) {
      addCriterion("password not in", values, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordBetween(String value1, String value2) {
      addCriterion("password between", value1, value2, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordNotBetween(String value1, String value2) {
      addCriterion("password not between", value1, value2, "password");
      return (Criteria) this;
    }

    public Criteria andTelIsNull() {
      addCriterion("tel is null");
      return (Criteria) this;
    }

    public Criteria andTelIsNotNull() {
      addCriterion("tel is not null");
      return (Criteria) this;
    }

    public Criteria andTelEqualTo(String value) {
      addCriterion("tel =", value, "tel");
      return (Criteria) this;
    }

    public Criteria andTelNotEqualTo(String value) {
      addCriterion("tel <>", value, "tel");
      return (Criteria) this;
    }

    public Criteria andTelGreaterThan(String value) {
      addCriterion("tel >", value, "tel");
      return (Criteria) this;
    }

    public Criteria andTelGreaterThanOrEqualTo(String value) {
      addCriterion("tel >=", value, "tel");
      return (Criteria) this;
    }

    public Criteria andTelLessThan(String value) {
      addCriterion("tel <", value, "tel");
      return (Criteria) this;
    }

    public Criteria andTelLessThanOrEqualTo(String value) {
      addCriterion("tel <=", value, "tel");
      return (Criteria) this;
    }

    public Criteria andTelLike(String value) {
      addCriterion("tel like", value, "tel");
      return (Criteria) this;
    }

    public Criteria andTelNotLike(String value) {
      addCriterion("tel not like", value, "tel");
      return (Criteria) this;
    }

    public Criteria andTelIn(List<String> values) {
      addCriterion("tel in", values, "tel");
      return (Criteria) this;
    }

    public Criteria andTelNotIn(List<String> values) {
      addCriterion("tel not in", values, "tel");
      return (Criteria) this;
    }

    public Criteria andTelBetween(String value1, String value2) {
      addCriterion("tel between", value1, value2, "tel");
      return (Criteria) this;
    }

    public Criteria andTelNotBetween(String value1, String value2) {
      addCriterion("tel not between", value1, value2, "tel");
      return (Criteria) this;
    }

    public Criteria andPasswordResetTokenIsNull() {
      addCriterion("password_reset_token is null");
      return (Criteria) this;
    }

    public Criteria andPasswordResetTokenIsNotNull() {
      addCriterion("password_reset_token is not null");
      return (Criteria) this;
    }

    public Criteria andPasswordResetTokenEqualTo(String value) {
      addCriterion("password_reset_token =", value, "passwordResetToken");
      return (Criteria) this;
    }

    public Criteria andPasswordResetTokenNotEqualTo(String value) {
      addCriterion("password_reset_token <>", value, "passwordResetToken");
      return (Criteria) this;
    }

    public Criteria andPasswordResetTokenGreaterThan(String value) {
      addCriterion("password_reset_token >", value, "passwordResetToken");
      return (Criteria) this;
    }

    public Criteria andPasswordResetTokenGreaterThanOrEqualTo(String value) {
      addCriterion("password_reset_token >=", value, "passwordResetToken");
      return (Criteria) this;
    }

    public Criteria andPasswordResetTokenLessThan(String value) {
      addCriterion("password_reset_token <", value, "passwordResetToken");
      return (Criteria) this;
    }

    public Criteria andPasswordResetTokenLessThanOrEqualTo(String value) {
      addCriterion("password_reset_token <=", value, "passwordResetToken");
      return (Criteria) this;
    }

    public Criteria andPasswordResetTokenLike(String value) {
      addCriterion("password_reset_token like", value, "passwordResetToken");
      return (Criteria) this;
    }

    public Criteria andPasswordResetTokenNotLike(String value) {
      addCriterion("password_reset_token not like", value, "passwordResetToken");
      return (Criteria) this;
    }

    public Criteria andPasswordResetTokenIn(List<String> values) {
      addCriterion("password_reset_token in", values, "passwordResetToken");
      return (Criteria) this;
    }

    public Criteria andPasswordResetTokenNotIn(List<String> values) {
      addCriterion("password_reset_token not in", values, "passwordResetToken");
      return (Criteria) this;
    }

    public Criteria andPasswordResetTokenBetween(String value1, String value2) {
      addCriterion("password_reset_token between", value1, value2, "passwordResetToken");
      return (Criteria) this;
    }

    public Criteria andPasswordResetTokenNotBetween(String value1, String value2) {
      addCriterion("password_reset_token not between", value1, value2, "passwordResetToken");
      return (Criteria) this;
    }

    public Criteria andTokenExpiresAtIsNull() {
      addCriterion("token_expires_at is null");
      return (Criteria) this;
    }

    public Criteria andTokenExpiresAtIsNotNull() {
      addCriterion("token_expires_at is not null");
      return (Criteria) this;
    }

    public Criteria andTokenExpiresAtEqualTo(LocalDateTime value) {
      addCriterion("token_expires_at =", value, "tokenExpiresAt");
      return (Criteria) this;
    }

    public Criteria andTokenExpiresAtNotEqualTo(LocalDateTime value) {
      addCriterion("token_expires_at <>", value, "tokenExpiresAt");
      return (Criteria) this;
    }

    public Criteria andTokenExpiresAtGreaterThan(LocalDateTime value) {
      addCriterion("token_expires_at >", value, "tokenExpiresAt");
      return (Criteria) this;
    }

    public Criteria andTokenExpiresAtGreaterThanOrEqualTo(LocalDateTime value) {
      addCriterion("token_expires_at >=", value, "tokenExpiresAt");
      return (Criteria) this;
    }

    public Criteria andTokenExpiresAtLessThan(LocalDateTime value) {
      addCriterion("token_expires_at <", value, "tokenExpiresAt");
      return (Criteria) this;
    }

    public Criteria andTokenExpiresAtLessThanOrEqualTo(LocalDateTime value) {
      addCriterion("token_expires_at <=", value, "tokenExpiresAt");
      return (Criteria) this;
    }

    public Criteria andTokenExpiresAtIn(List<LocalDateTime> values) {
      addCriterion("token_expires_at in", values, "tokenExpiresAt");
      return (Criteria) this;
    }

    public Criteria andTokenExpiresAtNotIn(List<LocalDateTime> values) {
      addCriterion("token_expires_at not in", values, "tokenExpiresAt");
      return (Criteria) this;
    }

    public Criteria andTokenExpiresAtBetween(LocalDateTime value1, LocalDateTime value2) {
      addCriterion("token_expires_at between", value1, value2, "tokenExpiresAt");
      return (Criteria) this;
    }

    public Criteria andTokenExpiresAtNotBetween(LocalDateTime value1, LocalDateTime value2) {
      addCriterion("token_expires_at not between", value1, value2, "tokenExpiresAt");
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
