package com.zzzfyrw.common.util.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

public final class GsonUtil {

    private GsonUtil(){}

    private static GsonBuilder builder;

    static {
        builder = new GsonBuilder();
        builder.setDateFormat("yyyy-MM-dd HH:mm:ss");
        builder.serializeNulls();
    }

    public static <T> T fromJsonToObject (String json, Class<T> type){
        Gson gson = builder.create();
        return gson.fromJson(json,type);
    }

    public static <T> T fromJsonToType (String json, Type type){
        Gson gson = builder.create();
        return gson.fromJson(json,type);
    }

    public static <T> String fromObjectToJson(T Object){
        Gson gson = builder.create();
        return gson.toJson(Object);
    }
}
