package com.loumo.controllers.dtos;

import com.loumo.commons.AppMessage;

import java.io.Serializable;

public class ObjectResponse<T> implements Serializable {
    private int code;
    private String status;
    private String message;
    private T data;


    public ObjectResponse(AppMessage message, T data) {
        this.status = message.getType();
        this.code = message.getCode();
        this.message = message.getMessage();
        this.data = data;
    }

    public ObjectResponse(AppMessage message) {
        this.status = message.getType();
        this.code = message.getCode();
        this.message = message.getMessage();
    }

    public ObjectResponse(String status, int code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public ObjectResponse() {
    }
}
