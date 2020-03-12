package com.zzzfyrw.weather.api.weather;

import com.zzzfyrw.common.annotation.AuthValid;
import com.zzzfyrw.common.dto.SearchCityParam;
import com.zzzfyrw.common.dto.WeatherDto;
import com.zzzfyrw.common.response.ErrEnum;
import com.zzzfyrw.common.response.Response;
import com.zzzfyrw.common.response.ResponseBuilder;
import com.zzzfyrw.weather.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("weather")
@Api(value = "天气Controller",tags = {"天气查询操作"})
public class WeatherController {

    @Resource
    private WeatherService weatherService;

    @GetMapping("getWeather")
    @ApiOperation(value = "请求每周天气")
    @ApiImplicitParam(name = "city",value = "city名字，不要带市",required = true)
    public Response<WeatherDto> getWeather(String city){
        return ResponseBuilder.ok(weatherService.getWeatherByCity(city));
    }

    @PostMapping("authWeather")
    @AuthValid
    @ApiOperation(value = "请求每周天气")
    public Response<WeatherDto> authWeather(@RequestBody SearchCityParam param,
                                               HttpServletRequest request){
        String token = request.getHeader("token");
        WeatherDto dto = weatherService.authWeatherByCity(param.getCity(), param.getType(), token);
        if(dto == null)
            return ResponseBuilder.fail(ErrEnum.未知城市名.getMsg(),ErrEnum.未知城市名.getCode());
        return ResponseBuilder.ok(dto);
    }

}
