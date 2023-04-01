package com.bigtreetc.sample.mybatis.base.exception;

/** 排他制御エラー */
public class OptimisticLockException extends RuntimeException {

  private static final long serialVersionUID = -1L;

  /** コンストラクタ */
  public OptimisticLockException(String message) {
    super(message);
  }

  /** コンストラクタ */
  public OptimisticLockException(Exception e) {
    super(e);
  }
}
