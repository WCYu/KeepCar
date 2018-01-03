package com.ysd.keepcar.app;

import android.app.Application;

import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import java.security.PublicKey;

/**
 * Created by 阿禹 on 2017/12/26.
 */

public class AppService extends Application {
    public static BaseActivity baseActivity;
    @Override
    public void onCreate() {
        super.onCreate();
        ZXingLibrary.initDisplayOpinion(this);
    }
}
