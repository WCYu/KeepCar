package com.ysd.keepcar.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by 阿禹 on 2017/12/26.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getInitId());
        initView();
        initData();
        initLinstener();
        initToolBar();
        AppService.baseActivity=this;
    }

    public abstract int getInitId();

    public abstract void initView();

    public abstract void initData();

    public abstract void initAdapter();

    public abstract void initLinstener();

    public abstract void initToolBar();
}
