package com.wba.api.customerest.constant;

/**
 * @author 165571
 * @href <mohammedanas.abdulrasheed@ust.com>
 * @createdon 2/16/2021
 */

public enum EapiErrorEnum {

    ERRROR404("Patient records not found !!! Please ensure requested values are correct !!! "),
    ERRROR500("Sorry! This service is temporarily unavailable. Please try again later."),
    ERRROR503("DB Service Temporarily down !!! Try again after some time..."),
    ERRROR400(" Invalid/Bad Request.. please ensure request body/params are correct"),
    ERRROR401("Unauthorized request..method not allowed.."),
    ERRROR405("Unauthorized request..method not allowed..");


    private String message;

    public String getMessage() {
        return message;
    }

    private EapiErrorEnum(String message) {
        this.message = message;
    }
}
