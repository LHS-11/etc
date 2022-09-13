package com.cos.person.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

//Exception 을 낚아채기
@RestController
@ControllerAdvice // 모든 exception 을 관리 가능
public class MyExceptionHandler {

    @ExceptionHandler(value = IllegalArgumentException.class)
    public String 요청잘못(IllegalArgumentException e) {
        return e.getMessage();
    }
}
