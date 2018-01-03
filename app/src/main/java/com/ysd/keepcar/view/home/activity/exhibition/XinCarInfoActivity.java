package com.ysd.keepcar.view.home.activity.exhibition;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.app.BaseActivity;

public class XinCarInfoActivity extends BaseActivity implements View.OnClickListener{

    private ViewPager xin_car_info_pager;
    private ImageView xin_car_info_img;
    private ImageView xin_car_info_pinpai_icon;
    private TextView xin_car_info_pinpai;
    private TextView xin_car_info_carxi;
    private TextView xin_car_info_call;
    private TextView xin_car_info_yue;
    private PopupWindow pw;

    @Override
    public int getInitId() {
        return R.layout.activity_xin_car_info;
    }

    @Override
    public void initView() {
        xin_car_info_pager=findViewById(R.id.xin_car_info_pager);
        xin_car_info_img=findViewById(R.id.xin_car_info_img);
        xin_car_info_pinpai_icon=findViewById(R.id.xin_car_info_pinpai_icon);
        xin_car_info_pinpai=findViewById(R.id.xin_car_info_pinpai);
        xin_car_info_carxi=findViewById(R.id.xin_car_info_carxi);
        xin_car_info_call=findViewById(R.id.xin_car_info_call);
        xin_car_info_yue=findViewById(R.id.xin_car_info_yue);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initAdapter() {

    }

    @Override
    public void initLinstener() {
        xin_car_info_img.setOnClickListener(this);
        xin_car_info_call.setOnClickListener(this);
        xin_car_info_yue.setOnClickListener(this);
    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.xin_car_info_img:
                finish();
                break;
            case R.id.xin_car_info_call:
                View view = LayoutInflater.from(XinCarInfoActivity.this).inflate(R.layout.call_item, null);
                pw =new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                view.getBackground().setAlpha(200);
                LinearLayout xiaoshou=view.findViewById(R.id.call_xiaoshou);
                LinearLayout zongjing=view.findViewById(R.id.call_zongjing);
                final TextView zongjiCall=view.findViewById(R.id.call_zongjing_phone);
                final TextView xiaoshouCall=view.findViewById(R.id.call_xiaoshou_phone);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pw.dismiss();
                    }
                });
                xiaoshou.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        String string = zongjiCall.getText().toString();
                        String[] split = string.split("-");
                        StringBuffer sb=new StringBuffer();
                        for (int i = 0; i < split.length; i++) {
                            sb.append(split[i]);
                        }
                        Uri data = Uri.parse("tel:" + sb.toString());
                        intent.setData(data);
                    }
                });

                zongjing.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        String string = xiaoshouCall.getText().toString();
                        String[] split = string.split("-");
                        StringBuffer sb=new StringBuffer();
                        for (int i = 0; i < split.length; i++) {
                            sb.append(split[i]);
                        }
                        Uri data = Uri.parse("tel:" + sb.toString());
                        intent.setData(data);
                    }
                });
                pw.setFocusable(true);
                pw.setWidth(ViewGroup.LayoutParams.FILL_PARENT);
                pw.setHeight(ViewGroup.LayoutParams.FILL_PARENT);
                pw.setBackgroundDrawable(new BitmapDrawable());

                pw.showAtLocation(xin_car_info_call, Gravity.CENTER,0,0);
                break;
            case R.id.xin_car_info_yue:
                break;
        }
    }
}
