package com.zzzfyrw.common.util.wx;

import java.util.ResourceBundle;

public final class WxConfig {

    static final String AUTH;
    static final String APP_ID;
    static final String APP_KEY;

    static{
        ResourceBundle bundle = ResourceBundle.getBundle("wxApi");
        AUTH = bundle.getString("wx.auth");
        APP_ID = bundle.getString("wx.appid");
        APP_KEY = bundle.getString("wx.appkey");
    }

    private WxConfig() {
    }
}
