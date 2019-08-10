package com.zzzfyrw.business.search;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzzfyrw.repository.entity.SearchEntity;

import java.util.List;

public interface SearchService extends IService<SearchEntity> {

    List<String> querySearchHistory(String token)throws Exception;

    String clearSearchHistory(String token)throws Exception;


}
