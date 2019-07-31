package com.zzzfyrw.weather.impl.login;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzzfyrw.business.user.LoginService;
import com.zzzfyrw.business.user.UserTokenService;
import com.zzzfyrw.common.wx.WxApiUtil;
import com.zzzfyrw.common.wx.entity.WxAuth;
import com.zzzfyrw.repository.dao.UserMapper;
import com.zzzfyrw.repository.entity.UserEntity;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
public class LoginServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements LoginService {

    @Autowired
    private UserTokenService tokenService;

    @Override
    public String auth(String code) {

        WxAuth auth = WxApiUtil.requestAuth(code);
        String token = null;
        if(auth.getErrcode() == 0){
            UserEntity user = this.baseMapper
                    .selectOne(new QueryWrapper<UserEntity>()
                    .eq("open_id",auth.getOpenid()));
            if(user == null){
                user = new UserEntity();
                user.setOpenId(auth.getOpenid());
                this.baseMapper.insert(user);
                log.debug("又是一个新用户！！！ userId: {}",user.getId());
            }else {
                log.debug("老用户登录 userId: {}",user.getId());
            }
            token = tokenService.insert(user.getId());
        }
        return token;
    }


}
