package com.zsuun.springjwt.domain.exception;

public class Jwt5xxControllerException extends JwtControllerException{
    Jwt5xxControllerException(String msg) {
        super(msg);
    }
}
