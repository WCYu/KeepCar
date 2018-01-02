package com.ysd.keepcar.view.shop.activity;

import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.app.BaseActivity;

import java.util.ArrayList;

public class ShopActivity extends BaseActivity implements View.OnClickListener {


    private ImageView image_background;
    private ImageView image_return;
    private ImageView image_icon;
    private TextView text_name;
    private TextView text_dizhi;
    private TextView text_km;
    private TextView text_pingfen;
    private TabLayout shop_tablayout;
    private ViewPager viewp_shop;

    @Override
    public int getInitId() {
        return R.layout.activity_shop;
    }

    @Override
    public void initView() {
        //浸入式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        image_background = findViewById(R.id.image_background);
        image_return = findViewById(R.id.image_return);
        image_icon = findViewById(R.id.image_icon);
        text_name = findViewById(R.id.text_name);
        text_dizhi = findViewById(R.id.text_dizhi);
        text_km = findViewById(R.id.text_km);
        text_pingfen = findViewById(R.id.text_pingfen);
        shop_tablayout = findViewById(R.id.shop_tablayout);
        viewp_shop = findViewById(R.id.viewp_shop);
        image_return.setOnClickListener(this);


        shop_tablayout.setupWithViewPager(viewp_shop);


        ArrayList<String> list = new ArrayList<>();
        list.add("精品");
        list.add("活动");
        list.add("新车");
        list.add("二手车");
        list.add("积分商场");


    }

    @Override
    public void initData() {

    }

    @Override
    public void initAdapter() {

    }

    @Override
    public void initLinstener() {

    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            //按键返回
            case R.id.image_return:
                finish();
                break;
        }
    }
}
