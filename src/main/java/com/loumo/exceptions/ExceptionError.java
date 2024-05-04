package com.loumo.exceptions;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ExceptionError implements Serializable {
    private String type;
    private Integer status;
    private Integer code;
    private String detail;
    private String instance="";
}
