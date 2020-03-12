package com.zzzfyrw.weather.api.login;

import com.zzzfyrw.common.response.ErrEnum;
import com.zzzfyrw.common.response.Response;
import com.zzzfyrw.common.response.ResponseBuilder;
import com.zzzfyrw.weather.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(value = "登录Controller",tags = {"登录操作"})
@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @ApiOperation(value = "请求微信获取openid入库")
    @ApiImplicitParam(name = "code",value = "微信code码",required = true)
    @GetMapping("auth")
    public Response<String> auth(String code)throws Exception{
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
