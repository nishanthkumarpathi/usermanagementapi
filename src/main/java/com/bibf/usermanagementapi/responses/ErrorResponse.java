package com.bibf.usermanagementapi.responses;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Getter
public class ErrorResponse {

    private final Integer statusCode;
    private final String message;
    private final List<String> errors;
    private final LocalDateTime timestamp;

    // When exception is a group of errors (like validation)
    public ErrorResponse(Integer statusCode, String message, List<String> errors){
        this.statusCode = statusCode;
        this.message = message;
        this.errors = errors;
        this.timestamp = LocalDateTime.now();
    }


    // When exception is a single error (like most other exceptions)
    public ErrorResponse(Integer statusCode, String message, String error){
        this.statusCode = statusCode;
        this.message = message;
        this.errors = Collections.singletonList(error);
        this.timestamp = LocalDateTime.now();
    }

}
