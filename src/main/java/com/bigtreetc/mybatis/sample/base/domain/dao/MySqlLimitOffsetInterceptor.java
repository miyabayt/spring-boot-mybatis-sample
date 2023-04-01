package com.bigtreetc.mybatis.sample.base.domain.dao;

import java.sql.Connection;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;

@Intercepts({
  @Signature(
      type = StatementHandler.class,
      method = "prepare",
      args = {Connection.class, Integer.class})
})
@Slf4j
public class MySqlLimitOffsetInterceptor implements Interceptor {

  public static final String DELEGATE_BOUND_SQL = "delegate.boundSql";
  public static final String DELEGATE_MAPPED_STATEMENT = "delegate.mappedStatement";
  public static final String DELEGATE_ROW_BOUNDS = "delegate.rowBounds";
  public static final String WITH_ROWBOUNDS_METHOD_NAME = "selectByExampleWithRowbounds";

  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
    MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
    MappedStatement mappedStatement =
        (MappedStatement) metaObject.getValue(DELEGATE_MAPPED_STATEMENT);
    BoundSql boundSql = (BoundSql) metaObject.getValue(DELEGATE_BOUND_SQL);

    String statementId = mappedStatement.getId(); // <select id="この部分"
    if (statementId.endsWith(WITH_ROWBOUNDS_METHOD_NAME)) {
      final RowBounds rowBounds = (RowBounds) metaObject.getValue(DELEGATE_ROW_BOUNDS);
      int offset = rowBounds.getOffset();
      int limit = rowBounds.getLimit();

      if (offset != RowBounds.NO_ROW_OFFSET || limit != RowBounds.NO_ROW_LIMIT) {
        Configuration config = mappedStatement.getConfiguration();
        String originalSql = boundSql.getSql();
        String newSql =
            (originalSql + " limit " + limit + " offset " + offset)
                .replaceFirst("select", "select SQL_CALC_FOUND_ROWS");
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        Object parameterObject = boundSql.getParameterObject();
        BoundSql newBoundSql = new BoundSql(config, newSql, parameterMappings, parameterObject);
        metaObject.setValue(DELEGATE_BOUND_SQL, newBoundSql);
      }
    }

    return invocation.proceed();
  }
}
