package com.ysd.keepcar.view.shop.activity;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ysd.keepcar.R;

import java.util.ArrayList;
import java.util.List;

//详情
public class Shop_DetailsActivity extends AppCompatActivity {

    //定义图片数组
    private int images[] = {R.mipmap.ic_icon15, R.mipmap.ic_icon15, R.mipmap.ic_icon15};
    //定义一个View的数组
    private List<View> views = new ArrayList<>();
    private ViewPager vp_main_viewpager;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_details);

        TextView text_pice = findViewById(R.id.text_pice);
        text_pice.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
        vp_main_viewpager = (ViewPager) findViewById(R.id.viewPager);
        textView = findViewById(R.id.button);

        //将images数组中的图片放入ImageView
        for (int i = 0; i < images.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(images[i]);
            views.add(imageView);
        }


        //为ViewPager设置适配器
        vp_main_viewpager.setAdapter(new MyAdapter());
    }

    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v = views.get(position);
            container.addView(v);

            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View v = views.get(position);
            //前一张图片划过后删除该View
            container.removeView(v);
        }


    }
}
