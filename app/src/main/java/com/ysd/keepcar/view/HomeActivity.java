package com.ysd.keepcar.view;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ysd.keepcar.R;
import com.ysd.keepcar.app.BaseActivity;
import com.ysd.keepcar.custom.CustomTool;
import com.ysd.keepcar.view.home.HomeFragment;
import com.ysd.keepcar.view.personalcenter.PersonFragment;
import com.ysd.keepcar.view.shop.ShopFragment;
import com.ysd.keepcar.view.shoppingcart.ShoppingFragment;

public class HomeActivity extends BaseActivity {

    private static boolean isExit = false;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

    public CustomTool customTool;
    private FrameLayout home_frame;
    private RadioButton home_home;
    private RadioButton home_shop;
    private RadioButton home_shoppingcart;
    private RadioButton home_personalcenter;
    private RadioGroup home_group;
    private FragmentTransaction transaction;
    private HomeFragment homeFragment;
    private PersonFragment personFragment;
    private ShopFragment shopFragment;
    private ShoppingFragment shoppingFragment;
    private FragmentManager fragmentManager;

    @Override
    public int getInitId() {
        return R.layout.activity_home;
    }

    @Override
    public void initView() {
        customTool = findViewById(R.id.home_custom);
        home_frame = findViewById(R.id.home_frame);
        home_home = findViewById(R.id.home_home);
        home_shop = findViewById(R.id.home_shop);
        home_shoppingcart = findViewById(R.id.home_shoppingcart);
        home_personalcenter = findViewById(R.id.home_personalcenter);
        home_group = findViewById(R.id.home_group);
        initFragment();
    }

    private void initFragment() {
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        homeFragment = new HomeFragment();
        personFragment = new PersonFragment();
        shopFragment = new ShopFragment();
        shoppingFragment = new ShoppingFragment();
        transaction.add(R.id.home_frame, personFragment);
        transaction.add(R.id.home_frame, shopFragment);
        transaction.add(R.id.home_frame, shoppingFragment);
        transaction.add(R.id.home_frame, homeFragment);
        isShowFragment(homeFragment);
        transaction.commit();
    }

    private void isShowFragment(Fragment fragment) {
        transaction.hide(homeFragment);
        transaction.hide(shopFragment);
        transaction.hide(shoppingFragment);
        transaction.hide(personFragment);
        transaction.show(fragment);
    }

    @Override
    public void initData() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    @Override
    public void initAdapter() {

    }

    @Override
    public void initLinstener() {
        home_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                transaction = fragmentManager.beginTransaction();
                switch (checkedId) {
                    case R.id.home_home:
                        initHomeBar();
                        break;
                    case R.id.home_shop:
                        initShopBar();
                        break;
                    case R.id.home_shoppingcart:
                        initShoppingBar();
                        break;
                    case R.id.home_personalcenter:
                        initPersonBar();
                        break;

                }
                transaction.commit();
            }
        });
    }

    //个人中心
    private void initPersonBar() {
        isShowFragment(personFragment);
        customTool.setRightIcon(R.mipmap.sandian);
        customTool.setAppTitle("个人中心");
        customTool.initViewsVisible(false, false, true, true, false);
        customTool.setOnRightImgClickLisrener(new CustomTool.OnRightImgClickListener() {
            @Override
            public void onRightImgClick(View v) {
                Toast.makeText(HomeActivity.this, "hahah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //购物车
    private void initShoppingBar() {
        isShowFragment(shoppingFragment);
        customTool.setAppTitle("购物车");
        customTool.setRightTitle("编辑");
        customTool.initViewsVisible(false, false, true, false, true);
        customTool.setOnRightTitleClickListener(new CustomTool.OnRightTitleClickListener() {
            @Override
            public void onRightTitleClick(View v) {

            }
        });
    }

    //4S店
    private void initShopBar() {
        isShowFragment(shopFragment);
        customTool.setAppTitle("4S店");
        customTool.initViewsVisible(false, false, true, false, false);
    }

    @Override
    public void initToolBar() {
        initHomeBar();
    }

    //4S养车
    private void initHomeBar() {
        if (home_home.isChecked()) {
            customTool.setRightIcon(R.drawable.topplussign);
            isShowFragment(homeFragment);
            customTool.setAppTitle("4S养车");
            customTool.initViewsVisible(false, true, true, true, false);
            customTool.setOnRightImgClickLisrener(new CustomTool.OnRightImgClickListener() {
                @Override
                public void onRightImgClick(View v) {
                    Toast.makeText(HomeActivity.this, "enenen", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }

    private void initWindow() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        }
    }
}
