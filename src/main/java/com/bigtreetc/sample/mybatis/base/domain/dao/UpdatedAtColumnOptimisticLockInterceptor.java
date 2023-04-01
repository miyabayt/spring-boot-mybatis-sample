package com.bigtreetc.sample.mybatis.base.domain.dao;

import com.bigtreetc.sample.mybatis.base.exception.OptimisticLockException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;

@Intercepts({
  @Signature(
      type = Executor.class,
      method = "update",
      args = {MappedStatement.class, Object.class})
})
@RequiredArgsConstructor
@Slf4j
public class UpdatedAtColumnOptimisticLockInterceptor implements Interceptor {

  private static final String METHOD_PARAMETER_RECORD = "record";
  private static final String METHOD_PARAMETER_EXAMPLE = "example";
  private static final String STATEMENT_SUFFIX_PRIMARY_KEY = "PrimaryKey";

  @NonNull final String updatedAtPropertyName;

  private static final List<String> TARGET_STATEMENT_SUFFIX_LIST =
      List.of(
          "Mapper.updateByExample",
          "Mapper.updateByExampleSelective",
          "Mapper.updateByPrimaryKey",
          "Mapper.updateByPrimaryKeySelective");

  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    Executor executor = (Executor) invocation.getTarget();
    Object[] args = invocation.getArgs();
    MappedStatement mappedStatement = (MappedStatement) args[0];
    Object parameter = args[1];

    if (mappedStatement.getSqlCommandType() == SqlCommandType.UPDATE) {
      Configuration configuration = mappedStatement.getConfiguration();

      // インターセプト対象のメソッドの場合に排他制御を行う
      if (isTargetMappedStatement(mappedStatement)) {
        // マッパー定義からselectByExampleのステートメントを取り出す
        String selectStatementId = getSelectStatementId(mappedStatement);
        MappedStatement selectMappedStatement = configuration.getMappedStatement(selectStatementId);

        Object queryParam = null;
        Object recordParam = null;
        if (isUpdateByPrimaryKey(mappedStatement)) {
          queryParam = parameter;
          recordParam = parameter;
        } else {
          queryParam = getMapperMethodParameter(parameter, METHOD_PARAMETER_EXAMPLE);
          recordParam = getMapperMethodParameter(parameter, METHOD_PARAMETER_RECORD);
        }

        // 更新対象のレコードを取得する
        try (Cursor<Object> cursor =
            executor.queryCursor(selectMappedStatement, queryParam, RowBounds.DEFAULT)) {

          List<Object> resultSets = new ArrayList<>();
          for (Object resultSet : cursor) {
            resultSets.add(resultSet);
            if (cursor.getCurrentIndex() == 2) {
              // 2行まで読み取る（indexが0と1はリストに追加される）
              break;
            }
          }

          if (resultSets.size() == 1) {
            // 1件の場合のみチェックする（基準となる日時の指定が一つのため、複数件まとめての排他制御は行わない）
            Object current = resultSets.get(0);
            Object currentUpdateAt = getPropertyValue(current, updatedAtPropertyName);
            Object instanceUpdateAt = getPropertyValue(recordParam, updatedAtPropertyName);

            // 更新対象のレコードの更新日付がNULLの場合は、排他制御しない
            if (currentUpdateAt != null && !Objects.equals(currentUpdateAt, instanceUpdateAt)) {
              throw new OptimisticLockException("すでに更新されています。");
            }
          }
        }

        // SET句で使う更新日付をセットする
        setPropertyValue(recordParam, updatedAtPropertyName, AuditInfoHolder.getAuditDateTime());
      }
    }

    return invocation.proceed();
  }

  private Object getPropertyValue(Object obj, String propertyName) {
    try {
      PropertyDescriptor pd = new PropertyDescriptor(propertyName, obj.getClass());
      Method getterMethod = pd.getReadMethod();
      return getterMethod.invoke(obj);
    } catch (Exception e) {
      // ignore
    }
    return null;
  }

  private Object setPropertyValue(Object obj, String propertyName, Object value) {
    try {
      PropertyDescriptor pd = new PropertyDescriptor(propertyName, obj.getClass());
      Method setterMethod = pd.getWriteMethod();
      return setterMethod.invoke(obj, value);
    } catch (Exception e) {
      // ignore
    }
    return obj;
  }

  private String getSelectStatementId(MappedStatement mappedStatement) {
    return mappedStatement
        .getId()
        .replace("Mapper.update", "Mapper.select")
        .replace("Selective", "");
  }

  private boolean isTargetMappedStatement(MappedStatement mappedStatement) {
    for (String suffix : TARGET_STATEMENT_SUFFIX_LIST) {
      if (mappedStatement.getId().endsWith(suffix)) {
        return true;
      }
    }
    return false;
  }

  private boolean isUpdateByPrimaryKey(MappedStatement mappedStatement) {
    return mappedStatement.getId().endsWith(STATEMENT_SUFFIX_PRIMARY_KEY);
  }

  @SuppressWarnings("unchecked")
  private Object getMapperMethodParameter(Object parameter, String key) {
    return ((MapperMethod.ParamMap<Object>) parameter).get(key);
  }
}
