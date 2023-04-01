package com.bigtreetc.mybatis.sample.domain.model.generated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;

@Getter
@Setter
public class UploadFiles implements Serializable {
  private Long uploadFileId;

  private String fileName;

  private String originalFileName;

  private String contentType;

  @JsonIgnore @CreatedBy private String createdBy;

  @CreatedDate private LocalDateTime createdAt;

  @JsonIgnore @LastModifiedBy private String updatedBy;

  @LastModifiedDate private LocalDateTime updatedAt;

  @Version private Long version;

  private byte[] content;

  private static final long serialVersionUID = 1L;

  public enum Column {
    uploadFileId("upload_file_id", "uploadFileId", "BIGINT", false),
    fileName("file_name", "fileName", "VARCHAR", false),
    originalFileName("original_file_name", "originalFileName", "VARCHAR", false),
    contentType("content_type", "contentType", "VARCHAR", false),
    createdBy("created_by", "createdBy", "VARCHAR", false),
    createdAt("created_at", "createdAt", "TIMESTAMP", false),
    updatedBy("updated_by", "updatedBy", "VARCHAR", false),
    updatedAt("updated_at", "updatedAt", "TIMESTAMP", false),
    version("version", "version", "BIGINT", false),
    content("content", "content", "LONGVARBINARY", false);

    private static final String BEGINNING_DELIMITER = "\"";

    private static final String ENDING_DELIMITER = "\"";

    private final String column;

    private final boolean isColumnNameDelimited;

    private final String javaProperty;

    private final String jdbcType;

    public String value() {
      return this.column;
    }

    public String getValue() {
      return this.column;
    }

    public String getJavaProperty() {
      return this.javaProperty;
    }

    public String getJdbcType() {
      return this.jdbcType;
    }

    Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
      this.column = column;
      this.javaProperty = javaProperty;
      this.jdbcType = jdbcType;
      this.isColumnNameDelimited = isColumnNameDelimited;
    }

    public String desc() {
      return this.getEscapedColumnName() + " DESC";
    }

    public String asc() {
      return this.getEscapedColumnName() + " ASC";
    }

    public static Column[] excludes(Column... excludes) {
      ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
      if (excludes != null && excludes.length > 0) {
        columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
      }
      return columns.toArray(new Column[] {});
    }

    public static Column[] all() {
      return Column.values();
    }

    public String getEscapedColumnName() {
      if (this.isColumnNameDelimited) {
        return new StringBuilder()
            .append(BEGINNING_DELIMITER)
            .append(this.column)
            .append(ENDING_DELIMITER)
            .toString();
      } else {
        return this.column;
      }
    }

    public String getAliasedEscapedColumnName() {
      return this.getEscapedColumnName();
    }
  }
}
