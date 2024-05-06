package com.loumo.commons;

public enum AppMessage {

    /**
     *  SUCCESS
     */
    SUCCESS("SUCCESS", 2000, "Success."),
    SUCCESS_UPDATE("SUCCESS", 2000, "update success.");


    private int code;
    private String message;
    private String type;

    AppMessage(String type, int code, String message) {
        this.type = type;
        this.code = code;
        this.message = message;
    }

    AppMessage(int code, String message) {
        this.type="ERROR";
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }
}
