package com.zzzfyrw.weather.service;

import com.zzzfyrw.common.dto.WeatherDto;

public interface WeatherService {


    WeatherDto getWeatherByCity(String city);

    WeatherDto authWeatherByCity(String city, Integer type, String token);


}
