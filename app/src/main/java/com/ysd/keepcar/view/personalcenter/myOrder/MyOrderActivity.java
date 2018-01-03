package com.ysd.keepcar.view.personalcenter.myOrder;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.app.BaseActivity;
import com.ysd.keepcar.custom.CustomTool;

import java.util.ArrayList;
import java.util.List;

public class MyOrderActivity extends BaseActivity {


    private CustomTool toll_myorder;
    private TabLayout tab_myorder;
    private ViewPager vp_order;

    @Override
    public int getInitId() {
        return R.layout.activity_my_order;
    }

    @Override
    public void initView() {
        toll_myorder = findViewById(R.id.toll_myorder);
        tab_myorder = findViewById(R.id.tab_myorder);
        vp_order = findViewById(R.id.vp_order);

        toll_myorder.setAppTitle("我的订单");
        toll_myorder.initViewsVisible(true,false,true,false,false);
        ImageView img = toll_myorder.findViewById(R.id.Return_img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //复用Fragment
    @Override
    public void initData() {
        List<String> strings = new ArrayList<>();
        List<Fragment> fragments = new ArrayList<>();
        strings.add("全部");
        strings.add("待付款");
        strings.add("待施工");
        strings.add("待发货");
        strings.add("待收货");
        strings.add("待评价");
        for (int i = 0; i < 6; i++) {
            ReuseFragment reuseFragment = new ReuseFragment();
            fragments.add(reuseFragment);
            Bundle bundle = new Bundle();
            String s = strings.get(i);
            bundle.putString("title",s);
            reuseFragment.setArguments(bundle);
            MainAdapter adapter = new MainAdapter(getSupportFragmentManager(),strings,fragments);
            //设置适配器
            vp_order.setAdapter(adapter);
            //设置tabLayout
            tab_myorder.setupWithViewPager(vp_order);
            //设置文字的颜色
            tab_myorder.setTabTextColors(Color.BLACK,Color.BLUE);
            //设置下划线的颜色
            tab_myorder.setSelectedTabIndicatorColor(Color.BLUE);
            //设置是否滑动还是平铺
            tab_myorder.setTabMode(TabLayout.MODE_FIXED);

        }


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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) and run LayoutCreator again
    }
}
