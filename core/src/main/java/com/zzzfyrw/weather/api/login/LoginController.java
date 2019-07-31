package com.zzzfyrw.weather.api.login;

import com.zzzfyrw.business.user.LoginService;
import com.zzzfyrw.common.response.ErrEnum;
import com.zzzfyrw.common.response.Response;
import com.zzzfyrw.common.response.ResponseBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("auth")
    public Response<String> auth(String code){
        String result = loginService.auth(code);
        if(result == null)
            return ResponseBuilder.fail(ErrEnum.授权异常.getMsg(),ErrEnum.授权异常.getCode());
        else
            return ResponseBuilder.ok(result);
    }

//    @PostMapping("auth")
//    public Response<String> auth(){
//
//        Response<String> response;
//
//        return null;
//    }



}
