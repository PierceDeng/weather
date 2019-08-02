package com.zzzfyrw.common.response;

public enum ErrEnum {

    授权异常(10001,"请检查网络设置或稍后重试"),



    未知异常(40001,"系统错误，请联系客服");

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
