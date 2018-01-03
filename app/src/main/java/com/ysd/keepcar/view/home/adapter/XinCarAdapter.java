package com.ysd.keepcar.view.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ysd.keepcar.R;

import java.util.ArrayList;

/**
 * Created by 阿禹 on 2018/1/2.
 */

public class XinCarAdapter extends BaseAdapter {

    Context context;
    ArrayList arrayList;
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.home_list_item,null);
        return convertView;
    }
}
