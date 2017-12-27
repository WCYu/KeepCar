package com.ysd.keepcar.view;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.ysd.keepcar.R;
import com.ysd.keepcar.app.BaseActivity;

public class MainActivity extends BaseActivity {

    ViewPager viewPager;
    Button button;

    @Override
    public int getInitId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        viewPager=findViewById(R.id.welcome_pager);
        button=findViewById(R.id.experience);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initAdapter() {

    }

    @Override
    public void initLinstener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initToolBar() {

    }
}
