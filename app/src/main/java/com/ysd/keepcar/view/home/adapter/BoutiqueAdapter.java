package com.ysd.keepcar.view.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ysd.keepcar.R;

import java.util.ArrayList;

/**
 * Created by 阿禹 on 2018/1/5.
 */

public class BoutiqueAdapter extends BaseAdapter {
    ArrayList<String> arrayList;
    Context context;

    public BoutiqueAdapter(ArrayList<String> arrayList, Context context) {
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
        convertView = LayoutInflater.from(context).inflate(R.layout.boutique_adapter_item, null);
        ViewHolder vh = new ViewHolder(convertView);
//        vh.boutique_adapter_tv1.setText(arrayList.get(position));
//        vh.boutique_adapter_tv2.setText(arrayList.get(position));
//        vh.boutique_adapter_tv3.setText(arrayList.get(position));
//        vh.boutique_adapter_tv4.setText(arrayList.get(position));
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView boutique_adapter_img;
        public TextView boutique_adapter_tv1;
        public ImageView boutique_adapter_img2;
        public TextView boutique_adapter_tv2;
        public TextView boutique_adapter_img3;
        public TextView boutique_adapter_tv3;
        public TextView boutique_adapter_tv4;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.boutique_adapter_img = (ImageView) rootView.findViewById(R.id.boutique_adapter_img);
            this.boutique_adapter_tv1 = (TextView) rootView.findViewById(R.id.boutique_adapter_tv1);
            this.boutique_adapter_img2 = (ImageView) rootView.findViewById(R.id.boutique_adapter_img2);
            this.boutique_adapter_tv2 = (TextView) rootView.findViewById(R.id.boutique_adapter_tv2);
            this.boutique_adapter_img3 = (TextView) rootView.findViewById(R.id.boutique_adapter_img3);
            this.boutique_adapter_tv3 = (TextView) rootView.findViewById(R.id.boutique_adapter_tv3);
            this.boutique_adapter_tv4 = (TextView) rootView.findViewById(R.id.boutique_adapter_tv4);
        }

    }
}
