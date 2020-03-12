package com.zzzfyrw.weather.config.exceptionHandle;

import com.zzzfyrw.common.response.ErrEnum;
import com.zzzfyrw.common.response.Response;
import com.zzzfyrw.common.response.ResponseBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Response exHandler(Exception e){
        log.info(e.getMessage());
        return ResponseBuilder.fail(ErrEnum.未知异常.getMsg(),ErrEnum.未知异常.getCode());
    }

    @ExceptionHandler(AuthException.class)
    public Response authHandler(Exception e){
        log.info(e.getMessage());
        return ResponseBuilder.fail(ErrEnum.TOKEN.getMsg(),ErrEnum.TOKEN.getCode());
    }

}
