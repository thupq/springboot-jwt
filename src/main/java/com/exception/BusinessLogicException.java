package com.exception;

import com.common.enums.ErrorCodeEnum;

public class BusinessLogicException extends ApplicationException {

    public BusinessLogicException(ErrorCodeEnum code, Object... args) {
        super(code, args);
    }

    public BusinessLogicException(String message) {
        super(ErrorCodeEnum.ER0000);
    }

}
