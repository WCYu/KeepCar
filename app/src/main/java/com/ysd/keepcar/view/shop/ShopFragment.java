package com.ysd.keepcar.view.shop;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gjiazhe.wavesidebar.WaveSideBar;
import com.google.gson.Gson;
import com.ysd.keepcar.R;
import com.ysd.keepcar.app.AppService;
import com.ysd.keepcar.app.BaseFragment;
import com.ysd.keepcar.utils.OkhttpUtil;
import com.ysd.keepcar.utils.UrlPath;
import com.ysd.keepcar.utils.ZJson;
import com.ysd.keepcar.view.shop.activity.Four_S_ShopActivity;
import com.ysd.keepcar.view.shop.adapter.Shop_FourSList_Adapter;
import com.ysd.keepcar.view.shop.adapter.Shop_Popuwindow1_Adapter;
import com.ysd.keepcar.view.shop.entity.Brand_Bean;
import com.ysd.keepcar.view.shop.entity.FourSList_Bean;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * <p>
 * 4S店
 */
public class ShopFragment extends BaseFragment implements WaveSideBar.OnSelectIndexItemListener {

    private RadioButton radiobut_Brand;
    private RadioButton radiobut_Storefront;
    private RadioButton radiobut_sort;
    private RadioGroup shop_group;
    private ListView lv_listview;
    private PopupWindow popupWindow;
    private RadioButton radiobut_single_store_in_history;
    private RadioButton radiobutMy_member_store;
    private RadioButton radio_storefront;

    private RecyclerView recycler_view;
    private PopupWindow popupWindow1;
    private RadioGroup home_group;

    @Override
    public int getInitId() {
        return R.layout.fragment_shop;
    }

    @Override
    public void initView(View view) {


        // 品牌
        radiobut_Brand = view.findViewById(R.id.radiobut_Brand);
        shop_group = view.findViewById(R.id.shop_group1);
        shop_group = view.findViewById(R.id.shop_group1);

        //店面
        radiobut_Storefront = view.findViewById(R.id.radiobut_Storefront);
        //排序
        radiobut_sort = view.findViewById(R.id.radiobut_sort);
        //listView
        lv_listview = view.findViewById(R.id.lv_listview);

    }

