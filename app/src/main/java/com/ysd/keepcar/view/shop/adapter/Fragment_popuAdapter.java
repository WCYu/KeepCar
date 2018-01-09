package com.ysd.keepcar.view.shop.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class Fragment_popuAdapter extends FragmentPagerAdapter {

    private ArrayList<String> tabs;
    private List<Fragment> fragmentList;


    public Fragment_popuAdapter(FragmentManager fm, ArrayList<String> tabs, List<Fragment> fragmentList) {
        super(fm);
        this.tabs = tabs;
        this.fragmentList = fragmentList;

    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return  tabs.get(position);
    }
}
