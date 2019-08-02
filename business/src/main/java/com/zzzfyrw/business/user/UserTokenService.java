package com.zzzfyrw.business.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzzfyrw.repository.entity.UserTokenEntity;

public interface UserTokenService extends IService<UserTokenEntity> {

    String insert(Long userId)throws Exception;

    Long queryUserIdByToken(String token)throws Exception;

}
