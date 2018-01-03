package com.ysd.keepcar.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Banner工具类
 * Created by asus on 2018/1/3.
 * 写这段代码的时候，只有上帝和我知道它是干嘛的
 * 现在只有上帝知道0.0
 */

public class GlideImage extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context.getApplicationContext()).load((Integer) path).into(imageView);
    }

}
