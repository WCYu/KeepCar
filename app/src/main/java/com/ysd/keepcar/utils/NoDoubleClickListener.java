package com.ysd.keepcar.utils;

import android.view.View;

import java.util.Calendar;

/**.
 * 防止过快点击造成多次事件执行（防止按钮重复点击）
 * Created by asus on 2017/12/28.
 * 写这段代码的时候，只有上帝和我知道它是干嘛的
 * 现在只有上帝知道0.0
 */

public abstract class NoDoubleClickListener implements View.OnClickListener {

    //两次点击按钮之间的点击间隔不能少于2000毫秒
    public static final int MIN_CLICK_DELAY_TIME = 2000;
    private long lastClickTime = 0;

    @Override
    public void onClick(View v) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            onNoDoubleClick(v);
        }
    }

    protected abstract void onNoDoubleClick(View v);
}
