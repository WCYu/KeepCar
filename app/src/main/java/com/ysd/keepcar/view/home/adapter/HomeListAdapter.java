package com.ysd.keepcar.view.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.entity.ReMenBean;

import java.util.ArrayList;

/**
 * Created by 阿禹 on 2017/12/28.
 */

public class HomeListAdapter extends BaseAdapter {

    Context context;
    ArrayList<ReMenBean.DataBean.ListBean> arrayList;

    public HomeListAdapter(Context context, ArrayList<ReMenBean.DataBean.ListBean> arrayList) {
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
        convertView = LayoutInflater.from(context).inflate(R.layout.home_list_item, null);
        ViewHolder viewHolder = new ViewHolder(convertView);

        viewHolder.home_list_item_name.setText(arrayList.get(position).getProductType());
        viewHolder.home_list_item_shop_name.setText(arrayList.get(position).getSalesWays());
        viewHolder.home_list_item_fukuan.setText(arrayList.get(position).getShopName() + "");
        viewHolder.home_list_item_jiage.setText("￥" + arrayList.get(position).getOriginalPrice());
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView home_list_item_icon;
        public TextView home_list_item_name;
        public TextView home_list_item_shop_name;
        public TextView home_list_item_fukuan;
        public TextView home_list_item_jiage;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.home_list_item_icon = (ImageView) rootView.findViewById(R.id.home_list_item_icon);
            this.home_list_item_name = (TextView) rootView.findViewById(R.id.home_list_item_name);
            this.home_list_item_shop_name = (TextView) rootView.findViewById(R.id.home_list_item_shop_name);
            this.home_list_item_fukuan = (TextView) rootView.findViewById(R.id.home_list_item_fukuan);
            this.home_list_item_jiage = (TextView) rootView.findViewById(R.id.home_list_item_jiage);
        }

    }
}
