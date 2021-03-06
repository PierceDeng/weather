package com.zzzfyrw.weather.service.impl.login;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzzfyrw.common.util.wx.WxApiUtil;
import com.zzzfyrw.common.util.wx.entity.WxAuth;
import com.zzzfyrw.repository.dao.UserMapper;
import com.zzzfyrw.repository.entity.UserEntity;
import com.zzzfyrw.weather.service.LoginService;
import com.zzzfyrw.weather.service.UserTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                log.info("又是一个新用户！！！ userId: {}",user.getId());
            }else {
                log.info("老用户登录 userId: {}",user.getId());
            }
            token = tokenService.insert(user.getId());
        }
        return token;
    }


}
