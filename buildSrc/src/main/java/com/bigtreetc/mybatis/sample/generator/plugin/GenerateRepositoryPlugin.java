package com.bigtreetc.mybatis.sample.generator.plugin;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

import java.util.*;
import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.*;
import org.mybatis.generator.codegen.XmlConstants;
import org.mybatis.generator.codegen.ibatis2.Ibatis2FormattingUtilities;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
import org.mybatis.generator.config.PropertyRegistry;

public class GenerateRepositoryPlugin extends PluginAdapter {

  private String javaTargetPackage;
  private String sqlMapTargetPackage;
  private Map<FullyQualifiedTable, List<XmlElement>> elementsToAdd = new HashMap<>();

  @Override
  public void setProperties(Properties properties) {
    super.setProperties(properties);
    javaTargetPackage = properties.getProperty("javaTargetPackage");
    sqlMapTargetPackage = properties.getProperty("sqlMapTargetPackage");
  }

  @Override
  public boolean validate(List<String> warnings) {
    return true;
  }

  @Override
  public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(
      IntrospectedTable introspectedTable) {
    GeneratedJavaFile repositoryJavaFile = createRepositoryJavaFile(introspectedTable);
    return Collections.singletonList(repositoryJavaFile);
  }

  @Override
  public List<GeneratedXmlFile> contextGenerateAdditionalXmlFiles(
      IntrospectedTable introspectedTable) {
    GeneratedXmlFile repositoryXmlFile = createRepositoryXmlFile(introspectedTable);
    return Collections.singletonList(repositoryXmlFile);
  }

  private GeneratedJavaFile createRepositoryJavaFile(IntrospectedTable introspectedTable) {
    FullyQualifiedTable fullyQualifiedTable = introspectedTable.getFullyQualifiedTable();
    String domainObjectName = fullyQualifiedTable.getDomainObjectName();
    String modelPackage = context.getJavaModelGeneratorConfiguration().getTargetPackage();

    // FullyQualifiedJavaType crudRepository = new FullyQualifiedJavaType("CrudRepository");
    // crudRepository.addTypeArgument(new FullyQualifiedJavaType(domainObjectName));
    // crudRepository.addTypeArgument(new FullyQualifiedJavaType("Long"));

    FullyQualifiedJavaType exampleJavaType =
        new FullyQualifiedJavaType(modelPackage + "." + domainObjectName + "Example");
    FullyQualifiedJavaType pageableJavaType =
        new FullyQualifiedJavaType("org.springframework.data.domain.Pageable");

    Interface repository = new Interface(javaTargetPackage + "." + domainObjectName + "Repository");
    repository.setVisibility(JavaVisibility.PUBLIC);
    // repository.addAnnotation("@Repository");
    // repository.addSuperInterface(crudRepository);
    repository.addImportedType(new FullyQualifiedJavaType(modelPackage + "." + domainObjectName));
    repository.addImportedType(exampleJavaType);
    //    repository.addImportedType(
    //        new FullyQualifiedJavaType("org.springframework.stereotype.Repository"));
    repository.addImportedType(new FullyQualifiedJavaType("org.springframework.data.domain.Page"));
    repository.addImportedType(pageableJavaType);

    FullyQualifiedJavaType findAllReturnType = new FullyQualifiedJavaType("Page");
    findAllReturnType.addTypeArgument(
        new FullyQualifiedJavaType(modelPackage + "." + domainObjectName));
    Method findAllMethod = new Method("findAll");
    findAllMethod.setReturnType(findAllReturnType);
    findAllMethod.addParameter(0, new Parameter(exampleJavaType, "example"));
    findAllMethod.addParameter(1, new Parameter(pageableJavaType, "pageable"));

    repository.addMethod(findAllMethod);

    return new GeneratedJavaFile(
        repository,
        context.getJavaModelGeneratorConfiguration().getTargetProject(),
        context.getProperty(PropertyRegistry.CONTEXT_JAVA_FILE_ENCODING),
        context.getJavaFormatter());
  }

