package com.ysd.keepcar.view.home;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.youth.banner.Banner;
import com.ysd.keepcar.R;
import com.ysd.keepcar.app.BaseFragment;
import com.ysd.keepcar.utils.GlideImageLoader;
import com.ysd.keepcar.utils.OkhttpUtil;
import com.ysd.keepcar.utils.UrlPath;
import com.ysd.keepcar.view.home.activity.ActivityActivity;
import com.ysd.keepcar.view.home.activity.BoutiqueActivity;
import com.ysd.keepcar.view.home.activity.ExhibitionActivity;
import com.ysd.keepcar.view.home.activity.MaintainActivity;
import com.ysd.keepcar.view.home.activity.QueryActivity;
import com.ysd.keepcar.view.home.activity.RenewalActivity;
import com.ysd.keepcar.view.home.activity.RepairActivity;
import com.ysd.keepcar.view.home.activity.RescueActivity;
import com.ysd.keepcar.view.home.activity.ShoppingMallActivity;
import com.ysd.keepcar.view.home.activity.WashCarActivity;
import com.ysd.keepcar.view.home.adapter.HomeListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class HomeFragment extends BaseFragment implements View.OnClickListener{

    ListView listView;
    private ArrayList<String> arrayList;
    private ViewHolder vh;
    private ArrayList<String> imgList;

    @Override
    public int getInitId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View view) {
        listView = view.findViewById(R.id.home_list);
        View viewTop = LayoutInflater.from(getActivity()).inflate(R.layout.hometop_item, null);
        vh = new ViewHolder(viewTop);
        listView.addHeaderView(viewTop);
    }

    @Override
    public void initData() {
        OkhttpUtil.getInstance().post((UrlPath.URLPATHAPP + UrlPath.URLPATHBANNER), null, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
//              Log.e("---HomeFragment---",str+"     "+jsonArray.length());
                imgList = new ArrayList<>();
                try {
                    JSONObject jsonObject = new JSONObject(string);
                    int code = jsonObject.getInt("code");
                    if (code == 200) {
                        JSONArray jsonArray = (JSONArray) jsonObject.get("data");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            imgList.add(UrlPath.URLPATHIMG + jsonArray.get(i));
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        vh.hometop_banner.setImages(imgList);
                        vh.hometop_banner.setImageLoader(new GlideImageLoader());
                        vh.hometop_banner.setDelayTime(3000);
                        vh.hometop_banner.start();
                    }
                });
            }
        });
        arrayList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            arrayList.add(i + "");
        }
    }

    @Override
    public void initAdapter() {
        HomeListAdapter homeListAdapter = new HomeListAdapter(getActivity(), arrayList);
        listView.setAdapter(homeListAdapter);
    }

    @Override
    public void initLinstener() {
        vh.hometop_baoyang.setOnClickListener(this);
        vh.hometop_weixiu.setOnClickListener(this);
        vh.hometop_zhanting.setOnClickListener(this);
        vh.hometop_xubao.setOnClickListener(this);
        vh.hometop_jingpin.setOnClickListener(this);
        vh.hometop_xiche.setOnClickListener(this);
        vh.hometop_huodong.setOnClickListener(this);
        vh.hometop_shangchneg.setOnClickListener(this);
        vh.hometop_chaxun.setOnClickListener(this);
        vh.hometop_jiuyuan.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.hometop_baoyang:
                intent.setClass(getActivity(), MaintainActivity.class);
                intent.putExtra("title",vh.hometop_baoyang.getText());
                break;
            case R.id.hometop_weixiu:
                intent.setClass(getActivity(), RepairActivity.class);
                intent.putExtra("title",vh.hometop_weixiu.getText());
                break;
            case R.id.hometop_zhanting:
                intent.setClass(getActivity(), ExhibitionActivity.class);
                intent.putExtra("title",vh.hometop_zhanting.getText());
                break;
            case R.id.hometop_xubao:
                intent.setClass(getActivity(), RenewalActivity.class);
                intent.putExtra("title",vh.hometop_xubao.getText());
                break;
            case R.id.hometop_jingpin:
                intent.setClass(getActivity(), BoutiqueActivity.class);
                intent.putExtra("title",vh.hometop_jingpin.getText());
                break;
            case R.id.hometop_xiche:
                intent.setClass(getActivity(), WashCarActivity.class);
                intent.putExtra("title",vh.hometop_xiche.getText());
                break;
            case R.id.hometop_huodong:
                intent.setClass(getActivity(), ActivityActivity.class);
                intent.putExtra("title",vh.hometop_huodong.getText());
                break;
            case R.id.hometop_shangchneg:
                intent.setClass(getActivity(), ShoppingMallActivity.class);
                intent.putExtra("title",vh.hometop_shangchneg.getText());
                break;
            case R.id.hometop_chaxun:
                intent.setClass(getActivity(), QueryActivity.class);
                intent.putExtra("title",vh.hometop_chaxun.getText());
                break;
            case R.id.hometop_jiuyuan:
                intent.setClass(getActivity(), RescueActivity.class);
                intent.putExtra("title",vh.hometop_jiuyuan.getText());
                break;
        }
        startActivity(intent);
    }

    public static class ViewHolder {
        public View rootView;
        public Banner hometop_banner;
        public TextView hometop_baoyang;
        public TextView hometop_weixiu;
        public TextView hometop_zhanting;
        public TextView hometop_xubao;
        public TextView hometop_jingpin;
        public TextView hometop_xiche;
        public TextView hometop_huodong;
        public TextView hometop_shangchneg;
        public TextView hometop_chaxun;
        public TextView hometop_jiuyuan;
        public FrameLayout hometop_lunhua;
        public ImageView hometop_maizeng;
        public ImageView hometop_miaosha;
        public ImageView hometop_qianggou;
        public ImageView hometop_tuangou;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.hometop_banner = (Banner) rootView.findViewById(R.id.hometop_banner);
            this.hometop_baoyang = (TextView) rootView.findViewById(R.id.hometop_baoyang);
            this.hometop_weixiu = (TextView) rootView.findViewById(R.id.hometop_weixiu);
            this.hometop_zhanting = (TextView) rootView.findViewById(R.id.hometop_zhanting);
            this.hometop_xubao = (TextView) rootView.findViewById(R.id.hometop_xubao);
            this.hometop_jingpin = (TextView) rootView.findViewById(R.id.hometop_jingpin);
            this.hometop_xiche = (TextView) rootView.findViewById(R.id.hometop_xiche);
            this.hometop_huodong = (TextView) rootView.findViewById(R.id.hometop_huodong);
            this.hometop_shangchneg = (TextView) rootView.findViewById(R.id.hometop_shangchneg);
            this.hometop_chaxun = (TextView) rootView.findViewById(R.id.hometop_chaxun);
            this.hometop_jiuyuan = (TextView) rootView.findViewById(R.id.hometop_jiuyuan);
            this.hometop_lunhua = (FrameLayout) rootView.findViewById(R.id.hometop_lunhua);
            this.hometop_maizeng = (ImageView) rootView.findViewById(R.id.hometop_maizeng);
            this.hometop_miaosha = (ImageView) rootView.findViewById(R.id.hometop_miaosha);
            this.hometop_qianggou = (ImageView) rootView.findViewById(R.id.hometop_qianggou);
            this.hometop_tuangou = (ImageView) rootView.findViewById(R.id.hometop_tuangou);
        }

    }
}
