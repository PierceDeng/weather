package com.zzzfyrw.business.weather;

import com.zzzfyrw.common.dto.WeatherDto;

public interface WeatherService {


    WeatherDto getWeatherByCity(String city)throws Exception;

    WeatherDto authWeatherByCity(String city,Integer type,String token)throws Exception;


}
