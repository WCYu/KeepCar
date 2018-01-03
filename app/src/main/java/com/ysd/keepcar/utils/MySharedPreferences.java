package com.ysd.keepcar.utils;

import android.content.SharedPreferences;

import com.ysd.keepcar.app.AppService;

/**
 * Created by 阿禹 on 2018/1/2.
 */

public class MySharedPreferences {
    private static MySharedPreferences mySharedPreferences;
    private SharedPreferences sharedPreferences;

    private MySharedPreferences(){
        sharedPreferences= AppService.baseActivity.getSharedPreferences("KeepCar",0);
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
    public void setUserId(String usetId){
        sharedPreferences.edit().putString("userId",usetId).commit();
    }

    public String getUserId(){
        String userId = sharedPreferences.getString("userId",null);
        return userId;
    }

    //城市Id
    public void setCityId(int usetId){
        sharedPreferences.edit().putInt("cityId",usetId).commit();
    }

    public int getCityId(){
        int cityId = sharedPreferences.getInt("cityId", 0);
        return cityId;
    }
}
