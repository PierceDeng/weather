package com.zzzfyrw.common.response;

public final class Response<T> {
    private String message;
    private int code;
    private T data;

    Response() {
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(T data) {
        this.data = data;
    }


}
