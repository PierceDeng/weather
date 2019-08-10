package com.zzzfyrw.weather.api.search;

import com.zzzfyrw.business.search.SearchService;
import com.zzzfyrw.common.annotation.AuthValid;
import com.zzzfyrw.common.response.Response;
import com.zzzfyrw.common.response.ResponseBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("search")
public class SearchController {

    @Resource
    private SearchService searchService;

    @GetMapping("history")
    @AuthValid
    public Response queryHistory(HttpServletRequest request)throws Exception{
        return ResponseBuilder
                .ok(searchService
                        .querySearchHistory(request
                                .getHeader("token")));
    }

    @PostMapping("clear")
    @AuthValid
    public Response clearHistory(HttpServletRequest request)throws Exception{
        return ResponseBuilder.ok(searchService
                .clearSearchHistory(request
                        .getHeader("token")));
    }

}
