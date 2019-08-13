package com.zzzfyrw.repository.dao;

import com.zzzfyrw.repository.entity.UserTokenEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dpz
 * @since 2019-07-31
 */
public interface UserTokenMapper extends BaseMapper<UserTokenEntity> {

    UserTokenEntity queryByTokenAndTime(@Param("token") String token, @Param("time")LocalDateTime time);

}
