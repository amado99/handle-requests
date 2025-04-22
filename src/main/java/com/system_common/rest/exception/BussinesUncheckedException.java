package com.system_common.rest.exception;

public class BussinesUncheckedException extends RuntimeException{

    public BussinesUncheckedException(String message, Throwable cause) {
        super(message, cause);
    }
}
