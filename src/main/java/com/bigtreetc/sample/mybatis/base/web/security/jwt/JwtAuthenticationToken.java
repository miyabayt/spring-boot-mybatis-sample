package com.bigtreetc.sample.mybatis.base.web.security.jwt;

import java.util.Collection;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

@Setter
@Getter
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

  private static final long serialVersionUID = -3404875235940900839L;

  private boolean tokenExpired = false;

  public JwtAuthenticationToken(Object principal, Object credentials) {
    super(principal, credentials);
  }

  public JwtAuthenticationToken(
      Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
    super(principal, credentials, authorities);
  }
}
