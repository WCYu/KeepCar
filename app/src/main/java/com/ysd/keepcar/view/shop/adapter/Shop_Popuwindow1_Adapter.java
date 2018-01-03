package com.ysd.keepcar.view.shop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ysd.keepcar.R;
import com.ysd.keepcar.app.BaseActivity;
import com.ysd.keepcar.view.shop.entity.Brand_Bean;

import java.util.List;

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
public class Shop_Popuwindow1_Adapter extends RecyclerView.Adapter<Shop_Popuwindow1_Adapter.ViewHolder> {
    private List<Brand_Bean.DataBean> contacts;
    private Context context;
    private List<Brand_Bean.DataBean.BrandListBean> brandList;
    private View inflate;


    public Shop_Popuwindow1_Adapter(List<Brand_Bean.DataBean> contacts, BaseActivity mainActivity) {

        this.contacts = contacts;
        this.context = mainActivity;
    }

    public interface OnItemClick {
        void OnClick(int layoutPosition);
    }

    public static OnItemClick onItemClick;

    public void SetOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }


    @Override
    public Shop_Popuwindow1_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contacts_right, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Shop_Popuwindow1_Adapter.ViewHolder holder, int position) {
        Brand_Bean.DataBean dataBean = contacts.get(position);
        brandList = dataBean.getBrandList();
        ListView_Adapter listView_adapter = new ListView_Adapter(brandList, context);
        holder.lv_lv.setAdapter(listView_adapter);
        setListViewHeight(holder.lv_lv);
        listView_adapter.notifyDataSetChanged();


    }


    @Override
    public int getItemCount() {
        return contacts.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ListView lv_lv;
        private final LinearLayout linear_layout;


        public ViewHolder(View itemView) {
            super(itemView);

            lv_lv = itemView.findViewById(R.id.lv_lv);
            linear_layout = itemView.findViewById(R.id.linear_layout);
            linear_layout.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {
            onItemClick.OnClick(getLayoutPosition());
        }
    }


    public class ListView_Adapter extends BaseAdapter {


        private List<Brand_Bean.DataBean.BrandListBean> brandList;
        private Context context;

        public ListView_Adapter(List<Brand_Bean.DataBean.BrandListBean> brandList, Context context) {

            this.brandList = brandList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return brandList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ListViewHodler listViewHodler;
            if (null == view) {
                listViewHodler = new ListViewHodler();
                view = LayoutInflater.from(context).inflate(R.layout.item_contacts_right1, null);
                listViewHodler.tv_index = (TextView) view.findViewById(R.id.tv_index);
                listViewHodler.tv_name = (TextView) view.findViewById(R.id.tv_name);
                listViewHodler.image_logo = view.findViewById(R.id.image_logo);

                view.setTag(listViewHodler);
            } else {
                listViewHodler = (ListViewHodler) view.getTag();
            }

            if (i == 0 || !brandList.get(i - 1).getK().equals(brandList.get(i).getK())) {
                listViewHodler.tv_index.setVisibility(View.VISIBLE);
                listViewHodler.tv_index.setText(brandList.get(i).getK());
            } else {
                listViewHodler.tv_index.setVisibility(View.GONE);
            }

            Glide.with(context).load("http://39.106.173.47:8080/app" + brandList.get(i).getLogo()).into(listViewHodler.image_logo);
            listViewHodler.tv_name.setText(brandList.get(i).getValue());


            return view;
        }
    }

    class ListViewHodler {

        private TextView tv_index;
        private TextView tv_name;
        private ImageView image_logo;
    }

    //重新测量ListView 的高度
    public static void setListViewHeight(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(1, 1);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams par = listView.getLayoutParams();
        par.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1))
                + listView.getPaddingTop() + listView.getPaddingBottom();
        listView.setLayoutParams(par);
    }
}
