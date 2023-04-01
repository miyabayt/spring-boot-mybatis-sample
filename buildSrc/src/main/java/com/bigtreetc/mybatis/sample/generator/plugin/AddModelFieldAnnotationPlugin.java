package com.bigtreetc.mybatis.sample.generator.plugin;

import java.util.List;
import java.util.Objects;
import java.util.Properties;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;

public class AddModelFieldAnnotationPlugin extends PluginAdapter {

  private String[] columns;

  private String annotation;

  private String importType;

  @Override
  public void setProperties(Properties properties) {
    super.setProperties(properties);
    columns = split(properties.getProperty("columns"));
    annotation = properties.getProperty("annotation");
    importType = properties.getProperty("importType");
  }

  @Override
  public boolean validate(List<String> warnings) {
    return true;
  }

  @Override
  public boolean modelFieldGenerated(
      Field field,
      TopLevelClass topLevelClass,
      IntrospectedColumn introspectedColumn,
      IntrospectedTable introspectedTable,
      ModelClassType modelClassType) {

    if (columns != null) {
      for (String column : columns) {
        column = column.strip();
        if (Objects.equals(column, introspectedColumn.getActualColumnName())) {
          topLevelClass.addImportedType(importType);
          field.addAnnotation(annotation);
        }
      }
    }

    return true;
  }

  private String[] split(String value) {
    return (value != null) ? value.split(",") : null;
  }
}
