package com.zzzfyrw.weather.service.impl.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzzfyrw.common.util.TokenUtil;
import com.zzzfyrw.repository.dao.UserTokenMapper;
import com.zzzfyrw.repository.entity.UserTokenEntity;
import com.zzzfyrw.weather.service.UserTokenService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserTokenServiceImpl extends ServiceImpl<UserTokenMapper, UserTokenEntity> implements UserTokenService {

    @Override
    public String insert(Long userId) {
        UserTokenEntity entity = new UserTokenEntity();
        entity.setUserId(userId);
        entity.setToken(TokenUtil.getToken()+userId);
        int count = this.baseMapper.insert(entity);
        if(count != 0)
            return entity.getToken();
        else
            return null;
    }

    @Override
    public Long queryUserIdByToken(String token) {
        UserTokenEntity entity = this.baseMapper
                .queryByTokenAndTime(token,LocalDateTime.now().minusDays(30));

        if(entity != null)
            return entity.getUserId();
        return null;
    }
}
