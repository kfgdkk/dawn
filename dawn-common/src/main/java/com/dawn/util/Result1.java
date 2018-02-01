package com.dawn.util;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/12/4 0004.
 */
public class Result1 implements Serializable {
    private boolean success;
    private  String message;

    public Result1(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Result1() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
