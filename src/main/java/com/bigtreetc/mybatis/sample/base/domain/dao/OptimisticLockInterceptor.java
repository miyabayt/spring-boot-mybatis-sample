package com.bigtreetc.mybatis.sample.base.domain.dao;

import com.bigtreetc.mybatis.sample.base.domain.model.BaseEntity;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

@Intercepts({
  @Signature(
      type = Executor.class,
      method = "update",
      args = {MappedStatement.class, Object.class})
})
public class OptimisticLockInterceptor implements Interceptor {

  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    Object[] args = invocation.getArgs();
    MappedStatement mappedStatement = (MappedStatement) args[0];
    Object parameter = args[1];

    if (mappedStatement.getSqlCommandType() == SqlCommandType.UPDATE) {
      if (parameter instanceof BaseEntity entity) {
        Long version = entity.getVersion();
        entity.setVersion(version + 1);
        args[1] = entity;
        int updated = (int) invocation.proceed();
        if (updated == 0) {
          throw new RuntimeException("The record was updated or deleted by another transaction");
        }
        return updated;
      }
    }

    return invocation.proceed();
  }
}
