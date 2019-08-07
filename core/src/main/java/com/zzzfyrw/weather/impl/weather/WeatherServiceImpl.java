package com.zzzfyrw.weather.impl.weather;

import com.zzzfyrw.business.weather.WeatherService;
import com.zzzfyrw.common.dto.WeatherDto;
import com.zzzfyrw.common.weather.WeatherApi;
import com.zzzfyrw.common.weather.entity.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        List<Integer> collect = dto.getData()
                .get(0)
                .getHours()
                .stream()
                .map(WeatherHours::getTem)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        if(collect.size()>=6){
            collect = collect.subList(0,6);
        }else {
            collect = collect.subList(0,collect.size());
        }
        dto.setWeekTems(collect);


        String[] categories = {"8:00", "11:00", "14:00", "17:00", "20:00", "23:00"};
        List<Serie> series = new ArrayList<>();
        Serie serie = new Serie();
        serie.setColor("#48D1CC");
        serie.setTextColor("#000000");
        serie.setName("时间温度");
        serie.setTextSize(10);
        serie.setData(collect);
        series.add(serie);

        ChartData chartData = new ChartData();
        chartData.setCategories(categories);
        chartData.setModelSerie(series);
        dto.setChartData(chartData);
        return dto;
    }
}
