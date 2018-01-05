package com.ysd.keepcar.view.shop.activity;

import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
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
import com.ysd.keepcar.app.AppService;

import java.util.ArrayList;
import java.util.List;

//详情
public class Shop_DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    //定义图片数组
    private int[] res = {R.mipmap.ic_icon15, R.mipmap.ic_icon15, R.mipmap.ic_icon15};
    private List<ImageView> listdata = new ArrayList<ImageView>();
    private ViewPager vp_main_viewpager;
    private TextView textView;
    private ImageView image_icon;
    private TextView text_gongSi;
    private TextView text_name;
    private TextView text_pice;
    private TextView text_renShu;
    private ListView order_listView;
    private LinearLayout linear_shop;
    private LinearLayout linear_phone;
    private Button but_gouWuChe;
    private Button but_gouMai;
    private PopupWindow popupWindow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_details);
        TextView text_yuanjia_pice = findViewById(R.id.text_yuanjia_pice);
        text_yuanjia_pice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//原价中心横线


        vp_main_viewpager = (ViewPager) findViewById(R.id.viewPager);
        textView = findViewById(R.id.text_yema);
        initData();
        initAdapter();
        //   order_listView = findViewById(R.id.order_listView);
        linear_shop = findViewById(R.id.linear_shop);
        linear_phone = findViewById(R.id.linear_phone);
        but_gouWuChe = findViewById(R.id.but_GouWuChe);
        but_gouMai = findViewById(R.id.but_GouMai);
        // 原价

        image_icon = findViewById(R.id.image_icon);
        text_name = findViewById(R.id.text_name);
        text_gongSi = findViewById(R.id.text_GongSi);
        text_pice = findViewById(R.id.text_pice);
        text_renShu = findViewById(R.id.text_RenShu);
        image_icon.setOnClickListener(this);
        linear_shop.setOnClickListener(this);
        linear_phone.setOnClickListener(this);
        but_gouWuChe.setOnClickListener(this);
        but_gouMai.setOnClickListener(this);
    }


    //轮播图的页码
    public void initAdapter() {
        vp_main_viewpager.setAdapter(new PagerAdapter() {
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

    //轮播图的页码
    public void initData() {
        for (int i = 0; i < res.length; i++) {
            ImageView imageview = new ImageView(getApplication());
            imageview.setScaleType(ImageView.ScaleType.FIT_XY);
            imageview.setImageResource(res[i]);
            listdata.add(imageview);
        }
        vp_main_viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                textView.setText((position + 1) + "/" + listdata.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_icon:
                finish();

                break;
            //店铺
            case R.id.linear_shop:

                break;
            //电话
            case R.id.linear_phone:

                break;

            //加入购物车
            case R.id.but_GouWuChe:

                break;
            //立即购买
            case R.id.but_GouMai:
           //     popupWindow(view);
                break;

        }

    }


    private void popupWindow(View view) {
        view = LayoutInflater.from(AppService.baseActivity).inflate(R.layout.shop_goumai_popuwindow, null);
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setTouchable(true);
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));


    }


}
