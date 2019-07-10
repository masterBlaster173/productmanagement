package com.alexanderbaranov.productmanagement.exception;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ExceptionResponse {

  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MMM-dd HH:mm:ss z")
  private Date timestamp;
  private String message;

  public ExceptionResponse(Date timestamp, String message) {
    super();
    this.timestamp = timestamp;
    this.message = message;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public String getMessage() {
    return message;
  }


}