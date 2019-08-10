package com.zzzfyrw.common.util.wx;

import java.util.ResourceBundle;

public final class WxConfig {

    protected static final String AUTH;
    protected static final String APP_ID;
    protected static final String APP_KEY;

    static{
        ResourceBundle bundle = ResourceBundle.getBundle("wxApi");
        AUTH = bundle.getString("wx.auth");
        APP_ID = bundle.getString("wx.appid");
        APP_KEY = bundle.getString("wx.appkey");
        System.gc();
    }

    private WxConfig() {
    }
}
