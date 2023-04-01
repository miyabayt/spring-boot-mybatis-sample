package com.bigtreetc.mybatis.sample.base.web.controller.api.response;

import static com.bigtreetc.mybatis.sample.base.web.BaseWebConst.MESSAGE_SUCCESS;

import com.bigtreetc.mybatis.sample.base.util.MessageUtils;

public interface ApiResponse {

  String getMessage();

  void setMessage(String message);

  boolean getSuccess();

  void setSuccess(boolean success);

  default ApiResponse success() {
    this.setSuccess(true);
    this.setMessage(MessageUtils.getMessage(MESSAGE_SUCCESS));
    return this;
  }
}
