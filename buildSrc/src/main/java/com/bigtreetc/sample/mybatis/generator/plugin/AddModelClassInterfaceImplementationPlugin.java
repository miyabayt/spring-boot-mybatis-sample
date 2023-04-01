package com.bigtreetc.sample.mybatis.generator.plugin;

import java.util.List;
import java.util.Properties;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;

public class AddModelClassInterfaceImplementationPlugin extends PluginAdapter {

  private String interfaze;

  private String importType;

  @Override
  public void setProperties(Properties properties) {
    super.setProperties(properties);
    interfaze = properties.getProperty("interfaze");
    importType = properties.getProperty("importType");
  }

  @Override
  public boolean validate(List<String> warnings) {
    return true;
  }

  @Override
  public boolean modelBaseRecordClassGenerated(
      TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
    topLevelClass.addImportedType(importType);
    topLevelClass.addSuperInterface(new FullyQualifiedJavaType(interfaze));
    return true;
  }
}
