package com.bigtreetc.sample.mybatis.controller.permissions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchPermissionRequest {

  private static final long serialVersionUID = -1L; // TODO

  Long id;

  String permissionName;
}
