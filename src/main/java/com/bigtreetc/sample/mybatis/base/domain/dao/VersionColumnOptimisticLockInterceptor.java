package com.bigtreetc.sample.mybatis.base.domain.dao;

import com.bigtreetc.sample.mybatis.base.domain.model.BaseEntity;
import com.bigtreetc.sample.mybatis.base.exception.OptimisticLockException;
import java.lang.reflect.InvocationTargetException;
import org.apache.ibatis.binding.MapperMethod;
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
public class VersionColumnOptimisticLockInterceptor implements Interceptor {

  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    Object[] args = invocation.getArgs();
    MappedStatement mappedStatement = (MappedStatement) args[0];
    Object parameter = args[1];

    if (mappedStatement.getSqlCommandType() == SqlCommandType.UPDATE) {
      if (mappedStatement.getId().contains("updateByExample")) {
        Object record = ((MapperMethod.ParamMap<?>) parameter).get("record");
        if (record instanceof BaseEntity entity) {
          return setNextVersionAndProceed(invocation, entity);
        }
      } else if (mappedStatement.getId().contains("updateByPrimaryKey")) {
        if (parameter instanceof BaseEntity entity) {
          return setNextVersionAndProceed(invocation, entity);
        }
      }
    }

    return invocation.proceed();
  }

  private int setNextVersionAndProceed(Invocation invocation, BaseEntity entity)
      throws InvocationTargetException, IllegalAccessException {
    Long version = entity.getVersion();
    entity.setVersion(version + 1);

    int updated = (int) invocation.proceed();
    if (updated == 0) {
      throw new OptimisticLockException("すでに更新されています。");
    }
    return updated;
  }
}
