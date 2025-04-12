package com.system_common.rest.exception;

import com.system_common.rest.dto.ResponseGeneric;


public class RestApiServerException extends RuntimeException{

    private final ResponseGeneric<Object> response;
    public RestApiServerException(String message,  ResponseGeneric<Object> response){
        super(message);
        this.response = response;
    }

    public ResponseGeneric<Object> getResponse() {
        return response;
    }

    public String getResponseClient(){
        if(this.response == null) return null;
        return String.join(" | ", this.response.getNotifications());
    }
}
