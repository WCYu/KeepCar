package com.ysd.keepcar.view.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ysd.keepcar.R;
import com.ysd.keepcar.view.home.activity.integrashop.ExchangeInfoActivity;
import com.ysd.keepcar.view.home.bean.IntegralBean;

import java.util.ArrayList;

/**
 * Created by 阿禹 on 2018/1/5.
 */

public class IntegralAdapter extends RecyclerView.Adapter<IntegralAdapter.ViewHolder> {

    ArrayList<IntegralBean.DataBean.ListBean> arrayList;
    Context context;

    public IntegralAdapter(ArrayList<IntegralBean.DataBean.ListBean> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.integral_adapter_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.integral_adapter_tv1.setText(arrayList.get(position).getProductType());
        holder.integral_adapter_tv2.setText(arrayList.get(position).getShopName());
        holder.integral_adapter_tv3.setText(arrayList.get(position).getIntegralValue() + "");
//        holder.integral_adapter_tv4.setText(arrayList.get(position)+"");
//        Glide.with(context).load("").into(holder.integral_adapter_img);
//        Glide.with(context).load("").into(holder.integral_adapter_img2);
//        Glide.with(context).load("").into(holder.integral_adapter_img3);
        holder.integral_adapter_lly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ExchangeInfoActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView integral_adapter_img;
        public TextView integral_adapter_tv1;
        public ImageView integral_adapter_img2;
        public TextView integral_adapter_tv2;
        public ImageView integral_adapter_img3;
        public TextView integral_adapter_tv3;
        public TextView integral_adapter_tv4;
        LinearLayout integral_adapter_lly;

        public ViewHolder(View itemView) {
            super(itemView);
            integral_adapter_img = itemView.findViewById(R.id.integral_adapter_img);
            integral_adapter_tv1 = itemView.findViewById(R.id.integral_adapter_tv1);
            integral_adapter_img2 = itemView.findViewById(R.id.integral_adapter_img2);
            integral_adapter_tv2 = itemView.findViewById(R.id.integral_adapter_tv2);
            integral_adapter_img3 = itemView.findViewById(R.id.integral_adapter_img3);
            integral_adapter_tv3 = itemView.findViewById(R.id.integral_adapter_tv3);
            integral_adapter_tv4 = itemView.findViewById(R.id.integral_adapter_tv4);
            integral_adapter_lly = itemView.findViewById(R.id.integral_adapter_lly);
        }
    }
}
