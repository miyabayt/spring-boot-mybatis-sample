package com.bigtreetc.sample.mybatis.generator.plugin;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

import java.util.*;
import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.*;
import org.mybatis.generator.codegen.XmlConstants;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
import org.mybatis.generator.config.PropertyRegistry;

public class GenerateRepositoryPlugin extends PluginAdapter {

  private String modelJavaTargetPackage;
  private String repositoryJavaTargetPackage;
  private String sqlMapTargetPackage;
  private Map<FullyQualifiedTable, List<XmlElement>> elementsToAdd = new HashMap<>();

  @Override
  public void setProperties(Properties properties) {
    super.setProperties(properties);
    modelJavaTargetPackage = properties.getProperty("modelJavaTargetPackage");
    repositoryJavaTargetPackage = properties.getProperty("repositoryJavaTargetPackage");
    sqlMapTargetPackage = properties.getProperty("sqlMapTargetPackage");
  }

  @Override
  public boolean validate(List<String> warnings) {
    return true;
  }

  @Override
  public boolean clientGenerated(
      Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
    FullyQualifiedTable fullyQualifiedTable = introspectedTable.getFullyQualifiedTable();
    String domainObjectName = fullyQualifiedTable.getDomainObjectName();
    String modelGeneratePackage = context.getJavaModelGeneratorConfiguration().getTargetPackage();

    FullyQualifiedJavaType returnType = new FullyQualifiedJavaType("Cursor");
    returnType.addTypeArgument(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()));
    FullyQualifiedJavaType exampleJavaType =
        new FullyQualifiedJavaType(modelGeneratePackage + "." + domainObjectName + "Example");

    Method method = new Method();
    method.setVisibility(JavaVisibility.PUBLIC);
    method.setReturnType(returnType);
    method.setName("selectWithCursorByExample");
    method.addParameter(new Parameter(exampleJavaType, "example"));

    interfaze.addMethod(method);
    interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.cursor.Cursor"));

