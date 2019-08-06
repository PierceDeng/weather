package com.zzzfyrw.common.weather.entity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Weather {

    private String day;
    private String date;
    private String week;
    private String wea;
    private String wea_img;
    private String air;
    private String humidity;
    private String air_level;
    private String air_tips;
    private String tem1;
    private String tem2;
    private String tem;
    private String[] win;
    private String win_speed;
    private List<WeatherHours> hours;
    private List<WeatherIndex> index;

    public Weather() {
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getWea() {
        return wea;
    }

    public void setWea(String wea) {
        this.wea = wea;
    }

    public String getWea_img() {
        return wea_img;
    }

    public void setWea_img(String wea_img) {
        this.wea_img = wea_img;
    }

    public String getAir() {
        return air;
    }

    public void setAir(String air) {
        this.air = air;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getAir_level() {
        return air_level;
    }

    public void setAir_level(String air_level) {
        this.air_level = air_level;
    }

    public String getAir_tips() {
        return air_tips;
    }

    public void setAir_tips(String air_tips) {
        this.air_tips = air_tips;
    }

    public String getTem1() {
        return tem1;
    }

    public void setTem1(String tem1) {
        this.tem1 = tem1;
    }

    public String getTem2() {
        return tem2;
    }

    public void setTem2(String tem2) {
        this.tem2 = tem2;
    }

    public String getTem() {
        return tem;
    }

    public void setTem(String tem) {
        this.tem = tem;
    }

    public String[] getWin() {
        return win;
    }

    public void setWin(String[] win) {
        this.win = win;
    }

    public String getWin_speed() {
        return win_speed;
    }

    public void setWin_speed(String win_speed) {
        this.win_speed = win_speed;
    }

    public List<WeatherHours> getHours() {
        return hours;
    }

    public void setHours(List<WeatherHours> hours) {
        this.hours = hours;
    }

    public List<WeatherIndex> getIndex() {
        return index;
    }

    public void setIndex(List<WeatherIndex> index) {
        this.index = index;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "day='" + day + '\'' +
                ", date='" + date + '\'' +
                ", week='" + week + '\'' +
                ", wea='" + wea + '\'' +
                ", wea_img='" + wea_img + '\'' +
                ", air='" + air + '\'' +
                ", humidity='" + humidity + '\'' +
                ", air_level='" + air_level + '\'' +
                ", air_tips='" + air_tips + '\'' +
                ", tem1='" + tem1 + '\'' +
                ", tem2='" + tem2 + '\'' +
                ", tem='" + tem + '\'' +
                ", win=" + Arrays.toString(win) +
                ", win_speed='" + win_speed + '\'' +
                ", hours=" + hours +
                ", indexs=" + index +
                '}';
    }
}
