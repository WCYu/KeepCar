package com.ysd.keepcar.view;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.desmond.citypicker.bean.BaseCity;
import com.desmond.citypicker.bin.CityPicker;
import com.desmond.citypicker.callback.IOnCityPickerCheckedCallBack;
import com.desmond.citypicker.ui.CityPickerActivity;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.ysd.keepcar.R;
import com.ysd.keepcar.app.BaseActivity;
import com.ysd.keepcar.custom.CustomTool;
import com.ysd.keepcar.view.home.HomeFragment;
import com.ysd.keepcar.view.personalcenter.PersonFragment;
import com.ysd.keepcar.view.shop.ShopFragment;
import com.ysd.keepcar.view.shoppingcart.ShoppingFragment;

import org.greenrobot.eventbus.EventBus;

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
    public static final int REQUEST_CODE=1;
    private PopupWindow pw;

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
                    View view = LayoutInflater.from(HomeActivity.this).inflate(R.layout.jiahao, null);
                    pw = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    LinearLayout rll= view.findViewById(R.id.jiahao_lly);
                    LinearLayout erweima= view.findViewById(R.id.jiahao_myerweima);
                    LinearLayout saoyisao= view.findViewById(R.id.jiahao_mysaoyisao);
                    rll.getBackground().setAlpha(200);
                    rll.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            pw.dismiss();
                        }
                    });
                    erweima.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });
                    //扫一扫
                    saoyisao.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(HomeActivity.this, CaptureActivity.class);
                            startActivityForResult(intent, REQUEST_CODE);
                        }
                    });
                    pw.setFocusable(true);
                    pw.setWidth(ViewGroup.LayoutParams.FILL_PARENT);
                    pw.setHeight(ViewGroup.LayoutParams.FILL_PARENT);
                    pw.setBackgroundDrawable(new BitmapDrawable());
                    ImageView imageView = customTool.findViewById(R.id.Right_Img);
//                    pw.showAtLocation(imageView, Gravity.CENTER,0,0);
                    pw.showAsDropDown(imageView,0,10);
                }
            });
            customTool.setOnLeftButtonClickListener(new CustomTool.OnLeftButtonClickListener() {
                @Override
                public void onLeftButtonClick(View v) {
                    CityPicker cityPicker = CityPicker.with(HomeActivity.this);
                    cityPicker.setMaxHistory(0);
                    Intent intent=new Intent(HomeActivity.this,CityPickerActivity.class);
                    startActivityForResult(intent,0);
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0&&resultCode==(-1)){
            BaseCity baseCity=data.getParcelableExtra("SELECTED_RESULT");
            String cityName = baseCity.getCityName();
            customTool.setLeftTv(cityName);
//            Log.e("---HomeActivity---",cityName+"---------------");
        }
        if(requestCode==REQUEST_CODE){
            pw.dismiss();
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(HomeActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
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
}
