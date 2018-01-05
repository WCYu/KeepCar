package com.ysd.keepcar.view.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.view.home.bean.ActivityBean;

import java.util.ArrayList;

/**
 * Created by 阿禹 on 2018/1/5.
 */

public class ActivityAdapter extends BaseAdapter {
    ArrayList<ActivityBean.DataBean.ListBean> arrayList;
    Context context;

    public ActivityAdapter(ArrayList<ActivityBean.DataBean.ListBean> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

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
        convertView = LayoutInflater.from(context).inflate(R.layout.activity_adapter_item, null);
        ViewHolder vh = new ViewHolder(convertView);
        vh.activity_adapter_tv1.setText(arrayList.get(position).getProductName());
        vh.activity_adapter_tv2.setText(arrayList.get(position).getShopName());
//        vh.boutique_adapter_tv3.setText(arrayList.get(position));
//        vh.boutique_adapter_tv4.setText(arrayList.get(position));
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView activity_adapter_img;
        public TextView activity_adapter_tv1;
        public ImageView activity_adapter_img2;
        public TextView activity_adapter_tv2;
        public TextView activity_adapter_img3;
        public TextView activity_adapter_tv3;
        public TextView activity_adapter_tv4;
        public LinearLayout activity_adapter_lly;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.activity_adapter_img = (ImageView) rootView.findViewById(R.id.activity_adapter_img);
            this.activity_adapter_tv1 = (TextView) rootView.findViewById(R.id.activity_adapter_tv1);
            this.activity_adapter_img2 = (ImageView) rootView.findViewById(R.id.activity_adapter_img2);
            this.activity_adapter_tv2 = (TextView) rootView.findViewById(R.id.activity_adapter_tv2);
            this.activity_adapter_img3 = (TextView) rootView.findViewById(R.id.activity_adapter_img3);
            this.activity_adapter_tv3 = (TextView) rootView.findViewById(R.id.activity_adapter_tv3);
            this.activity_adapter_tv4 = (TextView) rootView.findViewById(R.id.activity_adapter_tv4);
            this.activity_adapter_lly = (LinearLayout) rootView.findViewById(R.id.activity_adapter_lly);
        }

    }
}
