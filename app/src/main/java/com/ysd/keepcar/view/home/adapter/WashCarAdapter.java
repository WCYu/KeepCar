package com.ysd.keepcar.view.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.view.home.bean.WashCarBean;

import java.util.ArrayList;

/**
 * Created by 阿禹 on 2018/1/10.
 */

public class WashCarAdapter extends BaseAdapter {
    ArrayList<WashCarBean.DataBean.ListBean> arrayList;
    Context context;

    public WashCarAdapter(ArrayList<WashCarBean.DataBean.ListBean> arrayList, Context context) {
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
        convertView = LayoutInflater.from(context).inflate(R.layout.washcar_list_item, null);
        ViewHolder vh=new ViewHolder(convertView);
        vh.washcar_item_name.setText(arrayList.get(position).getShopName());
        vh.washcar_item_rating.setRating((float) arrayList.get(position).getStar());
        vh.washcar_item_address.setText(arrayList.get(position).getProvinceName()+" "+arrayList.get(position).getCityName());
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView washcar_item_img;
        public TextView washcar_item_name;
        public RatingBar washcar_item_rating;
        public TextView washcar_item_address;
        public TextView washcar_item_jiage;
        public TextView washcar_item_xinghao;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.washcar_item_img = (ImageView) rootView.findViewById(R.id.washcar_item_img);
            this.washcar_item_name = (TextView) rootView.findViewById(R.id.washcar_item_name);
            this.washcar_item_rating = (RatingBar) rootView.findViewById(R.id.washcar_item_rating);
            this.washcar_item_address = (TextView) rootView.findViewById(R.id.washcar_item_address);
            this.washcar_item_jiage = (TextView) rootView.findViewById(R.id.washcar_item_jiage);
            this.washcar_item_xinghao = (TextView) rootView.findViewById(R.id.washcar_item_xinghao);
        }

    }
}
