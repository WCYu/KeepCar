package com.ysd.keepcar.view.shop.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.app.AppService;
import com.ysd.keepcar.app.BaseActivity;
import com.ysd.keepcar.view.shop.adapter.Shop_Fragment_Adapter;
import com.ysd.keepcar.view.shop.fragment.Boutique_Fragment;
import com.ysd.keepcar.view.shop.fragment.HuoDong_Fragment;
import com.ysd.keepcar.view.shop.fragment.Integral_Mall_Fragment;
import com.ysd.keepcar.view.shop.fragment.The_New_Car_Fragment;
import com.ysd.keepcar.view.shop.fragment.UsedCar_Fragment;

import java.util.ArrayList;

public class Four_S_ShopActivity extends BaseActivity implements View.OnClickListener {


    private ImageView image_background;
    private ImageView image_return;
    private ImageView image_icon;
    private TextView text_name;
    private TextView text_dizhi;
    private TextView text_km;
    private TextView text_pingfen;
    private TabLayout shop_tablayout;
    private ViewPager viewp_shop;
    private Object childFragmentManager;
    private Button btn_bendianzhanghu;
    private Button btn_find;
    private Button btn_daohang;
    private PopupWindow popupWindow;
    private LinearLayout line_shopitem;

    @Override
    public int getInitId() {
        return R.layout.activity_four_s_shop;
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

        line_shopitem = findViewById(R.id.line_shopitem);
        btn_bendianzhanghu = findViewById(R.id.btn_bendianzhanghu);
        btn_find = findViewById(R.id.btn_find);
        btn_daohang = findViewById(R.id.btn_daohang);

        btn_bendianzhanghu.setOnClickListener(this);
        btn_find.setOnClickListener(this);
        btn_daohang.setOnClickListener(this);

        image_return.setOnClickListener(this);


        shop_tablayout.setupWithViewPager(viewp_shop);


        ArrayList<String> list = new ArrayList<>();
        list.add("精品");
        list.add("活动");
        list.add("新车");
        list.add("二手车");
        list.add("积分商场");
        ArrayList<Fragment> fragmentslist = new ArrayList<>();
        Boutique_Fragment boutique_fragment = new Boutique_Fragment();
        HuoDong_Fragment huoDong_fragment = new HuoDong_Fragment();
        The_New_Car_Fragment the_new_car_fragment = new The_New_Car_Fragment();
        UsedCar_Fragment usedCar_fragment = new UsedCar_Fragment();
        Integral_Mall_Fragment integral_mall_fragment = new Integral_Mall_Fragment();
        fragmentslist.add(boutique_fragment);
        fragmentslist.add(huoDong_fragment);
        fragmentslist.add(the_new_car_fragment);
        fragmentslist.add(usedCar_fragment);
        fragmentslist.add(integral_mall_fragment);

        viewp_shop.setOffscreenPageLimit(3);
        FragmentManager fm = getSupportFragmentManager();
        Shop_Fragment_Adapter shop_fragment_adapter = new Shop_Fragment_Adapter(fm, list, fragmentslist);
        viewp_shop.setAdapter(shop_fragment_adapter);

    }

    @Override
    public void initData() {

        Intent intent = getIntent();
        String logo = intent.getStringExtra("logo");
        String shopimg = intent.getStringExtra("shopimg");
        String shopname = intent.getStringExtra("shopname");
        String provincename = intent.getStringExtra("provincename");
        String cityname = intent.getStringExtra("cityname");
        String star = intent.getStringExtra("star");
        text_name.setText(shopname);
        text_dizhi.setText(provincename + cityname);
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

            //本店账户
            case R.id.btn_bendianzhanghu:

                startActivity(new Intent(Four_S_ShopActivity.this, Shop_DetailsActivity.class));
                break;

            //发现
            case R.id.btn_find:
                View shop_find_popuwindow = LayoutInflater.from(AppService.baseActivity).inflate(R.layout.shop_find_popuwindow, null);
                Find_Popuwindow(shop_find_popuwindow);
                break;
            //导航
            case R.id.btn_daohang:

                break;
        }
    }

    private void Find_Popuwindow(View shop_find_popuwindow) {

        popupWindow = new PopupWindow(shop_find_popuwindow, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        shop_find_popuwindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        popupWindow.setFocusable(true);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.showAsDropDown(btn_find, 0, 20);

    }


}
