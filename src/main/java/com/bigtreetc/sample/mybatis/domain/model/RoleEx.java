package com.bigtreetc.sample.mybatis.domain.model;

import static com.bigtreetc.sample.mybatis.base.util.ValidateUtils.isEquals;

import com.bigtreetc.sample.mybatis.domain.model.generated.Permission;
import com.bigtreetc.sample.mybatis.domain.model.generated.Role;
import com.bigtreetc.sample.mybatis.domain.model.generated.RolePermission;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleEx extends Role {

  private static final long serialVersionUID = 1338439454676301310L;

  final List<RolePermission> rolePermissions = new ArrayList<>();

  final List<Permission> permissions = new ArrayList<>();

  public boolean hasPermission(String permissionCode) {
    return rolePermissions.stream()
        .anyMatch(rp -> isEquals(rp.getPermissionCode(), permissionCode) && rp.getIsEnabled());
  }

  public void setPermission(String permissionCode, boolean isEnabled) {
    rolePermissions.stream()
        .filter(rp -> isEquals(rp.getPermissionCode(), permissionCode))
        .findFirst()
        .ifPresent(rp -> rp.setIsEnabled(isEnabled));
  }
}
