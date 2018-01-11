package com.ysd.keepcar.view.home.activity.boutique;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.view.ViewPager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.app.BaseActivity;
import com.ysd.keepcar.custom.CustomTool;

import okhttp3.MediaType;

public class BoutiqueInfoActivity extends BaseActivity {

    private CustomTool custom;
    private ViewPager boutique_info_pager;
    private TextView boutique_info_name;
    private TextView boutique_info_xinghao;
    private TextView boutique_info_gongsi;
    private TextView boutique_info_jiage;
    private TextView boutique_info_yuanjia;
    private TextView boutique_info_fukuan;
    private TextView boutique_info_pingjia;
    private ImageView boutique_info_usericon;
    private TextView boutique_info_userphone;
    private TextView boutique_info_userpingjia;
    private Button boutique_info_gengduo;
    private RelativeLayout boutique_info_dianpu;
    private RelativeLayout boutique_info_dianhua;
    private Button boutique_info_gouwuche;
    private Button boutique_info_goumai;

    @Override
    public int getInitId() {
        return R.layout.activity_boutique_info;
    }

    @Override
    public void initView() {
        custom=findViewById(R.id.boutique_info_custom);
        boutique_info_pager=findViewById(R.id.boutique_info_pager);
        boutique_info_name=findViewById(R.id.boutique_info_name);
        boutique_info_xinghao=findViewById(R.id.boutique_info_xinghao);
        boutique_info_gongsi=findViewById(R.id.boutique_info_gongsi);
        boutique_info_jiage=findViewById(R.id.boutique_info_jiage);
        boutique_info_yuanjia=findViewById(R.id.boutique_info_yuanjia);
        boutique_info_fukuan=findViewById(R.id.boutique_info_fukuan);
        boutique_info_pingjia=findViewById(R.id.boutique_info_pingjia);
        boutique_info_usericon=findViewById(R.id.boutique_info_usericon);
        boutique_info_userphone=findViewById(R.id.boutique_info_userphone);
        boutique_info_userpingjia=findViewById(R.id.boutique_info_userpingjia);
        boutique_info_gengduo=findViewById(R.id.boutique_info_gengduo);
        boutique_info_dianpu=findViewById(R.id.boutique_info_dianpu);
        boutique_info_dianhua=findViewById(R.id.boutique_info_dianhua);
        boutique_info_gouwuche=findViewById(R.id.boutique_info_gouwuche);
        boutique_info_goumai=findViewById(R.id.boutique_info_goumai);
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
        custom.initViewsVisible(true,false,false,false,false);
    }

}
