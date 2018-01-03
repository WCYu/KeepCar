package com.ysd.keepcar.app;

import android.content.SharedPreferences;

import com.ysd.keepcar.utils.OkhttpUtil;

import okhttp3.OkHttpClient;

/**
 * Created by 阿禹 on 2018/1/2.
 */

public class MySharedPreferences {
    private static MySharedPreferences mySharedPreferences;
    private SharedPreferences sharedPreferences;

    private MySharedPreferences(){
        sharedPreferences=AppService.baseActivity.getSharedPreferences("KeepCar",0);
    }

    public static MySharedPreferences getInstance(){
        if(mySharedPreferences==null){
            synchronized (MySharedPreferences.class){
                if(mySharedPreferences==null){
                    mySharedPreferences=new MySharedPreferences();
                }
            }
        }
        return mySharedPreferences;
    }
    //用户Id
    public void setUserId(int usetId){
        sharedPreferences.edit().putInt("userId",usetId);
    }

    public int getUserId(){
        int userId = sharedPreferences.getInt("userId", 0);
        return userId;
    }

    //城市Id
    public void setCityId(int usetId){
        sharedPreferences.edit().putInt("cityId",usetId);
    }

    public int getCityId(){
        int cityId = sharedPreferences.getInt("cityId", 0);
        return cityId;
    }
}