  private GeneratedXmlFile createRepositoryXmlFile(IntrospectedTable introspectedTable) {
    FullyQualifiedTable fullyQualifiedTable = introspectedTable.getFullyQualifiedTable();
    String domainObjectName = fullyQualifiedTable.getDomainObjectName();

    String xmlFilename = domainObjectName + "Repository.xml";
    String xmlTargetPackage = javaTargetPackage + "." + domainObjectName + "Repository";

    XmlElement mapperElement = new XmlElement("mapper");
    mapperElement.addAttribute(new Attribute("namespace", xmlTargetPackage));

    addResultMapWithoutBLOBsElement(introspectedTable, mapperElement);
    addFindAllElement(introspectedTable, mapperElement);
    addCountElement(introspectedTable, mapperElement);

    Document document =
        new Document(
            XmlConstants.MYBATIS3_MAPPER_PUBLIC_ID, XmlConstants.MYBATIS3_MAPPER_SYSTEM_ID);
    document.setRootElement(mapperElement);

    return new GeneratedXmlFile(
        document,
        xmlFilename,
        sqlMapTargetPackage,
        context.getSqlMapGeneratorConfiguration().getTargetProject(),
        false,
        context.getXmlFormatter());
  }

  public void addResultMapWithoutBLOBsElement(
      IntrospectedTable introspectedTable, XmlElement parentElement) {
    XmlElement answer = new XmlElement("resultMap");
    answer.addAttribute(new Attribute("id", introspectedTable.getBaseResultMapId()));

    String returnType;
    if (introspectedTable.getRules().generateBaseRecordClass()) {
      returnType = introspectedTable.getBaseRecordType();
    } else {
      returnType = introspectedTable.getPrimaryKeyType();
    }

    answer.addAttribute(new Attribute("type", returnType));

    context.getCommentGenerator().addComment(answer);

    for (IntrospectedColumn introspectedColumn : introspectedTable.getNonBLOBColumns()) {
      XmlElement resultElement = new XmlElement("result");
      resultElement.addAttribute(
          new Attribute(
              "column",
              Ibatis2FormattingUtilities.getRenamedColumnNameForResultMap(introspectedColumn)));

      resultElement.addAttribute(new Attribute("property", introspectedColumn.getJavaProperty()));
      resultElement.addAttribute(new Attribute("jdbcType", introspectedColumn.getJdbcTypeName()));

      if (stringHasValue(introspectedColumn.getTypeHandler())) {
        resultElement.addAttribute(
            new Attribute("typeHandler", introspectedColumn.getTypeHandler()));
      }

      answer.addElement(resultElement);
    }

    if (context
        .getPlugins()
        .sqlMapResultMapWithoutBLOBsElementGenerated(answer, introspectedTable)) {
      parentElement.addElement(answer);
    }
  }

