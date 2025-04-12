package com.system_common.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseGeneric<T> {

    private T data;
    private String[] notifications;

}
