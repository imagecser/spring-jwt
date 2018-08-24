package com.zsuun.springjwt.domain.exception;

public class JwtControllerException extends RuntimeException {
    JwtControllerException() {
        super();
    }

    JwtControllerException(String message) {
        super(message);
    }
}
