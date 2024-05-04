package com.loumo.controllers.dtos;

import com.loumo.commons.AppMessage;
import lombok.Data;

import java.io.Serializable;


@Data
public class VoidResponse implements Serializable {

    private int code;
    private String status;
    private String message;


    public VoidResponse(AppMessage message) {
        this.status = message.getType();
        this.code = message.getCode();
        this.message = message.getMessage();
    }

    public VoidResponse(int code, String status, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public VoidResponse() {
    }
}
