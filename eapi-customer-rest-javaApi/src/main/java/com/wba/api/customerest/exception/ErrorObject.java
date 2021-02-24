package com.wba.api.customerest.exception;

import java.io.Serializable;

/**
 * @author 165571
 * @href <mohammedanas.abdulrasheed@ust.com>
 * @createdon 2/12/2021
 *
 * Class representing standard error message format
 */

public class ErrorObject implements Serializable {

    private String code;
    private String message;
    private String type;

    public ErrorObject(String code, String message, String type) {

        this.code = code;
        this.message = message;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
