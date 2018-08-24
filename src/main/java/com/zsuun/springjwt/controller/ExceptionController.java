package com.zsuun.springjwt.controller;

import com.zsuun.springjwt.domain.ErrorDetails;
import com.zsuun.springjwt.domain.exception.Jwt4xxControllerException;
import com.zsuun.springjwt.domain.exception.Jwt5xxControllerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(Jwt4xxControllerException.class)
    public ResponseEntity<ErrorDetails> handle4xxException(Jwt4xxControllerException ex) {
        return new ResponseEntity<>(new ErrorDetails(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Jwt5xxControllerException.class)
    public ResponseEntity<ErrorDetails> handle5xxException(Jwt5xxControllerException ex) {
        return new ResponseEntity<>(new ErrorDetails(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
