package com.loumo.exceptions;

import com.loumo.commons.AppMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = false)
public class AppException extends RuntimeException {

    private static final long serialVersionUID = -3681940740582990782L;
    private String type;
    private Integer code;
    private String detail;
    private HttpStatus httpStatus;


    public AppException() {
        super();
    }

    public AppException(AppMessage message, HttpStatus httpStatus) {
        super();
        this.type = message.getType();
        this.code = message.getCode();
        this.detail = message.getMessage();
        this.httpStatus = httpStatus;
    }

    public AppException(String type, int code, String msg, HttpStatus httpStatus) {
        super();
        this.type = type;
        this.code = code;
        this.detail = msg;
        this.httpStatus = httpStatus;
    }

    public AppException(String message, HttpStatus httpStatus) {
        super();
        this.detail = message;
        this.type = "ERROR";
        this.code = 400;
        this.httpStatus = httpStatus;
    }

}
