package com.ysd.keepcar.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * 相机相册工具类
 * Created by asus on 2017/12/27.
 */

public class AppConfig {

    public static final String APP_PATH = Environment
            .getExternalStorageDirectory()
            + File.separator
            + "pandatv"
            + File.separator;

    /**
     * 默认存放图片的路径
     */
    public final static String DEFAULT_IMAGE_PATH = APP_PATH
            + "camera"
            + File.separator;

    /**
     * 默认存放文件的路径
     */
    public final static String DEFAULT_CACHE_PATH = APP_PATH
            + "cache"
            + File.separator;


    private Context mContext;
    private static AppConfig appConfig;

    private AppConfig() {
    }

    public static AppConfig getAppConfig() {
        if (appConfig == null) {
            appConfig = new AppConfig();
        }
        return appConfig;
    }

    public void init(Context context) {
        File file = new File(DEFAULT_IMAGE_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }

        file = new File(DEFAULT_CACHE_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }

//        DBInterface.getInstance().initDbHelp(context);
//
//        //设置okhttp缓存
//        File cacheFolder = context.getCacheDir();
//        Cache cache = new Cache(cacheFolder, 50 * 1024 * 1024); //100Mb
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .cache(cache)
////                .addInterceptor(InterceptorFactory.getLoggingInterceptor())
//                .build();
//        Network.getInstance().init(okHttpClient);

        mContext = context.getApplicationContext();

    }
}
