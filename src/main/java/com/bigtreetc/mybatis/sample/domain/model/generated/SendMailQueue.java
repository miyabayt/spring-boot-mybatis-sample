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
public class SendMailQueue extends SendMailQueueKey implements Serializable {
  private String fromAddress;

  private String toAddress;

  private String ccAddress;

  private String bccAddress;

  private String subject;

  private LocalDateTime sentAt;

  @JsonIgnore @CreatedBy private String createdBy;

  @JsonIgnore @LastModifiedBy private String updatedBy;

  @LastModifiedDate private LocalDateTime updatedAt;

  @Version private Long version;

  private String body;

  private static final long serialVersionUID = 1L;

  public enum Column {
    sendMailQueueId("send_mail_queue_id", "sendMailQueueId", "BIGINT", false),
    createdAt("created_at", "createdAt", "TIMESTAMP", false),
    fromAddress("from_address", "fromAddress", "VARCHAR", false),
    toAddress("to_address", "toAddress", "VARCHAR", false),
    ccAddress("cc_address", "ccAddress", "VARCHAR", false),
    bccAddress("bcc_address", "bccAddress", "VARCHAR", false),
    subject("subject", "subject", "VARCHAR", false),
    sentAt("sent_at", "sentAt", "TIMESTAMP", false),
    createdBy("created_by", "createdBy", "VARCHAR", false),
    updatedBy("updated_by", "updatedBy", "VARCHAR", false),
    updatedAt("updated_at", "updatedAt", "TIMESTAMP", false),
    version("version", "version", "BIGINT", false),
    body("body", "body", "LONGVARCHAR", false);

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
