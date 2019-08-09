package com.zzzfyrw.weather.config.aspect;

import com.zzzfyrw.business.user.UserTokenService;
import com.zzzfyrw.weather.config.ExceptionHandle.AuthException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;

@Aspect
@Component
public class AuthValidAdvice{

    @Resource
    public UserTokenService tokenService;

    @Pointcut("@annotation(com.zzzfyrw.common.annotation.AuthValid)")
    public void annotationPointCut(){

    }

    @Before("annotationPointCut()")
    public void doBefore(JoinPoint joinPoint) throws Exception,AuthException {
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(attributes == null)throw new AuthException();

        String token = attributes.getRequest().getHeader("token");
        Long userId = tokenService.queryUserIdByToken(token);
        if(userId == null) throw new AuthException();

    }

}
