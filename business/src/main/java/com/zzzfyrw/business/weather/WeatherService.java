package com.zzzfyrw.business.weather;

import com.zzzfyrw.common.dto.WeatherDto;

public interface WeatherService {


    WeatherDto getWeatherByCity(String city)throws Exception;

}