    return true;
  }

  @Override
  public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
    XmlElement rootElement = document.getRootElement();
    addSelectWithCursorByExampleElement(introspectedTable, rootElement);
    return super.sqlMapDocumentGenerated(document, introspectedTable);
  }

  @Override
  public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(
      IntrospectedTable introspectedTable) {
    GeneratedJavaFile repositoryJavaFile = createRepositoryJavaFile(introspectedTable);
    GeneratedJavaFile repositoryJavaImplFile = createRepositoryJavaImplFile(introspectedTable);
    return List.of(repositoryJavaFile, repositoryJavaImplFile);
  }

  @Override
  public List<GeneratedXmlFile> contextGenerateAdditionalXmlFiles(
      IntrospectedTable introspectedTable) {
    GeneratedXmlFile repositoryXmlFile = createRepositoryXmlFile(introspectedTable);
    return List.of(repositoryXmlFile);
  }

  private GeneratedJavaFile createRepositoryJavaFile(IntrospectedTable introspectedTable) {
    FullyQualifiedTable fullyQualifiedTable = introspectedTable.getFullyQualifiedTable();
    String domainObjectName = fullyQualifiedTable.getDomainObjectName();
    String modelGeneratePackage = context.getJavaModelGeneratorConfiguration().getTargetPackage();

    String domainObjectNameCamel =
        Character.toLowerCase(domainObjectName.charAt(0)) + domainObjectName.substring(1);

    FullyQualifiedJavaType exampleJavaType =
        new FullyQualifiedJavaType(modelGeneratePackage + "." + domainObjectName + "Example");
    FullyQualifiedJavaType pageableJavaType =
        new FullyQualifiedJavaType("org.springframework.data.domain.Pageable");

    Interface repository =
        new Interface(repositoryJavaTargetPackage + "." + domainObjectName + "Repository");
    repository.setVisibility(JavaVisibility.PUBLIC);
    repository.addImportedType(
        new FullyQualifiedJavaType(modelGeneratePackage + "." + domainObjectName));
    repository.addImportedType(exampleJavaType);
    repository.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.cursor.Cursor"));
    repository.addImportedType(new FullyQualifiedJavaType("org.springframework.data.domain.Page"));
    repository.addImportedType(pageableJavaType);

    Method findByIdMethod = new Method("findById");
    findByIdMethod.setReturnType(new FullyQualifiedJavaType(domainObjectName));
    addPrimaryKeyArguments(introspectedTable, findByIdMethod);
    if (introspectedTable.getRules().generatePrimaryKeyClass()) {
      repository.addImportedType(new FullyQualifiedJavaType(introspectedTable.getPrimaryKeyType()));
    }
    repository.addMethod(findByIdMethod);

    FullyQualifiedJavaType findOneReturnType = new FullyQualifiedJavaType("Optional");
    findOneReturnType.addTypeArgument(
        new FullyQualifiedJavaType(modelGeneratePackage + "." + domainObjectName));
    Method findOneMethod = new Method("findOne");
    findOneMethod.setReturnType(findOneReturnType);
    findOneMethod.addParameter(0, new Parameter(exampleJavaType, "example"));
    repository.addMethod(findOneMethod);
    repository.addImportedType(new FullyQualifiedJavaType("java.util.List"));
    repository.addImportedType(new FullyQualifiedJavaType("java.util.Optional"));

    FullyQualifiedJavaType findAllReturnType = new FullyQualifiedJavaType("Page");
    findAllReturnType.addTypeArgument(
        new FullyQualifiedJavaType(modelGeneratePackage + "." + domainObjectName));
    Method findAllMethod = new Method("findAll");
    findAllMethod.setReturnType(findAllReturnType);
    findAllMethod.addParameter(0, new Parameter(exampleJavaType, "example"));
    findAllMethod.addParameter(1, new Parameter(pageableJavaType, "pageable"));
    repository.addMethod(findAllMethod);

    FullyQualifiedJavaType findAllCursorReturnType = new FullyQualifiedJavaType("Cursor");
    findAllCursorReturnType.addTypeArgument(
        new FullyQualifiedJavaType(modelGeneratePackage + "." + domainObjectName));
    Method findAllCursorMethod = new Method("findAll");
    findAllCursorMethod.setReturnType(findAllCursorReturnType);
    findAllCursorMethod.addParameter(0, new Parameter(exampleJavaType, "example"));
    repository.addMethod(findAllCursorMethod);

    Method createMethod = new Method("create");
    createMethod.setReturnType(new FullyQualifiedJavaType("int"));
    createMethod.addParameter(
        0,
        new Parameter(
            new FullyQualifiedJavaType(modelGeneratePackage + "." + domainObjectName),
            domainObjectNameCamel));
    repository.addMethod(createMethod);

    FullyQualifiedJavaType createAllParameterType = new FullyQualifiedJavaType("List");
    createAllParameterType.addTypeArgument(
        new FullyQualifiedJavaType(modelGeneratePackage + "." + domainObjectName));
    Method createAllMethod = new Method("createAll");
    createAllMethod.setReturnType(new FullyQualifiedJavaType("int"));
    createAllMethod.addParameter(0, new Parameter(createAllParameterType, "list"));
    repository.addMethod(createAllMethod);

    Method updateMethod = new Method("update");
    updateMethod.setReturnType(new FullyQualifiedJavaType("int"));
    updateMethod.addParameter(
        0,
        new Parameter(
            new FullyQualifiedJavaType(modelGeneratePackage + "." + domainObjectName),
            domainObjectNameCamel));
    repository.addMethod(updateMethod);

    Method deleteMethod = new Method("delete");
    deleteMethod.setReturnType(new FullyQualifiedJavaType("int"));
    addPrimaryKeyArguments(introspectedTable, deleteMethod);
    if (introspectedTable.getRules().generatePrimaryKeyClass()) {
      repository.addImportedType(new FullyQualifiedJavaType(introspectedTable.getPrimaryKeyType()));
    }
    repository.addMethod(deleteMethod);

    return new GeneratedJavaFile(
        repository,
        context.getJavaModelGeneratorConfiguration().getTargetProject(),
        context.getProperty(PropertyRegistry.CONTEXT_JAVA_FILE_ENCODING),
        context.getJavaFormatter());
  }

  private GeneratedJavaFile createRepositoryJavaImplFile(IntrospectedTable introspectedTable) {
    FullyQualifiedTable fullyQualifiedTable = introspectedTable.getFullyQualifiedTable();
    String domainObjectName = fullyQualifiedTable.getDomainObjectName();
    String modelGeneratePackage = context.getJavaModelGeneratorConfiguration().getTargetPackage();
    String mapperGeneratePackage = context.getJavaClientGeneratorConfiguration().getTargetPackage();

    String domainObjectNameCamel =
        Character.toLowerCase(domainObjectName.charAt(0)) + domainObjectName.substring(1);

    FullyQualifiedJavaType exampleJavaType =
        new FullyQualifiedJavaType(modelGeneratePackage + "." + domainObjectName + "Example");
    FullyQualifiedJavaType pageableJavaType =
        new FullyQualifiedJavaType("org.springframework.data.domain.Pageable");

    TopLevelClass repository =
        new TopLevelClass(repositoryJavaTargetPackage + "." + domainObjectName + "RepositoryImpl");
    repository.addSuperInterface(new FullyQualifiedJavaType(domainObjectName + "Repository"));
    repository.setVisibility(JavaVisibility.PUBLIC);
    repository.addAnnotation("@RequiredArgsConstructor");
    repository.addAnnotation("@Repository");
    repository.addImportedType(
        new FullyQualifiedJavaType("com.bigtreetc.sample.mybatis.base.domain.dao.MyBatisContext"));
    repository.addImportedType(
        new FullyQualifiedJavaType(mapperGeneratePackage + "." + domainObjectName + "Mapper"));
    repository.addImportedType(
        new FullyQualifiedJavaType(modelGeneratePackage + "." + domainObjectName));
    repository.addImportedType(exampleJavaType);
    repository.addImportedType(new FullyQualifiedJavaType("lombok.NonNull"));
    repository.addImportedType(new FullyQualifiedJavaType("lombok.RequiredArgsConstructor"));
    repository.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.cursor.Cursor"));
    repository.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.session.SqlSession"));
    repository.addImportedType(
        new FullyQualifiedJavaType("org.springframework.stereotype.Repository"));
    repository.addImportedType(
        new FullyQualifiedJavaType(
            "org.springframework.dao.IncorrectResultSizeDataAccessException"));
    repository.addImportedType(new FullyQualifiedJavaType("org.springframework.data.domain.Page"));
    repository.addImportedType(
        new FullyQualifiedJavaType("org.springframework.data.domain.PageImpl"));
    repository.addImportedType(pageableJavaType);
    repository.addImportedType(new FullyQualifiedJavaType("java.util.List"));
    repository.addImportedType(new FullyQualifiedJavaType("java.util.Optional"));

    Field sqlSessionField = new Field();
    sqlSessionField.addAnnotation("@NonNull");
    sqlSessionField.setFinal(true);
    sqlSessionField.setType(new FullyQualifiedJavaType("org.apache.ibatis.session.SqlSession"));
    sqlSessionField.setName("sqlSession");
    repository.addField(sqlSessionField);

    String mapperFieldName =
        Character.toLowerCase(domainObjectName.charAt(0))
            + domainObjectName.substring(1)
            + "Mapper";
    Field mapperField = new Field();
    mapperField.addAnnotation("@NonNull");
    mapperField.setFinal(true);
    mapperField.setType(
        new FullyQualifiedJavaType(mapperGeneratePackage + "." + domainObjectName + "Mapper"));
    mapperField.setName(mapperFieldName);
    repository.addField(mapperField);

    FullyQualifiedJavaType findAllReturnType = new FullyQualifiedJavaType("Page");
    findAllReturnType.addTypeArgument(
        new FullyQualifiedJavaType(modelGeneratePackage + "." + domainObjectName));

    Method findByIdMethod = new Method("findById");
    findByIdMethod.addAnnotation("@Override");
    findByIdMethod.setVisibility(JavaVisibility.PUBLIC);
    findByIdMethod.setReturnType(
        new FullyQualifiedJavaType(modelGeneratePackage + "." + domainObjectName));

    addPrimaryKeyArguments(introspectedTable, findByIdMethod);
    if (introspectedTable.getRules().generatePrimaryKeyClass()) {
      repository.addImportedType(new FullyQualifiedJavaType(introspectedTable.getPrimaryKeyType()));
      findByIdMethod.addBodyLine("return " + mapperFieldName + ".selectByPrimaryKey(key);");
    } else {
      List<String> findByIdArgs = new ArrayList<>();
      for (int i = 0; i < introspectedTable.getPrimaryKeyColumns().size(); i++) {
        findByIdArgs.add("pk" + (i + 1));
      }

      findByIdMethod.addBodyLine(
          "return "
              + mapperFieldName
              + ".selectByPrimaryKey("
              + String.join(",", findByIdArgs)
              + ");");
    }
    repository.addMethod(findByIdMethod);

    FullyQualifiedJavaType findOneReturnType = new FullyQualifiedJavaType("Optional");
    findOneReturnType.addTypeArgument(
        new FullyQualifiedJavaType(modelGeneratePackage + "." + domainObjectName));
    Method findOneMethod = new Method("findOne");
    findOneMethod.addAnnotation("@Override");
    findOneMethod.setVisibility(JavaVisibility.PUBLIC);
    findOneMethod.setReturnType(findOneReturnType);
    findOneMethod.addParameter(0, new Parameter(exampleJavaType, "example"));
    findOneMethod.addBodyLine(
        "String namespacePrefix = " + domainObjectName + "Repository.class.getName();");
    findOneMethod.addBodyLine(
        "List<"
            + domainObjectName
            + "> list = sqlSession.selectList(namespacePrefix + \".findAll\", new MyBatisContext(example, Pageable.ofSize(2)));");
    findOneMethod.addBodyLine("if (list.isEmpty()) {");
    findOneMethod.addBodyLine("return Optional.empty();");
    findOneMethod.addBodyLine("}");
    findOneMethod.addBodyLine("if (list.size() >= 2) {");
    findOneMethod.addBodyLine("throw new IncorrectResultSizeDataAccessException(1);");
    findOneMethod.addBodyLine("}");
    findOneMethod.addBodyLine("return Optional.of(list.get(0));");
    repository.addMethod(findOneMethod);

    Method findAllMethod = new Method("findAll");
    findAllMethod.addAnnotation("@Override");
    findAllMethod.setVisibility(JavaVisibility.PUBLIC);
    findAllMethod.setReturnType(findAllReturnType);
    findAllMethod.addParameter(0, new Parameter(exampleJavaType, "example"));
    findAllMethod.addParameter(1, new Parameter(pageableJavaType, "pageable"));
    findAllMethod.addBodyLine(
        "String namespacePrefix = " + domainObjectName + "Repository.class.getName();");
    findAllMethod.addBodyLine(
        "List<"
            + domainObjectName
            + "> list = sqlSession.selectList(namespacePrefix + \".findAll\", new MyBatisContext(example, pageable));");
    findAllMethod.addBodyLine(
        "Long count = sqlSession.selectOne(namespacePrefix + \".count\", example);");
    findAllMethod.addBodyLine("return new PageImpl<>(list, pageable, count);");
    repository.addMethod(findAllMethod);

    FullyQualifiedJavaType findAllCursorReturnType = new FullyQualifiedJavaType("Cursor");
    findAllCursorReturnType.addTypeArgument(
        new FullyQualifiedJavaType(modelGeneratePackage + "." + domainObjectName));
    Method findAllCursorMethod = new Method("findAll");
    findAllCursorMethod.addAnnotation("@Override");
    findAllCursorMethod.setVisibility(JavaVisibility.PUBLIC);
    findAllCursorMethod.setReturnType(findAllCursorReturnType);
    findAllCursorMethod.addParameter(0, new Parameter(exampleJavaType, "example"));
    findAllCursorMethod.addBodyLine(
        "return " + domainObjectNameCamel + "Mapper.selectWithCursorByExample(example);");
    repository.addMethod(findAllCursorMethod);

    Method createMethod = new Method("create");
    createMethod.addAnnotation("@Override");
    createMethod.setVisibility(JavaVisibility.PUBLIC);
    createMethod.setReturnType(new FullyQualifiedJavaType("int"));
    createMethod.addParameter(
        0,
        new Parameter(
            new FullyQualifiedJavaType(modelGeneratePackage + "." + domainObjectName),
            domainObjectNameCamel));
    createMethod.addBodyLine(
        "return " + domainObjectNameCamel + "Mapper.insert(" + domainObjectNameCamel + ");");
    repository.addMethod(createMethod);

    FullyQualifiedJavaType createAllParameterType = new FullyQualifiedJavaType("List");
    createAllParameterType.addTypeArgument(
        new FullyQualifiedJavaType(modelGeneratePackage + "." + domainObjectName));
    Method createAllMethod = new Method("createAll");
    createAllMethod.addAnnotation("@Override");
    createAllMethod.setVisibility(JavaVisibility.PUBLIC);
    createAllMethod.setReturnType(new FullyQualifiedJavaType("int"));
    createAllMethod.addParameter(0, new Parameter(createAllParameterType, "list"));
    createAllMethod.addBodyLine("return " + domainObjectNameCamel + "Mapper.batchInsert(list);");
    repository.addMethod(createAllMethod);

    Method updateMethod = new Method("update");
    updateMethod.addAnnotation("@Override");
    updateMethod.setVisibility(JavaVisibility.PUBLIC);
    updateMethod.setReturnType(new FullyQualifiedJavaType("int"));
    updateMethod.addParameter(
        0,
        new Parameter(
            new FullyQualifiedJavaType(modelGeneratePackage + "." + domainObjectName),
            domainObjectNameCamel));
    updateMethod.addBodyLine(
        "return "
            + domainObjectNameCamel
            + "Mapper.updateByPrimaryKey("
            + domainObjectNameCamel
            + ");");
    repository.addMethod(updateMethod);

    Method deleteMethod = new Method("delete");
    deleteMethod.addAnnotation("@Override");
    deleteMethod.setVisibility(JavaVisibility.PUBLIC);
    deleteMethod.setReturnType(new FullyQualifiedJavaType("int"));

    addPrimaryKeyArguments(introspectedTable, deleteMethod);
    if (introspectedTable.getRules().generatePrimaryKeyClass()) {
      repository.addImportedType(new FullyQualifiedJavaType(introspectedTable.getPrimaryKeyType()));
      deleteMethod.addBodyLine("return " + mapperFieldName + ".deleteByPrimaryKey(key);");
    } else {
      List<String> deleteByIdArgs = new ArrayList<>();
      for (int i = 0; i < introspectedTable.getPrimaryKeyColumns().size(); i++) {
        deleteByIdArgs.add("pk" + (i + 1));
      }
      deleteMethod.addBodyLine(
          "return "
              + domainObjectNameCamel
              + "Mapper.deleteByPrimaryKey("
              + String.join(",", deleteByIdArgs)
              + ");");
    }
    repository.addMethod(deleteMethod);

    return new GeneratedJavaFile(
        repository,
        context.getJavaModelGeneratorConfiguration().getTargetProject(),
        context.getProperty(PropertyRegistry.CONTEXT_JAVA_FILE_ENCODING),
        context.getJavaFormatter());
  }

  private void addPrimaryKeyArguments(IntrospectedTable introspectedTable, Method method) {
    if (introspectedTable.getRules().generatePrimaryKeyClass()) {
      FullyQualifiedJavaType type =
          new FullyQualifiedJavaType(introspectedTable.getPrimaryKeyType());
      method.addParameter(new Parameter(type, "key"));
    } else {
      for (int i = 0; i < introspectedTable.getPrimaryKeyColumns().size(); i++) {
        IntrospectedColumn primaryKeyColumn = introspectedTable.getPrimaryKeyColumns().get(i);
        FullyQualifiedJavaType primaryKeyType = primaryKeyColumn.getFullyQualifiedJavaType();
        method.addParameter(
            i,
            new Parameter(
                new FullyQualifiedJavaType(primaryKeyType.getFullyQualifiedName()),
                "pk" + (i + 1)));
      }
    }
  }

  private GeneratedXmlFile createRepositoryXmlFile(IntrospectedTable introspectedTable) {
    FullyQualifiedTable fullyQualifiedTable = introspectedTable.getFullyQualifiedTable();
    String domainObjectName = fullyQualifiedTable.getDomainObjectName();

    String xmlFilename = domainObjectName + "Repository.xml";
    String xmlTargetPackage = repositoryJavaTargetPackage + "." + domainObjectName + "Repository";

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

  private void addResultMapWithoutBLOBsElement(
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
              MyBatis3FormattingUtilities.getRenamedColumnNameForResultMap(introspectedColumn)));

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
            "parameterType", "com.bigtreetc.sample.mybatis.base.domain.dao.MyBatisContext"));

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
        new Attribute("test", "pageable != null and pageable.isPaged"));

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
    FullyQualifiedTable fullyQualifiedTable = introspectedTable.getFullyQualifiedTable();
    String domainObjectName = fullyQualifiedTable.getDomainObjectName();
    String modelGeneratePackage = context.getJavaModelGeneratorConfiguration().getTargetPackage();

    XmlElement answer = new XmlElement("select");
    answer.addAttribute(new Attribute("id", "count"));
    answer.addAttribute(new Attribute("resultType", "java.lang.Long"));
    answer.addAttribute(
        new Attribute("parameterType", modelGeneratePackage + "." + domainObjectName + "Example"));

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

  public void addSelectWithCursorByExampleElement(
      IntrospectedTable introspectedTable, XmlElement parentElement) {
    String fqjt = introspectedTable.getExampleType();

    XmlElement answer = new XmlElement("select");

    answer.addAttribute(new Attribute("id", "selectWithCursorByExample"));
    answer.addAttribute(new Attribute("resultMap", introspectedTable.getBaseResultMapId()));
    answer.addAttribute(new Attribute("parameterType", fqjt));

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
    ifExampleNotNullElement.addAttribute(new Attribute("test", "_parameter != null"));

    XmlElement ifOredCriteriaNotNullElement = new XmlElement("if");
    ifOredCriteriaNotNullElement.addAttribute(
        new Attribute("test", "_parameter != null and _parameter.oredCriteria != null"));

    XmlElement outerForEachElement = new XmlElement("foreach");
    outerForEachElement.addAttribute(new Attribute("collection", "_parameter.oredCriteria"));
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
