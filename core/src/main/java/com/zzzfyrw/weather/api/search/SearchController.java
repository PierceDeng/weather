package com.zzzfyrw.weather.api.search;

import com.zzzfyrw.common.annotation.AuthValid;
import com.zzzfyrw.common.response.Response;
import com.zzzfyrw.common.response.ResponseBuilder;
import com.zzzfyrw.weather.service.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("search")
@Api(value = "搜索Controller",tags = {"切换城市操作"})
public class SearchController {

    @Resource
    private SearchService searchService;

    @GetMapping("history")
    @AuthValid
    @ApiOperation(value = "查询历史记录")
    public Response queryHistory(HttpServletRequest request)throws Exception{
        return ResponseBuilder
                .ok(searchService
                        .querySearchHistory(request
                                .getHeader("token")));
    }

    @PostMapping("clear")
    @AuthValid
    @ApiOperation(value = "清空历史记录")
    public Response clearHistory(HttpServletRequest request)throws Exception{
        return ResponseBuilder.ok(searchService
                .clearSearchHistory(request
                        .getHeader("token")));
    }

}
