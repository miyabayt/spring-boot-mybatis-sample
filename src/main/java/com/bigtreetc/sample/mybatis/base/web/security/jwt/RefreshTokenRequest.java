package com.bigtreetc.sample.mybatis.base.web.security.jwt;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RefreshTokenRequest {

  // アクセストークン
  String accessToken;

  // リフレッシュトークン
  String refreshToken;
}
