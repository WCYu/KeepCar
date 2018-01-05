package com.ysd.keepcar.app;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;


/**
 * Created by 阿禹 on 2017/12/26.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getInitId());
        initView();
        initData();
        initLinstener();
        initToolBar();
        initWindow();
        initAdapter();
        AppService.baseActivity = this;
    }

    public abstract int getInitId();

    public abstract void initView();

    public abstract void initData();

    public abstract void initAdapter();

    public abstract void initLinstener();

    public abstract void initToolBar();

    private void initWindow() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    public void progress() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
    }
}
