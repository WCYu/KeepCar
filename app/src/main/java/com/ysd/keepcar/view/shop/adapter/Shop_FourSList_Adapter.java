package com.ysd.keepcar.view.shop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ysd.keepcar.R;
import com.ysd.keepcar.app.BaseActivity;
import com.ysd.keepcar.view.shop.entity.FourSList_Bean;

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
public class Shop_FourSList_Adapter extends BaseAdapter {
    private List<FourSList_Bean.DataBean.ListBean> list;
    private Context context;

    public Shop_FourSList_Adapter(List<FourSList_Bean.DataBean.ListBean> data, BaseActivity baseActivity) {

        this.list = data;
        this.context = baseActivity;

    }

    @Override
    public int getCount() {
        return list.size();
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
        ViewFourListHolder viewFourListHolder;
        if (null == view) {
            viewFourListHolder = new ViewFourListHolder();
            view = LayoutInflater.from(context).inflate(R.layout.shop_fourslist_adapter, null);
            viewFourListHolder.mTvShopName = view.findViewById(R.id.tv_shopName);
            viewFourListHolder.mTvShopAddress = view.findViewById(R.id.tv_shopAddress);
            viewFourListHolder.mImgShopLogo = view.findViewById(R.id.img_shopLogo);

            view.setTag(viewFourListHolder);
        } else {
            viewFourListHolder = (ViewFourListHolder) view.getTag();

        }
        viewFourListHolder.mTvShopName.setText(list.get(i).getShopName());
        viewFourListHolder.mTvShopAddress.setText(list.get(i).getProvinceName()+list.get(i).getCityName());
        Glide.with(context).load("http://39.106.173.47:8080/app"+list.get(i).getLogo()).into(viewFourListHolder.mImgShopLogo);
        return view;
    }

    class ViewFourListHolder {
        TextView mTvShopName;
        TextView mTvShopAddress;
        ImageView mImgShopLogo;



    }
}