    @Override
    public void initData() {


        shop_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.radiobut_Brand:
                        //Pinpai
                        if (radiobut_Brand.isChecked()) {
                            View vicinityView = LayoutInflater.from(AppService.baseActivity).inflate(R.layout.shop_popup_window1, null);
                            initPettypeView1(vicinityView);
                            popupWindow1(vicinityView);
                        }
                        break;
                    //店面
                    case R.id.radiobut_Storefront:
                        if (radiobut_Storefront.isChecked()) {
                            View vicinityView = LayoutInflater.from(AppService.baseActivity).inflate(R.layout.shop_popup_window2, null);
                            initPettypeView(vicinityView);
                            popupWindow2(vicinityView);
                        }
                        break;
                    //排序
                    case R.id.radiobut_sort:
                        if (radiobut_sort.isChecked()) {
                            View vicinityView = LayoutInflater.from(AppService.baseActivity).inflate(R.layout.shop_popup_window3, null);
                            initPettypeView(vicinityView);
                            popupWindow2(vicinityView);
                        }
                        break;
                }
            }


        });
    }


    @Override
    public void initAdapter() {


    }

    private List<Brand_Bean.DataBean> data;
    private Shop_Popuwindow1_Adapter myAdapter;

    @Override
    public void initLinstener() {

        HashMap<String, Object> map = new HashMap<>();
        map.put("subCompanyId", "brand");
        String string = ZJson.toJSONMap(map);

        OkhttpUtil.getInstance().post(UrlPath.URLPATHAPP + UrlPath.URLFOURSBRAND, null, new Callback() {


            private String string;

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {


                string = response.body().string();


                getActivity().runOnUiThread(new Runnable() {


                    @Override
                    public void run() {
                        Log.e("TAG", "孟" + string);
                        Gson gson = new Gson();
                        Brand_Bean brand_bean = gson.fromJson(string, Brand_Bean.class);
                        data = brand_bean.getData();

                    }
                });

            }
        });

        FourSList();
    }

    private List<FourSList_Bean.DataBean.ListBean> list;

    //4S列表
    private void FourSList() {

        HashMap<String, Object> map = new HashMap<>();
        map.put("cityId", "");
        map.put("tk", "");
        map.put("brandId", "");
        map.put("shopCode", "");
        map.put("sortType", "");
        map.put("latitude", "");
        map.put("longitude", "");
        map.put("pages", "1");
        String string = ZJson.toJSONMap(map);

        OkhttpUtil.getInstance().post(UrlPath.URLPATHAPP + UrlPath.URLFOURSLIEBIAO, string, new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string1 = response.body().string();
//                Log.e("---ShopFragment---", "Meng" + string1);
                Gson gson = new Gson();
                FourSList_Bean fourSList_bean = gson.fromJson(string1, FourSList_Bean.class);
                FourSList_Bean.DataBean data = fourSList_bean.getData();
                list = data.getList();
                final Shop_FourSList_Adapter shop_fourSList_adapter = new Shop_FourSList_Adapter(list, AppService.baseActivity);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (shop_fourSList_adapter != null) {
                            lv_listview.setAdapter(shop_fourSList_adapter);
                        }
                    }
                });
            }
        });


        lv_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(AppService.baseActivity, Four_S_ShopActivity.class);
                intent.putExtra("logo", list.get(i).getLogo());
                intent.putExtra("shopimg", list.get(i).getShopImg());
                intent.putExtra("shopname", list.get(i).getShopName());
                intent.putExtra("provincename", list.get(i).getProvinceName());
                intent.putExtra("cityname", list.get(i).getCityName());
                intent.putExtra("star", list.get(i).getStar());

                startActivity(intent);
            }
        });


    }


    //品牌
    private void initPettypeView1(View vicinityView) {
        recycler_view = (RecyclerView) vicinityView.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AppService.baseActivity);
        recycler_view.setLayoutManager(linearLayoutManager);
        myAdapter = new Shop_Popuwindow1_Adapter(data, AppService.baseActivity);
        recycler_view.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();

        Log.e("TAG", myAdapter + "");

        WaveSideBar waveSideBar = (WaveSideBar) vicinityView.findViewById(R.id.side_bar);
        waveSideBar.setTextColor(Color.BLACK);
        waveSideBar.setMaxOffset(10);//字母偏移量
        waveSideBar.setPosition(WaveSideBar.POSITION_RIGHT);//侧边栏在左边还是右边
        waveSideBar.setLazyRespond(true);//false:列表随侧边栏的滚动滚动
        waveSideBar.setOnSelectIndexItemListener(this);


        //RecyclerView 接口回调
        myAdapter.SetOnItemClick(new Shop_Popuwindow1_Adapter.OnItemClick() {
            @Override
            public void OnClick(int layoutPosition) {

                Toast.makeText(AppService.baseActivity, layoutPosition + "", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    //品牌
    public void onSelectIndexItem(String index) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getInitKey().equals(index)) {
                ((LinearLayoutManager) recycler_view.getLayoutManager()).scrollToPositionWithOffset(i, 0);
                return;
            }
        }

    }

    //品牌
    private void popupWindow1(View vicinityView) {

        popupWindow1 = new PopupWindow(vicinityView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vicinityView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow1.dismiss();
            }
        });


        popupWindow1.setFocusable(true);

        popupWindow1.setBackgroundDrawable(new BitmapDrawable());
        popupWindow1.showAsDropDown(radiobut_Brand, 0, 20);

        popupWindow1.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                shop_group.clearCheck();

            }
        });
    }

    //初始化PopupWindow
    private void popupWindow2(View vicinityView) {


        popupWindow = new PopupWindow(vicinityView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
          vicinityView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        popupWindow.setFocusable(true);

        popupWindow.setBackgroundDrawable(new BitmapDrawable());

        popupWindow.showAsDropDown(shop_group, 0, 30);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

                shop_group.clearCheck();


            }
        });
    }


    private void initPettypeView(View vicinityView) {
        final RadioGroup brand_Group = vicinityView.findViewById(R.id.brand_Group);
        radio_storefront = vicinityView.findViewById(R.id.radio_Storefront);
        radiobutMy_member_store = vicinityView.findViewById(R.id.radiobutMy_member_store);
        radiobut_single_store_in_history = vicinityView.findViewById(R.id.radiobut_Single_store_in_history);

        brand_Group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_Storefront:
                        break;
                    case R.id.radiobutMy_member_store:
                        break;
                    case R.id.radiobut_Single_store_in_history:
                        break;

                }
                popupWindow.dismiss();
            }
        });
    }


}
