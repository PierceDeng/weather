package com.zzzfyrw.business.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzzfyrw.repository.entity.UserEntity;


public interface LoginService extends IService<UserEntity> {

    UserEntity selectById(Long id);

}
