package com.zzzfyrw.weather.api.login;

import com.zzzfyrw.business.user.LoginService;
import com.zzzfyrw.repository.entity.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("auth")
    public UserEntity auth(){
        return loginService.selectById(1L);
    }

//    @PostMapping("auth")
//    public Response<String> auth(){
//
//        Response<String> response;
//
//        return null;
//    }



}
