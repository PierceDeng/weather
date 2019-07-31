package com.zzzfyrw.common.response;

public enum ErrEnum {

    授权异常(10001,"授权异常，请检查网络设置或稍后重试");

    private String msg;
    private int code;

    ErrEnum(int code,String msg){
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
