package com.zzzfyrw.common.wx;

import com.zzzfyrw.common.util.gson.GsonUtil;
import com.zzzfyrw.common.util.okHttp.OkHttpUtil;
import com.zzzfyrw.common.wx.entity.WxAuth;

import java.util.SortedMap;
import java.util.TreeMap;

public final class WxApiUtil {

    private WxApiUtil(){}

    public static WxAuth requestAuth(String code){
        SortedMap<String,String> params = new TreeMap<>();
        params.put("appid",WxConfig.APP_ID);
        params.put("secret",WxConfig.APP_KEY);
        params.put("js_code",code);
        params.put("grant_type","authorization_code");
        String json = OkHttpUtil.get(WxConfig.AUTH,params);
        return GsonUtil.fromJsonToObject(json,WxAuth.class);
    }

}
