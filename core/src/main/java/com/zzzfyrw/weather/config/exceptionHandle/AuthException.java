package com.zzzfyrw.weather.config.exceptionHandle;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthException extends RuntimeException {

    private final String message = "token错误或失效";

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void printStackTrace() {
        log.info("AuthException : {}",message);
//        super.printStackTrace();
    }
}
