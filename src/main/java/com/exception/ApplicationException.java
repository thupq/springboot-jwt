package com.exception;


import com.common.enums.ErrorCodeEnum;
import com.locale.Translator;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApplicationException extends RuntimeException {

  private final ErrorCodeEnum code;
  private final transient Object[] args;

  public ApplicationException(ErrorCodeEnum code, Object... args) {
    super(Translator.toMessage(code, args));
    this.code = code;
    this.args = args;
  }

}
