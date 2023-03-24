package com.exception;

import com.common.enums.ErrorCodeEnum;

/**
 * Validate dữ liệu đầu vào
 *
 * @author osfpt_nhatnc
 * @version v1
 * @date 10/15/2020
 */
public class InputInvalidException extends ApplicationException {

  public InputInvalidException(ErrorCodeEnum code, Object... args) {
    super(code, args);
  }
}
