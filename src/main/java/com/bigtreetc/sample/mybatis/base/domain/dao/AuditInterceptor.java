package com.bigtreetc.sample.mybatis.base.domain.dao;

import java.lang.reflect.Field;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@SuppressWarnings("rawtypes")
@Intercepts({
  @Signature(
      type = Executor.class,
      method = "update",
      args = {MappedStatement.class, Object.class})
})
public class AuditInterceptor implements Interceptor {

  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
    Object entityObj = invocation.getArgs()[1];

    Class<?> clazz = entityObj.getClass();
    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields) {
      if (field.getAnnotation(CreatedDate.class) != null
          && mappedStatement.getSqlCommandType() == SqlCommandType.INSERT) {
        setAuditDateTime(entityObj, field);
      } else if (field.getAnnotation(LastModifiedDate.class) != null) {
        setAuditDateTime(entityObj, field);
      }
      if (field.getAnnotation(CreatedBy.class) != null
          && mappedStatement.getSqlCommandType() == SqlCommandType.UPDATE) {
        setAuditUser(entityObj, field);
      } else if (field.getAnnotation(LastModifiedBy.class) != null) {
        setAuditUser(entityObj, field);
      }
    }

    return invocation.proceed();
  }

  private void setAuditDateTime(Object obj, Field field) throws IllegalAccessException {
    field.setAccessible(true);
    if (field.get(obj) != null) {
      field.set(obj, AuditInfoHolder.getAuditDateTime());
    }
  }

  private void setAuditUser(Object obj, Field field) throws IllegalAccessException {
    field.setAccessible(true);
    if (field.get(obj) != null) {
      field.set(obj, AuditInfoHolder.getAuditUser());
    }
  }
}
