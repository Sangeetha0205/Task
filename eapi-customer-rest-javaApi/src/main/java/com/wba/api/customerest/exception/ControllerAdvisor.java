package com.wba.api.customerest.exception;

import com.wba.api.customerest.constant.EapiErrorEnum;
import com.wba.api.customerest.constant.WalgErrorEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 165571
 * @href <mohammedanas.abdulrasheed@ust.com>
 * @createdon 2/12/2021
 *
 * Class generating custom error messages
 */

@ControllerAdvice
public class ControllerAdvisor{

    ErrorObject errorObj;
    ArrayList<ErrorObject> errors;

    @ExceptionHandler
    ResponseEntity<Object> showCustomErrorMessage(Exception exception){

        WalgErrorEnum walgErrorCode;

        //Default value taken as 500 & Internal Server Error
        HttpStatus httpStatus=  HttpStatus.INTERNAL_SERVER_ERROR;
        String exceptionMessage=EapiErrorEnum.ERRROR500.getMessage();

        if(exception instanceof HttpRequestMethodNotSupportedException){

            httpStatus=HttpStatus.METHOD_NOT_ALLOWED;
            exceptionMessage=EapiErrorEnum.ERRROR405.getMessage();;
        }
        else if(exception instanceof MissingServletRequestParameterException){

            httpStatus=HttpStatus.BAD_REQUEST;
            exceptionMessage=EapiErrorEnum.ERRROR400.getMessage();
        }
        else if (exception instanceof ResponseStatusException){

            ResponseStatusException responseStatusException= (ResponseStatusException) exception;
            httpStatus=  responseStatusException.getStatus();
            exceptionMessage=responseStatusException.getReason();
        }

        switch(httpStatus.value()){ // choose the walgreens error code as per http status

            case 400 : walgErrorCode=WalgErrorEnum.WAG_E_INVALID_REQUEST_1001;break;
            case 404 : walgErrorCode=WalgErrorEnum.WAG_E_SEARCH_1000;break;
            case 401 : walgErrorCode=WalgErrorEnum.WAG_E_UNAUTHORIZED_REQUEST_1001;break;
            case 500 : walgErrorCode=WalgErrorEnum.WAG_E_SVC_ERROR_1000;break;
            default  : walgErrorCode=WalgErrorEnum.WAG_E_INVALID_METHOD_1001;break;
        }

        errors=new ArrayList<>();
        errorObj=new ErrorObject( walgErrorCode.toString(),exceptionMessage,"ERROR");

        Map<String, Object> body = new LinkedHashMap<>();
        errors.add(errorObj);
        body.put("messages", errors);

        return new ResponseEntity<>(body,httpStatus);
    }

}
