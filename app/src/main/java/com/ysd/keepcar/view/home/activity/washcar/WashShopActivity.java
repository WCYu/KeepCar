package com.ysd.keepcar.view.home.activity.washcar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ysd.keepcar.R;
import com.ysd.keepcar.app.BaseActivity;

public class WashShopActivity extends BaseActivity implements View.OnClickListener {

    private ImageView imageView3;
    private TextView xianjia1_shop;
    private TextView xianjia_shop;
    private TextView yuanjia_shop;
    private TextView yuanjia1_shop;
    private TextView yishou_shop;
    private TextView yishou1_shop;
    private TextView xianjia2_shop;
    private TextView yuanjia2_shop;
    private TextView yishou2_shop;
    private TextView xianjia3_shop;
    private TextView yuanjia3_shop;
    private TextView yishou3_shop;
    private ListView lv_shop;
    private RadioButton zhanghu_shop;
    private RadioButton pingjia_shop;
    private RadioButton daohang_shop;
    private RadioGroup shop_group;
    private View itme_shop;
    private LinearLayout biaoxi_itme;
    private LinearLayout biaoxi1_itme;
    private LinearLayout xicheka_itme;
    private LinearLayout linrat_shop;

    @Override
    public int getInitId() {
        return R.layout.activity_shop_wash;
        //中间加横线
//        tv.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
    }

    public void initView() {
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        xianjia_shop = (TextView) findViewById(R.id.xianjia_shop);
        xianjia1_shop = (TextView) findViewById(R.id.xianjia1_shop);
        yuanjia_shop = (TextView) findViewById(R.id.yuanjia_shop);
        yuanjia1_shop = (TextView) findViewById(R.id.yuanjia_shop);
        yishou_shop = (TextView) findViewById(R.id.yishou1_shop);
        yishou1_shop = (TextView) findViewById(R.id.yishou1_shop);
        xianjia2_shop = (TextView) findViewById(R.id.xianjia2_shop);
        yuanjia2_shop = (TextView) findViewById(R.id.yuanjia2_shop);
        yishou2_shop = (TextView) findViewById(R.id.yishou2_shop);
        xianjia3_shop = (TextView) findViewById(R.id.xianjia3_shop);
        yuanjia3_shop = (TextView) findViewById(R.id.yuanjia3_shop);
        yishou3_shop = (TextView) findViewById(R.id.yishou3_shop);
        zhanghu_shop = (RadioButton) findViewById(R.id.zhanghu_shop);
        pingjia_shop = (RadioButton) findViewById(R.id.pingjia_shop);
        daohang_shop = (RadioButton) findViewById(R.id.daohang_shop);
        linrat_shop = (LinearLayout) findViewById(R.id.linrat_shop);

        yuanjia1_shop.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        yuanjia2_shop.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        yuanjia3_shop.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);


        biaoxi_itme = findViewById(R.id.biaoxi_itme);
        biaoxi1_itme = findViewById(R.id.biaoxi1_itme);
        xicheka_itme = findViewById(R.id.xicheka_itme);
        shop_group = (RadioGroup) findViewById(R.id.shop_group);
        itme_shop = (View) findViewById(R.id.itme_shop);

        zhanghu_shop.setOnClickListener(this);
        pingjia_shop.setOnClickListener(this);
        daohang_shop.setOnClickListener(this);
        biaoxi_itme.setOnClickListener(this);
        biaoxi1_itme.setOnClickListener(this);
        xicheka_itme.setOnClickListener(this);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.biaoxi_itme:
                Intent intent = new Intent(WashShopActivity.this, WashDetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.biaoxi1_itme:
                Intent intent1 = new Intent(WashShopActivity.this, WashDetailsActivity.class);
                startActivity(intent1);
                break;
            case R.id.xicheka_itme:
                Intent intent2 = new Intent(WashShopActivity.this, WashDetailsActivity.class);
                startActivity(intent2);
                break;
            case R.id.zhanghu_shop:

                Toast.makeText(WashShopActivity.this, "1111", Toast.LENGTH_SHORT).show();

                View view = LayoutInflater.from(WashShopActivity.this).inflate(R.layout.shop_popu1_layout, null);
                PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                //默认获取不到焦点，设置获取焦点
                popupWindow.setFocusable(true);
                //点击窗口以外区域，窗口消失
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                //弹出或者消失的时候带动画效果
                //popu.setAnimationStyle(R.style.mypopu);
                setBackgroundAlpha(0.5f);
                //显示popuwindow
//                        popupWindow.showAsDropDown(shop_group,0,0);
                popupWindow.showAtLocation(linrat_shop, Gravity.BOTTOM,0,0);
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
//                                zhanghu_shop.setChecked(false);
                        setBackgroundAlpha(1.0f);
                    }
                });
                break;
            case R.id.pingjia_shop:
                break;
            case R.id.daohang_shop:
                break;
        }
    }

    /**
     * 设置添加屏幕的背景透明度
     * 屏幕透明度0.0-1.0 1表示完全不透明
     */
    public void setBackgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = ((Activity) this).getWindow()
                .getAttributes();
        lp.alpha = bgAlpha;
        ((Activity) this).getWindow().setAttributes(lp);
    }
}
