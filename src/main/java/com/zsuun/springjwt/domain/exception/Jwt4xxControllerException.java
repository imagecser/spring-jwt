package com.zsuun.springjwt.domain.exception;

public class Jwt4xxControllerException extends JwtControllerException {
    public Jwt4xxControllerException(String msg) {
        super(msg);
    }
}
