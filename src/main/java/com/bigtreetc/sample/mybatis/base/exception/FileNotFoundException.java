package com.bigtreetc.sample.mybatis.base.exception;

/** ファイル不存在エラー */
public class FileNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -1L;

  /** コンストラクタ */
  public FileNotFoundException(String message) {
    super(message);
  }

  /** コンストラクタ */
  public FileNotFoundException(Exception e) {
    super(e);
  }
}
