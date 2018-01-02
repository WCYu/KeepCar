package com.ysd.keepcar.view.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ysd.keepcar.R;
import com.ysd.keepcar.app.BaseActivity;
import com.ysd.keepcar.custom.CustomTool;

//展厅Activity
public class ExhibitionActivity extends BaseActivity {

    CustomTool customTool;
    private RadioButton exhibition_xin_che;
    private RadioButton exhibition_er_shou;
    private RadioGroup exhibition_group;
    private FrameLayout exhibition_frame;
    private FragmentManager supportFragmentManager;
    private FragmentTransaction transaction;

    @Override
    public int getInitId() {
        return R.layout.activity_exhibition;
    }

    @Override
    public void initView() {
        customTool = findViewById(R.id.exhibition_custom);
        exhibition_xin_che = findViewById(R.id.exhibition_xin_che);
        exhibition_er_shou = findViewById(R.id.exhibition_er_shou);
        exhibition_group = findViewById(R.id.exhibition_group);
        exhibition_frame = findViewById(R.id.exhibition_frame);
        supportFragmentManager = getSupportFragmentManager();
        transaction = supportFragmentManager.beginTransaction();
        transaction.commit();
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
        exhibition_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.exhibition_xin_che:

                        break;
                    case R.id.exhibition_er_shou:

                        break;
                }
            }
        });
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
