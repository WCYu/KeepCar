package com.ysd.keepcar.view.home;

import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.ysd.keepcar.R;
import com.ysd.keepcar.app.AppService;
import com.ysd.keepcar.app.BaseFragment;
import com.ysd.keepcar.entity.ReMenBean;
import com.ysd.keepcar.utils.GlideImageLoader;
import com.ysd.keepcar.utils.MySharedPreferences;
import com.ysd.keepcar.utils.OkhttpUtil;
import com.ysd.keepcar.utils.UrlPath;
import com.ysd.keepcar.utils.ZJson;
import com.ysd.keepcar.view.HomeActivity;
import com.ysd.keepcar.view.home.activity.ActivityActivity;
import com.ysd.keepcar.view.home.activity.BoutiqueActivity;
import com.ysd.keepcar.view.home.activity.exhibition.ExhibitionActivity;
import com.ysd.keepcar.view.home.activity.MaintainActivity;
import com.ysd.keepcar.view.home.activity.QueryActivity;
import com.ysd.keepcar.view.home.activity.RenewalActivity;
import com.ysd.keepcar.view.home.activity.RepairActivity;
import com.ysd.keepcar.view.home.activity.RescueActivity;
import com.ysd.keepcar.view.home.activity.integrashop.ShoppingMallActivity;
import com.ysd.keepcar.view.home.activity.washcar.WashCarActivity;
import com.ysd.keepcar.view.home.adapter.HomeListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class HomeFragment extends BaseFragment implements View.OnClickListener {

    ListView listView;
    private ViewHolder vh;
    private ArrayList<String> imgList;
    private TextView cityName;
    private List<ReMenBean.DataBean> data;
    private int cityId;
    private String userId;

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
        progress();
    }

    @Override
    public void onResume() {
        super.onResume();
        remen();
    }

    @Override
    public void initData() {
        getBannerImg();
        userId = MySharedPreferences.getInstance().getUserId();
        if (userId != null) {
            gunDongTiao(userId);
        }
    }

    //滚动条信息
    private void gunDongTiao(String data) {
        Map map = new HashMap();
        map.put("tk", data);
        map.put("type", 0);
        String jsonMap = ZJson.toJSONMap(map);
        OkhttpUtil.getInstance().post((UrlPath.URLPATHAPP + UrlPath.URLGUNDONGTIAO), jsonMap, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
//                Log.e("--滚动条信息-HomeFragment---", string);
            }
        });
    }

    //热门
    private void remen() {
        Map map = new HashMap();
        HomeActivity homeActivity = (HomeActivity) getActivity();
        cityId = homeActivity.cityId;
        map.put("cityId", cityId);
//        Log.e("--热门-HomeFragment---", cityId + "cityId");
        String jsonMap = ZJson.toJSONMap(map);
        OkhttpUtil.getInstance().post((UrlPath.URLPATHAPP + UrlPath.URLREMEN), jsonMap, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
//                Log.e("--热门-HomeFragment---", string);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        ReMenBean reMenBean = gson.fromJson(string, ReMenBean.class);
                        data = reMenBean.getData();
                        if (data != null) {
                            HomeListAdapter homeListAdapter = new HomeListAdapter(getActivity(), (ArrayList<ReMenBean.DataBean>) data);
                            listView.setAdapter(homeListAdapter);
                            progressDialog.dismiss();
                        }
                    }
                });
            }
        });
    }

    //获得引导页图片
    private void getBannerImg() {
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
    }

    @Override
    public void initAdapter() {

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
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.hometop_baoyang:
                intent.setClass(getActivity(), MaintainActivity.class);
                intent.putExtra("title", "4S店保养");
                break;
            case R.id.hometop_weixiu:
                intent.setClass(getActivity(), RepairActivity.class);
                intent.putExtra("title", "4S店维修");
                break;
            case R.id.hometop_zhanting:
                intent.setClass(getActivity(), ExhibitionActivity.class);
                intent.putExtra("title", "4S店展厅");
                break;
            case R.id.hometop_xubao:
                intent.setClass(getActivity(), RenewalActivity.class);
                intent.putExtra("title", "4S店续保");
                break;
            case R.id.hometop_jingpin:
                intent.setClass(getActivity(), BoutiqueActivity.class);
                intent.putExtra("title", "4S店精品");
                break;
            case R.id.hometop_xiche:
                intent.setClass(getActivity(), WashCarActivity.class);
                intent.putExtra("title", "洗车");
                break;
            case R.id.hometop_huodong:
                intent.setClass(getActivity(), ActivityActivity.class);
                intent.putExtra("title", "精彩活动");
                intent.putExtra("cityId", cityId);
                intent.putExtra("tk", userId);
                break;
            case R.id.hometop_shangchneg:
                intent.setClass(getActivity(), ShoppingMallActivity.class);
                intent.putExtra("cityId", cityId);
                intent.putExtra("tk", userId);
                intent.putExtra("title", "积分商城");
                break;
            case R.id.hometop_chaxun:
                intent.setClass(getActivity(), QueryActivity.class);
                intent.putExtra("title", "违章查询");
                break;
            case R.id.hometop_jiuyuan:
                intent.setClass(getActivity(), RescueActivity.class);
                intent.putExtra("title", "道路救援");
                break;
        }
        startActivity(intent);
    }

    public static class ViewHolder {
        public View rootView;
        public Banner hometop_banner;
        public LinearLayout hometop_baoyang;
        public LinearLayout hometop_weixiu;
        public LinearLayout hometop_zhanting;
        public LinearLayout hometop_xubao;
        public LinearLayout hometop_jingpin;
        public LinearLayout hometop_xiche;
        public LinearLayout hometop_huodong;
        public LinearLayout hometop_shangchneg;
        public LinearLayout hometop_chaxun;
        public LinearLayout hometop_jiuyuan;
        public LinearLayout hometop_lunhua;
        public ImageView hometop_maizeng;
        public ImageView hometop_miaosha;
        public ImageView hometop_qianggou;
        public ImageView hometop_tuangou;
        public ImageView hometop_lunhua_img;
        public TextView hometop_lunhua_tv1;
        public TextView hometop_lunhua_tv2;
        public TextView hometop_lunhua_tv3;
        public TextView hometop_lunhua_tv4;
        public TextView hometop_lunhua_tv5;
        public ImageView hometop_lunhua_imgicon;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.hometop_banner = (Banner) rootView.findViewById(R.id.hometop_banner);
            this.hometop_baoyang = (LinearLayout) rootView.findViewById(R.id.hometop_baoyang);
            this.hometop_weixiu = (LinearLayout) rootView.findViewById(R.id.hometop_weixiu);
            this.hometop_zhanting = (LinearLayout) rootView.findViewById(R.id.hometop_zhanting);
            this.hometop_xubao = (LinearLayout) rootView.findViewById(R.id.hometop_xubao);
            this.hometop_jingpin = (LinearLayout) rootView.findViewById(R.id.hometop_jingpin);
            this.hometop_xiche = (LinearLayout) rootView.findViewById(R.id.hometop_xiche);
            this.hometop_huodong = (LinearLayout) rootView.findViewById(R.id.hometop_huodong);
            this.hometop_shangchneg = (LinearLayout) rootView.findViewById(R.id.hometop_shangchneg);
            this.hometop_chaxun = (LinearLayout) rootView.findViewById(R.id.hometop_chaxun);
            this.hometop_jiuyuan = (LinearLayout) rootView.findViewById(R.id.hometop_jiuyuan);
            this.hometop_lunhua = (LinearLayout) rootView.findViewById(R.id.hometop_lunhua);
            this.hometop_maizeng = (ImageView) rootView.findViewById(R.id.hometop_maizeng);
            this.hometop_miaosha = (ImageView) rootView.findViewById(R.id.hometop_miaosha);
            this.hometop_qianggou = (ImageView) rootView.findViewById(R.id.hometop_qianggou);
            this.hometop_tuangou = (ImageView) rootView.findViewById(R.id.hometop_tuangou);
        }

    }
}
