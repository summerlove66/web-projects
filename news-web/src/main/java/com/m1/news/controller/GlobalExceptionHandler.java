package com.m1.news.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public String errorReq(HttpServletResponse response ,Exception exception) {
        exception.printStackTrace();
        return "YOU GET A ERROR";
    }


}
