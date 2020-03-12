/**
 * FileName: OkHttpUtil
 * Author:   dpz
 * Date:     2018/12/10 22:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * dpz         2018/12/10 22:56        1.0               新建类
 */
package com.zzzfyrw.common.util.okHttp;


import okhttp3.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 〈〉
 * @author dpz
 * created 2018/12/10 22:56
 */
public class OkHttpUtil {

    private static volatile OkHttpClient okHttp;

    private OkHttpUtil(){}

    private static OkHttpClient getInstance(){
        if(okHttp == null){
            synchronized (OkHttpUtil.class){
                if(okHttp == null){
                    okHttp = new OkHttpClient();
                    OkHttpClient.Builder builder = okHttp.newBuilder();
                    builder.connectTimeout(10, TimeUnit.SECONDS);
                    builder.readTimeout(10,TimeUnit.SECONDS);
                    builder.writeTimeout(30,TimeUnit.SECONDS);
                    builder.build();
                }
            }
        }
        return okHttp;
    }

    public static String get(String url){
        Request request = buildRequest(url, HttpMethodEnum.GET,null,null,null);
        return doRequest(request);
    }


    public static String get(String url,Map<String,String> params){
        Request request = buildRequest(url, HttpMethodEnum.GET,params,null,null);
        return doRequest(request);
    }

    public static String get(String url,Map<String,String> params,Map<String,String> headers){
        Request request = buildRequest(url, HttpMethodEnum.GET,params,null,headers);
        return doRequest(request);
    }

    public static String post(String url){
        Request request = buildRequest(url, HttpMethodEnum.POST,null,null,null);
        return doRequest(request);
    }

    public static String post(String url,String json){
        Request request = buildRequest(url, HttpMethodEnum.POST,null,json,null);
        return doRequest(request);
    }

    public static String post(String url,String json,Map<String,String> headers){
        Request request = buildRequest(url, HttpMethodEnum.POST,null,json,headers);
        return doRequest(request);
    }

    public static String post(String url,Map<String,String> params){
        Request request = buildRequest(url, HttpMethodEnum.POST,params,null,null);
        return doRequest(request);
    }

    public static String post(String url,Map<String,String> params,Map<String,String> headers){
        Request request = buildRequest(url, HttpMethodEnum.POST,params,null,headers);
        return doRequest(request);
    }


    private static String doRequest(Request request){
        okHttp = getInstance();
        Response response;
        String result= null;
        try {
            response = okHttp.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static Request buildRequest(String url, HttpMethodEnum methodEnum, Map<String,String> params, String json, Map<String,String> headerMap){
        Request.Builder builder = new Request.Builder().url(url);
        switch (methodEnum){
            case GET:
                builder.get();
                builderUrl(params,builder,url);
                setHeaders(headerMap, builder);
                break;
            case POST:
                RequestBody body = null;
                if(json != null){
                    body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),json);
                }else if(params != null){
                    body = builderFormData(params);
                }
                setHeaders(headerMap, builder);
                builder.post(body);
                break;
        }
        return builder.build();
    }

    private static void setHeaders(Map<String, String> headerMap, Request.Builder builder) {
        if (headerMap != null) {
            Headers.Builder headers = new Headers.Builder();
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                headers.add(entry.getKey(), entry.getValue());
            }
            builder.headers(headers.build());
        }
    }

    private static RequestBody builderFormData(Map<String,String> map){
        FormBody.Builder formBody = new FormBody.Builder();
        if(map != null){
            for (Map.Entry<String, String> entry : map.entrySet()) {
                formBody.add(entry.getKey(),entry.getValue());
            }
        }
        return formBody.build();
    }

    private static void builderUrl(Map<String,String> map,Request.Builder builder,String url){
        if(map != null){
            boolean first = true;
            StringBuilder buffer = new StringBuilder();
            if(!url.contains("?")){
                buffer.append("?");
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if(!first)
                    buffer.append("&");
                buffer.append(entry.getKey());
                buffer.append("=");
                buffer.append(entry.getValue());
                first = false;
            }
            builder.url(url+buffer.toString());
        }
    }

}
