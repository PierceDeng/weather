package com.zzzfyrw.weather.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzzfyrw.repository.entity.UserEntity;


public interface LoginService extends IService<UserEntity> {

    String auth(String code);


}