  public void addFindAllElement(IntrospectedTable introspectedTable, XmlElement parentElement) {
    XmlElement answer = new XmlElement("select");

    answer.addAttribute(new Attribute("id", "findAll"));
    answer.addAttribute(new Attribute("resultMap", introspectedTable.getBaseResultMapId()));
    answer.addAttribute(
        new Attribute(
            "parameterType", "com.bigtreetc.mybatis.sample.base.domain.dao.MyBatisContext"));

    context.getCommentGenerator().addComment(answer);

    StringBuilder sb = new StringBuilder();
    sb.append("select ");
    Iterator<IntrospectedColumn> iter = introspectedTable.getAllColumns().iterator();
    while (iter.hasNext()) {
      sb.append(MyBatis3FormattingUtilities.getSelectListPhrase(iter.next()));

      if (iter.hasNext()) {
        sb.append(", ");
      }

      if (sb.length() > 80) {
        answer.addElement(new TextElement(sb.toString()));
        sb.setLength(0);
      }
    }

    if (sb.length() > 0) {
      answer.addElement(new TextElement(sb.toString()));
    }

    sb.setLength(0);
    sb.append("from ");
    sb.append(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
    answer.addElement(new TextElement(sb.toString()));

    XmlElement whereElement = new XmlElement("where");

    XmlElement ifExampleNotNullElement = new XmlElement("if");
    ifExampleNotNullElement.addAttribute(new Attribute("test", "example != null"));

    XmlElement ifOredCriteriaNotNullElement = new XmlElement("if");
    ifOredCriteriaNotNullElement.addAttribute(
        new Attribute("test", "example != null and example.oredCriteria != null"));

    XmlElement outerForEachElement = new XmlElement("foreach");
    outerForEachElement.addAttribute(new Attribute("collection", "example.oredCriteria"));
    outerForEachElement.addAttribute(new Attribute("item", "criteria"));
    outerForEachElement.addAttribute(new Attribute("separator", "or"));

    XmlElement ifElement = new XmlElement("if");
    ifElement.addAttribute(new Attribute("test", "criteria.valid"));
    outerForEachElement.addElement(ifElement);
    ifOredCriteriaNotNullElement.addElement(outerForEachElement);

    XmlElement trimElement = new XmlElement("trim");
    trimElement.addAttribute(new Attribute("prefix", "("));
    trimElement.addAttribute(new Attribute("suffix", ")"));
    trimElement.addAttribute(new Attribute("prefixOverrides", "and"));
    ifElement.addElement(trimElement);

    trimElement.addElement(getMiddleForEachElement(null));

    for (IntrospectedColumn introspectedColumn : introspectedTable.getNonBLOBColumns()) {
      if (stringHasValue(introspectedColumn.getTypeHandler())) {
        trimElement.addElement(getMiddleForEachElement(introspectedColumn));
      }
    }

    whereElement.addElement(ifOredCriteriaNotNullElement);
    ifExampleNotNullElement.addElement(whereElement);
    answer.addElement(ifExampleNotNullElement);

    XmlElement ifLimitNotNullElement = new XmlElement("if");
    ifLimitNotNullElement.addAttribute(
        new Attribute("test", "pageable != null and pageable.pageSize != null"));

    XmlElement ifOffsetNotNullElement = new XmlElement("if");
    ifOffsetNotNullElement.addAttribute(new Attribute("test", "pageable.offset != null"));
    ifOffsetNotNullElement.addElement(
        new TextElement("limit ${pageable.pageSize} offset ${pageable.offset}"));
    ifLimitNotNullElement.addElement(ifOffsetNotNullElement);

    XmlElement ifOffsetNullElement = new XmlElement("if");
    ifOffsetNullElement.addAttribute(new Attribute("test", "pageable.offset == null"));
    ifOffsetNullElement.addElement(new TextElement("limit ${pageable.pageSize}"));
    ifLimitNotNullElement.addElement(ifOffsetNullElement);
    answer.addElement(ifLimitNotNullElement);

    if (context.getPlugins().sqlMapSelectAllElementGenerated(answer, introspectedTable)) {
      parentElement.addElement(answer);
    }
  }

  public void addCountElement(IntrospectedTable introspectedTable, XmlElement parentElement) {
    String modelPackage = context.getJavaModelGeneratorConfiguration().getTargetPackage();
    FullyQualifiedTable fullyQualifiedTable = introspectedTable.getFullyQualifiedTable();
    String domainObjectName = fullyQualifiedTable.getDomainObjectName();

    XmlElement answer = new XmlElement("select");
    answer.addAttribute(new Attribute("id", "count"));
    answer.addAttribute(new Attribute("resultType", "java.lang.Long"));
    answer.addAttribute(
        new Attribute("parameterType", modelPackage + "." + domainObjectName + "Example"));

    context.getCommentGenerator().addComment(answer);

    StringBuilder sb = new StringBuilder();
    sb.append("select ");
    sb.append("    count(*) ");
    sb.append("from ");
    sb.append(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
    answer.addElement(new TextElement(sb.toString()));

    XmlElement whereElement = new XmlElement("where");

    XmlElement ifOredCriteriaNotNullElement = new XmlElement("if");
    ifOredCriteriaNotNullElement.addAttribute(
        new Attribute("test", "_parameter != null and oredCriteria != null"));

    XmlElement outerForEachElement = new XmlElement("foreach");
    outerForEachElement.addAttribute(new Attribute("collection", "oredCriteria"));
    outerForEachElement.addAttribute(new Attribute("item", "criteria"));
    outerForEachElement.addAttribute(new Attribute("separator", "or"));

    XmlElement ifElement = new XmlElement("if");
    ifElement.addAttribute(new Attribute("test", "criteria.valid"));
    outerForEachElement.addElement(ifElement);
    ifOredCriteriaNotNullElement.addElement(outerForEachElement);

    XmlElement trimElement = new XmlElement("trim");
    trimElement.addAttribute(new Attribute("prefix", "("));
    trimElement.addAttribute(new Attribute("suffix", ")"));
    trimElement.addAttribute(new Attribute("prefixOverrides", "and"));
    ifElement.addElement(trimElement);

    trimElement.addElement(getMiddleForEachElement(null));

    for (IntrospectedColumn introspectedColumn : introspectedTable.getNonBLOBColumns()) {
      if (stringHasValue(introspectedColumn.getTypeHandler())) {
        trimElement.addElement(getMiddleForEachElement(introspectedColumn));
      }
    }

    whereElement.addElement(ifOredCriteriaNotNullElement);
    answer.addElement(whereElement);

    if (context.getPlugins().sqlMapSelectAllElementGenerated(answer, introspectedTable)) {
      parentElement.addElement(answer);
    }
  }

  private XmlElement getMiddleForEachElement(IntrospectedColumn introspectedColumn) {
    StringBuilder sb = new StringBuilder();
    String criteriaAttribute;
    boolean typeHandled;
    String typeHandlerString;
    if (introspectedColumn == null) {
      criteriaAttribute = "criteria.criteria";
      typeHandled = false;
      typeHandlerString = null;
    } else {
      sb.setLength(0);
      sb.append("criteria.");
      sb.append(introspectedColumn.getJavaProperty());
      sb.append("Criteria");
      criteriaAttribute = sb.toString();

      typeHandled = true;

      sb.setLength(0);
      sb.append(",typeHandler=");
      sb.append(introspectedColumn.getTypeHandler());
      typeHandlerString = sb.toString();
    }

    XmlElement middleForEachElement = new XmlElement("foreach");
    middleForEachElement.addAttribute(new Attribute("collection", criteriaAttribute));
    middleForEachElement.addAttribute(new Attribute("item", "criterion"));

    XmlElement chooseElement = new XmlElement("choose");
    middleForEachElement.addElement(chooseElement);

    XmlElement when = new XmlElement("when");
    when.addAttribute(new Attribute("test", "criterion.noValue"));
    when.addElement(new TextElement("and ${criterion.condition}"));
    chooseElement.addElement(when);

    when = new XmlElement("when");
    when.addAttribute(new Attribute("test", "criterion.singleValue"));
    sb.setLength(0);
    sb.append("and ${criterion.condition} #{criterion.value");
    if (typeHandled) {
      sb.append(typeHandlerString);
    }
    sb.append('}');
    when.addElement(new TextElement(sb.toString()));
    chooseElement.addElement(when);

    when = new XmlElement("when");
    when.addAttribute(new Attribute("test", "criterion.betweenValue"));
    sb.setLength(0);
    sb.append("and ${criterion.condition} #{criterion.value");
    if (typeHandled) {
      sb.append(typeHandlerString);
    }
    sb.append("} and #{criterion.secondValue");
    if (typeHandled) {
      sb.append(typeHandlerString);
    }
    sb.append('}');
    when.addElement(new TextElement(sb.toString()));
    chooseElement.addElement(when);

    when = new XmlElement("when");
    when.addAttribute(new Attribute("test", "criterion.listValue"));
    when.addElement(new TextElement("and ${criterion.condition}"));
    XmlElement innerForEach = new XmlElement("foreach");
    innerForEach.addAttribute(new Attribute("collection", "criterion.value"));
    innerForEach.addAttribute(new Attribute("item", "listItem"));
    innerForEach.addAttribute(new Attribute("open", "("));
    innerForEach.addAttribute(new Attribute("close", ")"));
    innerForEach.addAttribute(new Attribute("separator", ","));
    sb.setLength(0);
    sb.append("#{listItem");
    if (typeHandled) {
      sb.append(typeHandlerString);
    }
    sb.append('}');
    innerForEach.addElement(new TextElement(sb.toString()));
    when.addElement(innerForEach);
    chooseElement.addElement(when);

    return middleForEachElement;
  }
}
