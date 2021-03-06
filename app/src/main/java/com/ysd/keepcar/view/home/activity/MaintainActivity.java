package com.ysd.keepcar.view.home.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ysd.keepcar.R;
import com.ysd.keepcar.app.BaseActivity;
import com.ysd.keepcar.custom.CustomTool;

//保养Activity
public class MaintainActivity extends BaseActivity {

    CustomTool customTool;
    @Override
    public int getInitId() {
        return R.layout.activity_maintain;
    }

    @Override
    public void initView() {
        customTool=findViewById(R.id.maintain_custom);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        customTool.setAppTitle(title);
    }

    @Override
    public void initAdapter() {

    }

    @Override
    public void initLinstener() {

    }

    @Override
    public void initToolBar() {
        customTool.initViewsVisible(true, false, true, false, false);
        customTool.setOnLeftButtonClickListener(new CustomTool.OnLeftButtonClickListener() {
            @Override
            public void onLeftButtonClick(View v) {
                finish();
            }
        });
    }
}
