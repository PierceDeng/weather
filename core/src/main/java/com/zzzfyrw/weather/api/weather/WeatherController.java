package com.zzzfyrw.weather.api.weather;

import com.zzzfyrw.business.weather.WeatherService;
import com.zzzfyrw.common.dto.WeatherDto;
import com.zzzfyrw.common.response.Response;
import com.zzzfyrw.common.response.ResponseBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("weather")
@Api(value = "天气Controller",tags = {"天气查询操作"})
public class WeatherController {

    @Resource
    private WeatherService weatherService;

    @GetMapping("getWeather")
    @ApiOperation(value = "请求每周天气")
    @ApiImplicitParam(name = "city",value = "city名字，不要带市",required = true)
    public Response<WeatherDto> getWeather(String city)throws Exception{
        return ResponseBuilder.ok(weatherService.getWeatherByCity(city));
    }

}
