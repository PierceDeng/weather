package com.zzzfyrw.weather.impl.search;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzzfyrw.business.search.SearchService;
import com.zzzfyrw.repository.dao.SearchMapper;
import com.zzzfyrw.repository.dao.UserTokenMapper;
import com.zzzfyrw.repository.entity.SearchEntity;
import com.zzzfyrw.repository.entity.UserTokenEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchServiceImpl extends ServiceImpl<SearchMapper, SearchEntity> implements SearchService {

    @Autowired
    private UserTokenMapper tokenMapper;

    @Override
    public List<String> querySearchHistory(String token) throws Exception {

        UserTokenEntity userToken =
                tokenMapper.selectOne(new QueryWrapper<UserTokenEntity>()
                        .eq("token", token)
                        .ge("create_time", LocalDateTime.now().minusDays(30)));

        List<SearchEntity> searchList =
                this.baseMapper.selectList(new QueryWrapper<SearchEntity>()
                        .eq("user_id", userToken.getUserId())
                        .eq("is_delete",false));

        return searchList.stream().map(SearchEntity::getText).collect(Collectors.toList());
    }
}
