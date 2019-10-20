package io.kanonair.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyException {

    @ExceptionHandler
    public String error1(Exception e) {
        return "error";
    }

}
