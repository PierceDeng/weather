package com.zzzfyrw.common.dto;

import com.zzzfyrw.common.weather.entity.ChartData;
import com.zzzfyrw.common.weather.entity.Weather;

import java.util.Arrays;
import java.util.List;

public class WeatherDto {

    private String update_time;
    private String city;
    private List<Weather> data;
    private List<Integer> weekTems;
    private ChartData chartData;

    public ChartData getChartData() {
        return chartData;
    }

    public void setChartData(ChartData chartData) {
        this.chartData = chartData;
    }

    public List<Integer>  getWeekTems() {
        return weekTems;
    }

    public void setWeekTems(List<Integer>  weekTems) {
        this.weekTems = weekTems;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Weather> getData() {
        return data;
    }

    public void setData(List<Weather> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WeatherDto{" +
                "update_time='" + update_time + '\'' +
                ", city='" + city + '\'' +
                ", data=" + data +
                ", weekTems=" + weekTems +
                '}';
    }
}
