package com.zzzfyrw.weather.config.ExceptionHandle;

import com.zzzfyrw.common.response.ErrEnum;
import com.zzzfyrw.common.response.Response;
import com.zzzfyrw.common.response.ResponseBuilder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AllExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Response handler(Exception e){
        e.printStackTrace();
        return ResponseBuilder.fail(ErrEnum.未知异常.getMsg(),ErrEnum.未知异常.getCode());
    }


}
