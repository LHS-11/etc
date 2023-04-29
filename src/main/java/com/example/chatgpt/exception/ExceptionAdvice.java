package com.example.chatgpt.exception;

import com.example.chatgpt.base.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity onValidationException(Exception exception){
        return new ResponseEntity<>(BaseResponse.onFailure(400, exception.getMessage(),null), null, HttpStatus.BAD_REQUEST);
    }

}