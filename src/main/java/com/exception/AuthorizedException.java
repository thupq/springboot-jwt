package com.exception;

public class AuthorizedException extends RuntimeException{
    public AuthorizedException() {
        super();
    }

    public AuthorizedException(String message) {
        super(message);
    }

    public AuthorizedException(String message, Throwable cause) {
        super(message, cause);
    }

}
