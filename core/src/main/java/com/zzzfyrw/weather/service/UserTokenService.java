package com.zzzfyrw.weather.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzzfyrw.repository.entity.UserTokenEntity;

public interface UserTokenService extends IService<UserTokenEntity> {

    String insert(Long userId);

    Long queryUserIdByToken(String token);

}
