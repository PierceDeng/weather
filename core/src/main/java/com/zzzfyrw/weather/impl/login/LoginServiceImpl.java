package com.zzzfyrw.weather.impl.login;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzzfyrw.business.user.LoginService;
import com.zzzfyrw.repository.dao.UserMapper;
import com.zzzfyrw.repository.entity.UserEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dpz
 * @since 2019-07-30
 */
@Service
public class LoginServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements LoginService {

    @Override
    public UserEntity selectById(Long id) {
        return this.baseMapper.selectById(id);
    }
}
