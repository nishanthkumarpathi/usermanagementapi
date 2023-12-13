package com.bibf.usermanagementapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MySpecialException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public SimpleErrorResponse handleMySpecialException(MySpecialException e){
        //return e.getMessage();
        return new SimpleErrorResponse(HttpStatus.BAD_REQUEST.value(),"Not Found",e.getMessage());
    }

}
