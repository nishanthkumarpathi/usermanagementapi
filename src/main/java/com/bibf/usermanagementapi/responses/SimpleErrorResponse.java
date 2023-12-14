package com.bibf.usermanagementapi.responses;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SimpleErrorResponse {

    private final Integer statusCode;
    private final String message;
    private final String error;
    private final LocalDateTime timestamp;

    // When exception is a single error (like most other exceptions)
    public SimpleErrorResponse(Integer statusCode, String message, String error){
        this.statusCode = statusCode;
        this.message = message;
        this.error = error;
        this.timestamp = LocalDateTime.now();
    }
}
