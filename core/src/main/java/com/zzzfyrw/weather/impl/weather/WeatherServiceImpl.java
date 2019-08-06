package com.zzzfyrw.weather.impl.weather;

import com.zzzfyrw.business.weather.WeatherService;
import com.zzzfyrw.common.dto.WeatherDto;
import com.zzzfyrw.common.weather.WeatherApi;
import com.zzzfyrw.common.weather.entity.WeatherHours;
import com.zzzfyrw.common.weather.entity.WeatherIndex;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Override
    public WeatherDto getWeatherByCity(String city)throws Exception {

        WeatherDto dto = WeatherApi.getWeatherByCity(city);
        dto.getData().forEach(k ->{
            k.setTem(k.getTem().replace("℃",""));
            k.setTem1(k.getTem1().replace("℃",""));
            k.setTem2(k.getTem2().replace("℃",""));
            k.setWeek(k.getWeek().replace("星期","周"));
            List<WeatherIndex> indices = k.getIndex();
            indices.get(1).setLevel("适宜");
            indices.get(1).setTitle("运动指数");
            indices.get(2).setTitle("血糖指数");
            indices.get(5).setTitle("污染指数");
            k.setIndex(indices);
        });
        dto.getData().get(0).getHours().forEach(k ->{
            k.setTem(k.getTem().replace("℃",""));
        });

        return dto;
    }
}
