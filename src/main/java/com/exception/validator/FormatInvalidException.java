package com.exception.validator;

public class FormatInvalidException extends RuntimeException {

    public static final String FORMAT_INVALID = "Sai kieu du lieu";

    public FormatInvalidException() {
        super();
    }

    public FormatInvalidException(String message) {
        super(message);
    }

    public FormatInvalidException(String message, Throwable cause) {
        super(message, cause);
    }
}
