package com.ysd.keepcar.view.shop.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

//
//                       _oo0oo_
//                      o8888888o
//                      88" . "88
//                      (| -_- |)
//                      0\  =  /0
//                    ___/`---'\___
//                  .' \\|     |// '.
//                 / \\|||  :  |||// \
//                / _||||| -:- |||||- \
//               |   | \\\  -  /// |   |
//               | \_|  ''\---/''  |_/ |
//               \  .-\__  '-'  ___/-. /
//             ___'. .'  /--.--\  `. .'___
//          ."" '<  `.___\_<|>_/___.' >' "".
//         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//         \  \ `_.   \_ __\ /__ _/   .-` /  /
//     =====`-.____`.___ \_____/___.-`___.-'=====
//                       `=---='
//
//
//     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//               佛祖保佑         永无BUG
//
//
//
public class Shop_Fragment_Adapter extends FragmentPagerAdapter {
    private ArrayList<String> list;
    private ArrayList<Fragment> fragmentslist;

    public Shop_Fragment_Adapter(FragmentManager fm, ArrayList<String> list, ArrayList<Fragment> fragmentslist) {
        super(fm);
        this.list = list;
        this.fragmentslist = fragmentslist;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentslist.get(position);
    }

    @Override
    public int getCount() {
        return fragmentslist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return list.get(position);
    }
}
