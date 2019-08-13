package com.zzzfyrw.weather.config.ExceptionHandle;

import com.zzzfyrw.common.response.ErrEnum;
import com.zzzfyrw.common.response.Response;
import com.zzzfyrw.common.response.ResponseBuilder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Response exHandler(Exception e){
        e.printStackTrace();
        return ResponseBuilder.fail(ErrEnum.未知异常.getMsg(),ErrEnum.未知异常.getCode());
    }

    @ExceptionHandler(AuthException.class)
    public Response authHandler(Exception e){
        e.printStackTrace();
        return ResponseBuilder.fail(ErrEnum.TOKEN.getMsg(),ErrEnum.TOKEN.getCode());
    }

}
