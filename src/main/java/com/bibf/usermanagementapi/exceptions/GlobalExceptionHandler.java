package com.bibf.usermanagementapi.exceptions;

import com.bibf.usermanagementapi.responses.ErrorResponse;
import com.bibf.usermanagementapi.responses.SimpleErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MySpecialException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public SimpleErrorResponse handleMySpecialException(MySpecialException e){
        //return e.getMessage();
        return new SimpleErrorResponse(HttpStatus.BAD_REQUEST.value(),"Not Found",e.getMessage());
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse handleNoSuchElementException(NoSuchElementException e){
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(),"Not Found", e.getMessage());

    }


}
