package com.ysd.keepcar.utils;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by 阿禹 on 2017/12/26.
 */

public class OkhttpUtil {

    private static OkhttpUtil okhttpUtil;
    private OkHttpClient okHttpClient;

    private OkhttpUtil(){
        okHttpClient=new OkHttpClient();
    }

    public static OkhttpUtil getInstance(){
        if(okhttpUtil==null){
            synchronized (OkhttpUtil.class){
                if(okhttpUtil==null){
                    okhttpUtil=new OkhttpUtil();
                }
            }
        }
        return okhttpUtil;
    }

    public void post(String url, String data, Callback callback){
        Request request;
        if(data!=null){
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),data);
            request = new Request.Builder().post(requestBody).url(url).build();
        }else {
            request = new Request.Builder().url(url).build();
        }

        okHttpClient.newCall(request).enqueue(callback);
    }
}
