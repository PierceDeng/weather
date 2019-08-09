package com.zzzfyrw.common.response;

public enum ErrEnum {

    授权异常(10001,"请检查网络设置或稍后重试"),
    TOKEN(10002,"请重新打开小程序"),

    未知城市名(30001,"未检索到城市名称"),

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
