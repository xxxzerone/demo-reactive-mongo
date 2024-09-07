package com.example.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class APIException {
    @ExceptionHandler(Exception.class)
    public APIResponse handleException(Exception e) {
        return APIResponse.builder()
                .code(500)
                .message(e.getMessage())
                .build();
    }
}