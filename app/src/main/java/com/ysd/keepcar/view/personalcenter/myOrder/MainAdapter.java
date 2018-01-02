package com.ysd.keepcar.view.personalcenter.myOrder;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by asus on 2018/1/2.
 * 写这段代码的时候，只有上帝和我知道它是干嘛的
 * 现在只有上帝知道0.0
 */

public class MainAdapter extends FragmentPagerAdapter {

    private List<String> strings;
    private List<Fragment> fragments;

    public MainAdapter(FragmentManager fm, List<String> strings, List<Fragment> fragments) {
        super(fm);
        this.strings = strings;
        this.fragments = fragments;
    }

    public MainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }
}
