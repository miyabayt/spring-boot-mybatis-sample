package com.bigtreetc.sample.mybatis.controller.permissions;

import com.bigtreetc.sample.mybatis.base.domain.validator.AbstractValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

/** 権限登録 入力チェック */
@Component
public class PermissionRequestValidator extends AbstractValidator<PermissionRequest> {

  @Override
  protected void doValidate(PermissionRequest request, Errors errors) {}
}
