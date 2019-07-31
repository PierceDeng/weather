package com.zzzfyrw.common.response;

public class ResponseBuilder {

    private static final String DEFAULT_MESSAGE = "SUCCESS";

    public static <T> Response<T> ok(T data){
        return okAndMessage(data,DEFAULT_MESSAGE);
    }

    public static <T> Response<T> okAndMessage(T data,String message){
        Response<T> response = new Response<>();
        response.setData(data);
        response.setMessage(message);
        return response;
    }

    public static <T> Response<T> fail(String message,int code){
        Response<T> response = new Response<>();
        response.setMessage(message);
        response.setCode(code);
        response.setData(null);
        return response;
    }


}
