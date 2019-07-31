package com.zzzfyrw.common.util.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class GsonUtil {

    private static Gson gson;

    static {
        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat("yyyy-MM-dd HH:mm:ss");
        builder.serializeNulls();
        gson = builder.create();
    }

    public static <T> T fromJsonToObject (String json,Class<T> type){
        return gson.fromJson(json,type);
    }

    public static <T> String fromObjectToJson(T Object){
        return gson.toJson(Object);
    }

}
