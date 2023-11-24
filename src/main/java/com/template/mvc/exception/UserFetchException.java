package com.template.mvc.exception;

public class UserFetchException extends RuntimeException {
    public UserFetchException(String message, Throwable cause) {
        super(message, cause);
    }
}
