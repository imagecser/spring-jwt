package com.zsuun.springjwt.domain;

public class ErrorDetails {
    private String msg;

    public ErrorDetails(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
