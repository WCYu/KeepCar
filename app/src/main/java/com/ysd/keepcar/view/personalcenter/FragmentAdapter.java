package com.ysd.keepcar.view.personalcenter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import java.util.List;

/**
 * Created by asus on 2018/1/4.
 * 写这段代码的时候，只有上帝和我知道它是干嘛的
 * 现在只有上帝知道0.0
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    List<String> tabs;
    List<Fragment> fragments;
    Context context;
    int[] tabImg;




    public FragmentAdapter(FragmentManager fm, List<String> tabs, List<Fragment> fragments, Context context, int[] tabImg) {
        super(fm);
        this.tabs = tabs;
        this.fragments = fragments;
        this.context = context;
        this.tabImg = tabImg;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Drawable dImage = context.getResources().getDrawable(tabImg[position]);
        dImage.setBounds(0, 0, dImage.getIntrinsicWidth(), dImage.getIntrinsicHeight());
        //这里前面加的空格就是为图片显示
        SpannableString sp = new SpannableString(" "+ tabs.get(position));
        ImageSpan imageSpan = new ImageSpan(dImage, ImageSpan.ALIGN_BOTTOM);
        sp.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return  sp;

    }
}
