package com.ysd.keepcar.view.shop.activity;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ysd.keepcar.R;

import java.util.ArrayList;
import java.util.List;

//详情
public class Shop_DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    //
    private ViewPager viewPager;
    private int[] res = {R.mipmap.ic_icon15, R.mipmap.ic_icon15, R.mipmap.ic_icon15};
    private List<ImageView> listdata = new ArrayList<ImageView>();
    private ListView order_listView;
    private TextView text_yema;
    private int a;
    private Button but_GouWuChe;
    private Button but_GouMai;
    private ImageView image_icon;
    private TextView text_name;
    private TextView text_gongSi;
    private TextView text_pice;
    private TextView text_yuanjia_pice;
    private TextView text_renShu;
    private LinearLayout linear_shop;
    private LinearLayout linear_phone;
    private View popupview;
    private PopupWindow popupWindow;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_details);
        initView();
        initData();
        initAdapter();
    }

    private void initAdapter() {

        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return listdata.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = listdata.get(position);
                container.addView(imageView);
                return imageView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((ImageView) object);
            }
        });

    }

    private void initData() {
        for (int i = 0; i < res.length; i++) {
            ImageView imageview = new ImageView(getApplication());
            imageview.setScaleType(ImageView.ScaleType.FIT_XY);
            imageview.setImageResource(res[i]);
            listdata.add(imageview);
        }
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                text_yema.setText((position + 1) + "/" + listdata.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void initView() {
        image_icon = findViewById(R.id.image_icon);
        text_name = findViewById(R.id.text_name);
        text_gongSi = findViewById(R.id.text_GongSi);
        text_pice = findViewById(R.id.text_pice);
        text_yuanjia_pice = findViewById(R.id.text_yuanjia_pice);
        text_renShu = findViewById(R.id.text_RenShu);
        linear_shop = findViewById(R.id.linear_shop);
        linear_phone = findViewById(R.id.linear_phone);

        but_GouWuChe = (Button) findViewById(R.id.but_GouWuChe);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        text_yema = (TextView) findViewById(R.id.text_yema);
        but_GouMai = (Button) findViewById(R.id.but_GouMai);

        viewPager.setOnClickListener(this);
        text_yema.setOnClickListener(this);
        but_GouWuChe.setOnClickListener(this);
        but_GouMai.setOnClickListener(this);

        image_icon.setOnClickListener(this);
        linear_shop.setOnClickListener(this);
        linear_phone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_icon:
                finish();
                break;
            case R.id.linear_shop: 
                break;

            case R.id.linear_phone:

                break;
            case R.id.but_GouWuChe:
                ShowPopuWindow();
                break;
            case R.id.but_GouMai:
                ShowPopuWindow();
                break;
        }
    }


    private void ShowPopuWindow() {

//        弹出一个popupwindow

//        加载popupwndow的布局
        View shop_goumai_popuwindow = LayoutInflater.from(Shop_DetailsActivity.this).inflate(R.layout.shop_goumai_popuwindow, null);
//        创建一个popupWindow对象
        popupWindow = new PopupWindow(shop_goumai_popuwindow, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        shop_goumai_popuwindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        //        默认获取不到焦点，设置获取焦点

        popupWindow.setFocusable(true);
//        点击窗口以外的区域，窗口消失
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
//        显示popupwindow
       popupWindow.showAtLocation(shop_goumai_popuwindow, Gravity.BOTTOM, 0, 0);
        Button jia = (Button) shop_goumai_popuwindow.findViewById(R.id.jia);
        Button jian = (Button) shop_goumai_popuwindow.findViewById(R.id.jian);
        Button Determine = shop_goumai_popuwindow.findViewById(R.id.Determine);
        final TextView jiage = (TextView) shop_goumai_popuwindow.findViewById(R.id.jiage);
        a = 1;

        jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a++;
                jiage.setText(a + "");
            }
        });
        jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a > 1) {
                    a--;
                    jiage.setText(a + "");
                }
            }
        });
        Determine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });

    }


}
