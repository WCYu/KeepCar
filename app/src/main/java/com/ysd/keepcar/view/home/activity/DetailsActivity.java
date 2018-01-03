package com.ysd.keepcar.view.home.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.ysd.keepcar.R;
import com.ysd.keepcar.app.BaseActivity;
import com.ysd.keepcar.utils.GlideImage;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends BaseActivity implements View.OnClickListener {

    private Banner banner;
    private TextView leixing_details;
    private TextView dianpu_details;
    private TextView dizhi_details;
    private TextView jiage_details;
    private TextView yuanjia_details;
    private TextView chushou_details;
    private TextView neirong_details;
    private ImageView biaoqian1_details;
    private ImageView biaoqian2_details;
    private ImageView biaoqian3_details;
    private ImageView biaoqian4_details;
    private TextView neirong1_details;
    private TextView shuliang1_details;
    private TextView neirong2_details;
    private TextView shuliang2_details;
    private TextView neirong3_details;
    private TextView shuliang3_details;
    private TextView pingjiashu_details;
    private TextView dianhu_details;
    private TextView pingjia_details;
    private Button but_details;
    private TextView xiangqingdetails;
    private RadioButton dianhua_details;
    private RadioButton goumai_details;
    private ScrollView scrollview_details;
    private RadioButton fanhui_details;

    @Override
    public int getInitId() {
        return R.layout.activity_details;
    }

    public void initView() {
        banner = (Banner) findViewById(R.id.banner_details);
        leixing_details = (TextView) findViewById(R.id.leixing_details);
        dianpu_details = (TextView) findViewById(R.id.dianpu_details);
        dizhi_details = (TextView) findViewById(R.id.dizhi_details);
        jiage_details = (TextView) findViewById(R.id.jiage_details);
        yuanjia_details = (TextView) findViewById(R.id.yuanjia_details);
        chushou_details = (TextView) findViewById(R.id.chushou_details);
        neirong_details = (TextView) findViewById(R.id.neirong_details);
        biaoqian1_details = (ImageView) findViewById(R.id.biaoqian1_details);
        biaoqian2_details = (ImageView) findViewById(R.id.biaoqian2_details);
        biaoqian3_details = (ImageView) findViewById(R.id.biaoqian3_details);
        biaoqian4_details = (ImageView) findViewById(R.id.biaoqian4_details);
        neirong1_details = (TextView) findViewById(R.id.neirong1_details);
        shuliang1_details = (TextView) findViewById(R.id.shuliang1_details);
        neirong2_details = (TextView) findViewById(R.id.neirong2_details);
        shuliang2_details = (TextView) findViewById(R.id.shuliang2_details);
        neirong3_details = (TextView) findViewById(R.id.neirong3_details);
        shuliang3_details = (TextView) findViewById(R.id.shuliang3_details);
        pingjiashu_details = (TextView) findViewById(R.id.pingjiashu_details);
        dianhu_details = (TextView) findViewById(R.id.dianhu_details);
        pingjia_details = (TextView) findViewById(R.id.pingjia_details);
        but_details = (Button) findViewById(R.id.but_details);
        xiangqingdetails = (TextView) findViewById(R.id.xiangqingdetails);
        dianhua_details = (RadioButton) findViewById(R.id.dianhua_details);
        goumai_details = (RadioButton) findViewById(R.id.goumai_details);
        fanhui_details = (RadioButton) findViewById(R.id.fanhui_details);
        scrollview_details = (ScrollView) findViewById(R.id.scrollview_details);


        but_details.setOnClickListener(this);
        dianhua_details.setOnClickListener(this);
        goumai_details.setOnClickListener(this);
        fanhui_details.setOnClickListener(this);


    }

    //轮播图
    @Override
    public void initData() {

        List<Integer> imgs = new ArrayList<>();
        imgs.add(R.drawable.d);
        imgs.add(R.drawable.b);
        imgs.add(R.drawable.c);
        List<String> titles = new ArrayList<>();
        titles.add("1/3");
        titles.add("2/3");
        titles.add("3/3");
        banner.setImages(imgs)//添加图片集合或图片url集合
                .setIndicatorGravity(BannerConfig.CENTER)//设置指示器位置（当banner模式中有指示器时）
                .setBannerAnimation(Transformer.BackgroundToForeground)//设置banner动画效果
                .setBannerTitles(titles)//设置标题集合（当banner样式有显示title时）
                .setDelayTime(1500)//设置轮播时间
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                .setImageLoader(new GlideImage())//加载图片
                .start();
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
        switch (v.getId()) {
            case R.id.but_details:

                break;
            case R.id.dianhua_details:
                //显示popuwindow
                View view = LayoutInflater.from(DetailsActivity.this).inflate(R.layout.call_layout, null);
                //创建一个popuwindow对象
                PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                //默认获取不到焦点，设置获取焦点
                popupWindow.setFocusable(true);
                //点击窗口以外区域，窗口消失
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                //弹出或者消失的时候带动画效果
//                popupWindow.setAnimationStyle(R.style.mypopu);
                //显示popuwindow
                popupWindow.showAtLocation(scrollview_details, Gravity.CENTER,0,0);
                //设置屏幕透明度
                setBackgroundAlpha(0.5f);
                //设置popu关闭事件
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        setBackgroundAlpha(1.0f);//设置屏幕透明度
                    }
                });
                TextView zongji_call = view.findViewById(R.id.zongji_call);
                TextView xiaoshou_call = view.findViewById(R.id.xiaoshou_call);

                zongji_call.setOnClickListener(this);
                xiaoshou_call.setOnClickListener(this);
                break;
            case R.id.goumai_details:
                //显示popuwindow
                View view1 = LayoutInflater.from(DetailsActivity.this).inflate(R.layout.goumai_layout, null);
                //创建一个popuwindow对象
                PopupWindow popupWindow1 = new PopupWindow(view1, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                //默认获取不到焦点，设置获取焦点
                popupWindow1.setFocusable(true);
                //点击窗口以外区域，窗口消失
                popupWindow1.setBackgroundDrawable(new BitmapDrawable());
                //弹出或者消失的时候带动画效果
//                popupWindow1.setAnimationStyle(R.style.mypopu);
                //显示popuwindow
                popupWindow1.showAtLocation(scrollview_details, Gravity.BOTTOM,0,0);
                //设置屏幕透明度
                setBackgroundAlpha(0.5f);
                //设置popu关闭事件
                popupWindow1.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        setBackgroundAlpha(1.0f);//设置屏幕透明度
                    }
                });

                break;
            case R.id.fanhui_details:
                finish();
                break;
            case R.id.zongji_call:
                Uri smsToUri = Uri.parse("smsto:01015479862");
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + smsToUri));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            case R.id.xiaoshou_call :
                Uri smsToUri1 = Uri.parse("smsto:13645874547");
                Intent intent1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + smsToUri1));
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent1);
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
