package com.example.restexample.exception;

public class EntityNotFundException extends Exception {

    public EntityNotFundException() {
    }

    public EntityNotFundException(String message) {
        super(message);
    }

    public EntityNotFundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFundException(Throwable cause) {
        super(cause);
    }

    public EntityNotFundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
