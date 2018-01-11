package com.ysd.keepcar.view.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.view.home.bean.NewCarBean;

import java.util.ArrayList;

/**
 * Created by 阿禹 on 2018/1/2.
 */

public class XinCarAdapter extends BaseAdapter {

    Context context;
    ArrayList<NewCarBean.DataBean.ListBean> arrayList;

    public XinCarAdapter(Context context, ArrayList<NewCarBean.DataBean.ListBean> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
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
        convertView = LayoutInflater.from(context).inflate(R.layout.newcar_list_item, null);
        ViewHolder vh = new ViewHolder(convertView);
        String brandName = arrayList.get(position).getBrandName();
        String seriesName = arrayList.get(position).getSeriesName();
        vh.exhibition_list_item_name.setText(brandName+"+"+seriesName);
        vh.exhibition_list_item_shi.setText("试驾" + arrayList.get(position).getNum());
        vh.exhibition_list_item_jiage.setText(arrayList.get(position).getMinPrice() + "-" + arrayList.get(position).getMaxPrice());
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView exhibition_list_item_icon;
        public TextView exhibition_list_item_name;
        public TextView exhibition_list_item_shi;
        public TextView exhibition_list_item_jiage;
        public TextView exhibition_list_item_shijia;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.exhibition_list_item_icon = (ImageView) rootView.findViewById(R.id.exhibition_list_item_icon);
            this.exhibition_list_item_name = (TextView) rootView.findViewById(R.id.exhibition_list_item_name);
            this.exhibition_list_item_shi = (TextView) rootView.findViewById(R.id.exhibition_list_item_shi);
            this.exhibition_list_item_jiage = (TextView) rootView.findViewById(R.id.exhibition_list_item_jiage);
            this.exhibition_list_item_shijia = (TextView) rootView.findViewById(R.id.exhibition_list_item_shijia);
        }

    }
}
