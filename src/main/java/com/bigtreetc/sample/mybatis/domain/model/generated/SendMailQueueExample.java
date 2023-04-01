package com.bigtreetc.sample.mybatis.domain.model.generated;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SendMailQueueExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public SendMailQueueExample() {
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
      addCriterion("send_mail_queue_id is null");
      return (Criteria) this;
    }

    public Criteria andIdIsNotNull() {
      addCriterion("send_mail_queue_id is not null");
      return (Criteria) this;
    }

    public Criteria andIdEqualTo(Long value) {
      addCriterion("send_mail_queue_id =", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotEqualTo(Long value) {
      addCriterion("send_mail_queue_id <>", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThan(Long value) {
      addCriterion("send_mail_queue_id >", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("send_mail_queue_id >=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThan(Long value) {
      addCriterion("send_mail_queue_id <", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("send_mail_queue_id <=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdIn(List<Long> values) {
      addCriterion("send_mail_queue_id in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotIn(List<Long> values) {
      addCriterion("send_mail_queue_id not in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("send_mail_queue_id between", value1, value2, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("send_mail_queue_id not between", value1, value2, "id");
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

    public Criteria andFromAddressIsNull() {
      addCriterion("from_address is null");
      return (Criteria) this;
    }

    public Criteria andFromAddressIsNotNull() {
      addCriterion("from_address is not null");
      return (Criteria) this;
    }

    public Criteria andFromAddressEqualTo(String value) {
      addCriterion("from_address =", value, "fromAddress");
      return (Criteria) this;
    }

    public Criteria andFromAddressNotEqualTo(String value) {
      addCriterion("from_address <>", value, "fromAddress");
      return (Criteria) this;
    }

    public Criteria andFromAddressGreaterThan(String value) {
      addCriterion("from_address >", value, "fromAddress");
      return (Criteria) this;
    }

    public Criteria andFromAddressGreaterThanOrEqualTo(String value) {
      addCriterion("from_address >=", value, "fromAddress");
      return (Criteria) this;
    }

    public Criteria andFromAddressLessThan(String value) {
      addCriterion("from_address <", value, "fromAddress");
      return (Criteria) this;
    }

    public Criteria andFromAddressLessThanOrEqualTo(String value) {
      addCriterion("from_address <=", value, "fromAddress");
      return (Criteria) this;
    }

    public Criteria andFromAddressLike(String value) {
      addCriterion("from_address like", value, "fromAddress");
      return (Criteria) this;
    }

    public Criteria andFromAddressNotLike(String value) {
      addCriterion("from_address not like", value, "fromAddress");
      return (Criteria) this;
    }

    public Criteria andFromAddressIn(List<String> values) {
      addCriterion("from_address in", values, "fromAddress");
      return (Criteria) this;
    }

    public Criteria andFromAddressNotIn(List<String> values) {
      addCriterion("from_address not in", values, "fromAddress");
      return (Criteria) this;
    }

    public Criteria andFromAddressBetween(String value1, String value2) {
      addCriterion("from_address between", value1, value2, "fromAddress");
      return (Criteria) this;
    }

    public Criteria andFromAddressNotBetween(String value1, String value2) {
      addCriterion("from_address not between", value1, value2, "fromAddress");
      return (Criteria) this;
    }

    public Criteria andToAddressIsNull() {
      addCriterion("to_address is null");
      return (Criteria) this;
    }

    public Criteria andToAddressIsNotNull() {
      addCriterion("to_address is not null");
      return (Criteria) this;
    }

    public Criteria andToAddressEqualTo(String value) {
      addCriterion("to_address =", value, "toAddress");
      return (Criteria) this;
    }

    public Criteria andToAddressNotEqualTo(String value) {
      addCriterion("to_address <>", value, "toAddress");
      return (Criteria) this;
    }

    public Criteria andToAddressGreaterThan(String value) {
      addCriterion("to_address >", value, "toAddress");
      return (Criteria) this;
    }

    public Criteria andToAddressGreaterThanOrEqualTo(String value) {
      addCriterion("to_address >=", value, "toAddress");
      return (Criteria) this;
    }

    public Criteria andToAddressLessThan(String value) {
      addCriterion("to_address <", value, "toAddress");
      return (Criteria) this;
    }

    public Criteria andToAddressLessThanOrEqualTo(String value) {
      addCriterion("to_address <=", value, "toAddress");
      return (Criteria) this;
    }

    public Criteria andToAddressLike(String value) {
      addCriterion("to_address like", value, "toAddress");
      return (Criteria) this;
    }

    public Criteria andToAddressNotLike(String value) {
      addCriterion("to_address not like", value, "toAddress");
      return (Criteria) this;
    }

    public Criteria andToAddressIn(List<String> values) {
      addCriterion("to_address in", values, "toAddress");
      return (Criteria) this;
    }

    public Criteria andToAddressNotIn(List<String> values) {
      addCriterion("to_address not in", values, "toAddress");
      return (Criteria) this;
    }

    public Criteria andToAddressBetween(String value1, String value2) {
      addCriterion("to_address between", value1, value2, "toAddress");
      return (Criteria) this;
    }

    public Criteria andToAddressNotBetween(String value1, String value2) {
      addCriterion("to_address not between", value1, value2, "toAddress");
      return (Criteria) this;
    }

    public Criteria andCcAddressIsNull() {
      addCriterion("cc_address is null");
      return (Criteria) this;
    }

    public Criteria andCcAddressIsNotNull() {
      addCriterion("cc_address is not null");
      return (Criteria) this;
    }

    public Criteria andCcAddressEqualTo(String value) {
      addCriterion("cc_address =", value, "ccAddress");
      return (Criteria) this;
    }

    public Criteria andCcAddressNotEqualTo(String value) {
      addCriterion("cc_address <>", value, "ccAddress");
      return (Criteria) this;
    }

    public Criteria andCcAddressGreaterThan(String value) {
      addCriterion("cc_address >", value, "ccAddress");
      return (Criteria) this;
    }

    public Criteria andCcAddressGreaterThanOrEqualTo(String value) {
      addCriterion("cc_address >=", value, "ccAddress");
      return (Criteria) this;
    }

    public Criteria andCcAddressLessThan(String value) {
      addCriterion("cc_address <", value, "ccAddress");
      return (Criteria) this;
    }

    public Criteria andCcAddressLessThanOrEqualTo(String value) {
      addCriterion("cc_address <=", value, "ccAddress");
      return (Criteria) this;
    }

    public Criteria andCcAddressLike(String value) {
      addCriterion("cc_address like", value, "ccAddress");
      return (Criteria) this;
    }

    public Criteria andCcAddressNotLike(String value) {
      addCriterion("cc_address not like", value, "ccAddress");
      return (Criteria) this;
    }

    public Criteria andCcAddressIn(List<String> values) {
      addCriterion("cc_address in", values, "ccAddress");
      return (Criteria) this;
    }

    public Criteria andCcAddressNotIn(List<String> values) {
      addCriterion("cc_address not in", values, "ccAddress");
      return (Criteria) this;
    }

    public Criteria andCcAddressBetween(String value1, String value2) {
      addCriterion("cc_address between", value1, value2, "ccAddress");
      return (Criteria) this;
    }

    public Criteria andCcAddressNotBetween(String value1, String value2) {
      addCriterion("cc_address not between", value1, value2, "ccAddress");
      return (Criteria) this;
    }

    public Criteria andBccAddressIsNull() {
      addCriterion("bcc_address is null");
      return (Criteria) this;
    }

    public Criteria andBccAddressIsNotNull() {
      addCriterion("bcc_address is not null");
      return (Criteria) this;
    }

    public Criteria andBccAddressEqualTo(String value) {
      addCriterion("bcc_address =", value, "bccAddress");
      return (Criteria) this;
    }

    public Criteria andBccAddressNotEqualTo(String value) {
      addCriterion("bcc_address <>", value, "bccAddress");
      return (Criteria) this;
    }

    public Criteria andBccAddressGreaterThan(String value) {
      addCriterion("bcc_address >", value, "bccAddress");
      return (Criteria) this;
    }

    public Criteria andBccAddressGreaterThanOrEqualTo(String value) {
      addCriterion("bcc_address >=", value, "bccAddress");
      return (Criteria) this;
    }

    public Criteria andBccAddressLessThan(String value) {
      addCriterion("bcc_address <", value, "bccAddress");
      return (Criteria) this;
    }

    public Criteria andBccAddressLessThanOrEqualTo(String value) {
      addCriterion("bcc_address <=", value, "bccAddress");
      return (Criteria) this;
    }

    public Criteria andBccAddressLike(String value) {
      addCriterion("bcc_address like", value, "bccAddress");
      return (Criteria) this;
    }

    public Criteria andBccAddressNotLike(String value) {
      addCriterion("bcc_address not like", value, "bccAddress");
      return (Criteria) this;
    }

    public Criteria andBccAddressIn(List<String> values) {
      addCriterion("bcc_address in", values, "bccAddress");
      return (Criteria) this;
    }

    public Criteria andBccAddressNotIn(List<String> values) {
      addCriterion("bcc_address not in", values, "bccAddress");
      return (Criteria) this;
    }

    public Criteria andBccAddressBetween(String value1, String value2) {
      addCriterion("bcc_address between", value1, value2, "bccAddress");
      return (Criteria) this;
    }

    public Criteria andBccAddressNotBetween(String value1, String value2) {
      addCriterion("bcc_address not between", value1, value2, "bccAddress");
      return (Criteria) this;
    }

    public Criteria andSubjectIsNull() {
      addCriterion("subject is null");
      return (Criteria) this;
    }

    public Criteria andSubjectIsNotNull() {
      addCriterion("subject is not null");
      return (Criteria) this;
    }

    public Criteria andSubjectEqualTo(String value) {
      addCriterion("subject =", value, "subject");
      return (Criteria) this;
    }

    public Criteria andSubjectNotEqualTo(String value) {
      addCriterion("subject <>", value, "subject");
      return (Criteria) this;
    }

    public Criteria andSubjectGreaterThan(String value) {
      addCriterion("subject >", value, "subject");
      return (Criteria) this;
    }

    public Criteria andSubjectGreaterThanOrEqualTo(String value) {
      addCriterion("subject >=", value, "subject");
      return (Criteria) this;
    }

    public Criteria andSubjectLessThan(String value) {
      addCriterion("subject <", value, "subject");
      return (Criteria) this;
    }

    public Criteria andSubjectLessThanOrEqualTo(String value) {
      addCriterion("subject <=", value, "subject");
      return (Criteria) this;
    }

    public Criteria andSubjectLike(String value) {
      addCriterion("subject like", value, "subject");
      return (Criteria) this;
    }

    public Criteria andSubjectNotLike(String value) {
      addCriterion("subject not like", value, "subject");
      return (Criteria) this;
    }

    public Criteria andSubjectIn(List<String> values) {
      addCriterion("subject in", values, "subject");
      return (Criteria) this;
    }

    public Criteria andSubjectNotIn(List<String> values) {
      addCriterion("subject not in", values, "subject");
      return (Criteria) this;
    }

    public Criteria andSubjectBetween(String value1, String value2) {
      addCriterion("subject between", value1, value2, "subject");
      return (Criteria) this;
    }

    public Criteria andSubjectNotBetween(String value1, String value2) {
      addCriterion("subject not between", value1, value2, "subject");
      return (Criteria) this;
    }

    public Criteria andSentAtIsNull() {
      addCriterion("sent_at is null");
      return (Criteria) this;
    }

    public Criteria andSentAtIsNotNull() {
      addCriterion("sent_at is not null");
      return (Criteria) this;
    }

    public Criteria andSentAtEqualTo(LocalDateTime value) {
      addCriterion("sent_at =", value, "sentAt");
      return (Criteria) this;
    }

    public Criteria andSentAtNotEqualTo(LocalDateTime value) {
      addCriterion("sent_at <>", value, "sentAt");
      return (Criteria) this;
    }

    public Criteria andSentAtGreaterThan(LocalDateTime value) {
      addCriterion("sent_at >", value, "sentAt");
      return (Criteria) this;
    }

    public Criteria andSentAtGreaterThanOrEqualTo(LocalDateTime value) {
      addCriterion("sent_at >=", value, "sentAt");
      return (Criteria) this;
    }

    public Criteria andSentAtLessThan(LocalDateTime value) {
      addCriterion("sent_at <", value, "sentAt");
      return (Criteria) this;
    }

    public Criteria andSentAtLessThanOrEqualTo(LocalDateTime value) {
      addCriterion("sent_at <=", value, "sentAt");
      return (Criteria) this;
    }

    public Criteria andSentAtIn(List<LocalDateTime> values) {
      addCriterion("sent_at in", values, "sentAt");
      return (Criteria) this;
    }

    public Criteria andSentAtNotIn(List<LocalDateTime> values) {
      addCriterion("sent_at not in", values, "sentAt");
      return (Criteria) this;
    }

    public Criteria andSentAtBetween(LocalDateTime value1, LocalDateTime value2) {
      addCriterion("sent_at between", value1, value2, "sentAt");
      return (Criteria) this;
    }

    public Criteria andSentAtNotBetween(LocalDateTime value1, LocalDateTime value2) {
      addCriterion("sent_at not between", value1, value2, "sentAt");
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
