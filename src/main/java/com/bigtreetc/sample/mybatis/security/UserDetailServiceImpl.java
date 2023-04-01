package com.bigtreetc.sample.mybatis.security;

import static java.util.stream.Collectors.toSet;

import com.bigtreetc.sample.mybatis.base.exception.NoDataFoundException;
import com.bigtreetc.sample.mybatis.domain.model.generated.*;
import com.bigtreetc.sample.mybatis.domain.repository.RolePermissionRepository;
import com.bigtreetc.sample.mybatis.domain.repository.StaffRepository;
import com.bigtreetc.sample.mybatis.domain.repository.StaffRoleRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/** 管理側 認証認可 */
@RequiredArgsConstructor
@Component
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {

  @NonNull final StaffRepository staffRepository;

  @NonNull final StaffRoleRepository staffRoleRepository;

  @NonNull final RolePermissionRepository rolePermissionRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Staff staff = null;
    List<GrantedAuthority> authorityList = null;

    try {
      val staffExample = new StaffExample();
      staffExample.createCriteria().andEmailEqualTo(username);

      // 担当者を取得して、セッションに保存する
      staff =
          staffRepository
              .findOne(staffExample)
              .orElseThrow(
                  () ->
                      new UsernameNotFoundException("no staff found [username=" + username + "]"));

      // 担当者権限を取得する
      val staffRoleExample = new StaffRoleExample();
      staffRoleExample.createCriteria().andStaffIdEqualTo(staff.getId());
      val staffRoles = staffRoleRepository.findAll(staffRoleExample, Pageable.unpaged());

      // ロールコードにプレフィックスをつけてまとめる
      val roleCodes = staffRoles.stream().map(StaffRole::getRoleCode).collect(toSet());
      val rolePermissions = getRolePermissions(roleCodes);

      // 権限コードをまとめる
      val permissionCodes =
          rolePermissions.stream()
              .filter(RolePermission::getIsEnabled)
              .map(RolePermission::getPermissionCode)
              .collect(toSet());

      // ロールと権限を両方ともGrantedAuthorityとして渡す
      Set<String> authorities = new HashSet<>();
      for (val roleCode : roleCodes) {
        authorities.add("ROLE_%s".formatted(roleCode));
      }
      authorities.addAll(permissionCodes);
      authorityList = AuthorityUtils.createAuthorityList(authorities.toArray(new String[0]));

      return User.withUsername(staff.getId().toString())
          .password(staff.getPassword())
          .authorities(authorityList)
          .build();

    } catch (NoDataFoundException e) { // TODO
      throw e;
    } catch (Exception e) {
      throw new UsernameNotFoundException("could not select account.", e);
    }
  }

  private List<RolePermission> getRolePermissions(Set<String> roleCodes) {
    val example = new RolePermissionExample();
    example.createCriteria().andRoleCodeIn(roleCodes.stream().toList()).andIsEnabledEqualTo(true);
    return rolePermissionRepository.findAll(example, Pageable.unpaged()).stream().toList();
  }
}
