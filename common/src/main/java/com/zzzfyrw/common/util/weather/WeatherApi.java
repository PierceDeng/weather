package com.zzzfyrw.common.util.weather;

import com.zzzfyrw.common.dto.WeatherDto;
import com.zzzfyrw.common.util.UnicodeUtil;
import com.zzzfyrw.common.util.gson.GsonUtil;
import com.zzzfyrw.common.util.okHttp.OkHttpUtil;

import java.util.SortedMap;
import java.util.TreeMap;

public final class WeatherApi {

    public static WeatherDto getWeatherByCity(String cityName){
        String url = "https://www.tianqiapi.com/api";
        SortedMap<String,String> params = new TreeMap<>();
        params.put("appid","58514123");
        params.put("appsecret","nPqMKBC3");
        params.put("version","v1");
        params.put("city",cityName);
        String result = OkHttpUtil.get(url, params);
        result = UnicodeUtil.unicodeToString(result);
        return GsonUtil.fromJsonToObject(result, WeatherDto.class);
    }

    public static void main(String[] args) {
//        String url = "https://www.tianqiapi.com/api/";
//        SortedMap<String,String> params = new TreeMap<>();
//        params.put("version","v1");
//        params.put("city","长沙");
//        String result = UnicodeUtil.unicodeToString(OkHttpUtil.get(url, params));
//        WeatherDto dto = GsonUtil.fromJsonToObject(result, WeatherDto.class);
//        String tem = dto.getData().get(0).getTem();
//        dto.getData().forEach(k ->{
//            k.setTem(k.getTem().replace("℃",""));
//            k.setTem1(k.getTem1().replace("℃",""));
//            k.setTem2(k.getTem2().replace("℃",""));
//            k.setWeek(k.getWeek().replace("星期","周"));
//            List<WeatherIndex> indices = k.getIndex();
//            indices.get(1).setLevel("适宜");
//            indices.get(1).setTitle("运动指数");
//            indices.get(2).setTitle("血糖指数");
//            indices.get(5).setTitle("污染指数");
//            k.setIndex(indices);
//        });
//        List<WeatherHours> hoursList = dto.getData().get(0).getHours();
//        dto.getData().get(0).setHours(hoursList.subList(0,6));
//        dto.getData().get(0).getHours().forEach(k ->{
//            k.setTem(k.getTem().replace("℃",""));
//        });
//
//
//        System.out.println(dto);
//
//        tem = tem.replaceAll("℃","");

    }


}
