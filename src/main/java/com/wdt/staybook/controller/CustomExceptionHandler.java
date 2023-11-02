package com.wdt.staybook.controller;

import com.wdt.staybook.exception.UserAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<String> handleUserExistException(Exception e, WebRequest request) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
