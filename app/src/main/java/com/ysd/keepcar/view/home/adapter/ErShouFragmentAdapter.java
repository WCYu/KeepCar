package com.ysd.keepcar.view.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.view.home.bean.ErShouFragmentBean;

import java.util.ArrayList;

/**
 * Created by 阿禹 on 2018/1/11.
 */

public class ErShouFragmentAdapter extends BaseAdapter {
    ArrayList<ErShouFragmentBean.DataBean.ListBean> arrayList;
    Context context;

    public ErShouFragmentAdapter(ArrayList<ErShouFragmentBean.DataBean.ListBean> arrayList, Context context) {
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
        convertView = LayoutInflater.from(context).inflate(R.layout.ershou_list_item, null);
        ViewHolder vh = new ViewHolder(convertView);
        String brandName = arrayList.get(position).getBrandName();
        String seriesName = arrayList.get(position).getSeriesName();
        vh.ershocar_list_item_name.setText(brandName + "+" + seriesName);
        vh.ershocar_list_item_xinghao.setText(arrayList.get(position).getModelName());
        vh.ershocar_list_item_shijian.setText(arrayList.get(position).getBuyDate());
        vh.ershocar_list_item_jiage.setText(arrayList.get(position).getCurrentPrice()+"");
        vh.ershocar_list_item_xincarjiage.setText(arrayList.get(position).getNewCarPrice()+"");
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView exhibition_list_item_icon;
        public TextView ershocar_list_item_name;
        public TextView ershocar_list_item_xinghao;
        public TextView ershocar_list_item_shijian;
        public TextView ershocar_list_item_juli;
        public TextView ershocar_list_item_jiage;
        public TextView ershocar_list_item_xincarjiage;
        public TextView ershocar_list_item_shijia;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.exhibition_list_item_icon = (ImageView) rootView.findViewById(R.id.exhibition_list_item_icon);
            this.ershocar_list_item_name = (TextView) rootView.findViewById(R.id.ershocar_list_item_name);
            this.ershocar_list_item_xinghao = (TextView) rootView.findViewById(R.id.ershocar_list_item_xinghao);
            this.ershocar_list_item_shijian = (TextView) rootView.findViewById(R.id.ershocar_list_item_shijian);
            this.ershocar_list_item_juli = (TextView) rootView.findViewById(R.id.ershocar_list_item_juli);
            this.ershocar_list_item_jiage = (TextView) rootView.findViewById(R.id.ershocar_list_item_jiage);
            this.ershocar_list_item_xincarjiage = (TextView) rootView.findViewById(R.id.ershocar_list_item_xincarjiage);
            this.ershocar_list_item_shijia = (TextView) rootView.findViewById(R.id.ershocar_list_item_shijia);
        }

    }
}
