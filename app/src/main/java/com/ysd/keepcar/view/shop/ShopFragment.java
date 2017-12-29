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
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.gjiazhe.wavesidebar.WaveSideBar;
import com.ysd.keepcar.R;
import com.ysd.keepcar.app.AppService;
import com.ysd.keepcar.app.BaseFragment;
import com.ysd.keepcar.utils.OkhttpUtil;
import com.ysd.keepcar.utils.UrlPath;
import com.ysd.keepcar.utils.ZJson;
import com.ysd.keepcar.view.shop.activity.ShopActivity;
import com.ysd.keepcar.view.shop.adapter.Shop_Popuwindow1_Adapter;
import com.ysd.keepcar.view.shop.entity.Contact;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
    private ArrayList<Contact> contacts;
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
        shop_group = view.findViewById(R.id.shop_group);

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
                        if (radiobut_Brand.isChecked()) {
                            View vicinityView = LayoutInflater.from(AppService.baseActivity).inflate(R.layout.shop_popup_window1, null);
                            initPettypeView1(vicinityView);
                            popupWindow1(vicinityView);
                        }
                        break;
                    case R.id.radiobut_Storefront:
                        if (radiobut_Storefront.isChecked()) {
                            View vicinityView = LayoutInflater.from(AppService.baseActivity).inflate(R.layout.shop_popup_window2, null);
                            initPettypeView(vicinityView);
                            popupWindow2(vicinityView);
                        }
                        break;
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

    @Override
    public void initLinstener() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("subCompanyId", "brand");
        map.put("cityId", "city");
        String string = ZJson.toJSONMap(map);
        OkhttpUtil.getInstance().post(UrlPath.URLPATHAPP + UrlPath.URLFOURSLIEBIAO, string, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {


                Log.e("TAG", response.body().string());
            }
        });
    }

    private void popupWindow1(View vicinityView) {
        popupWindow1 = new PopupWindow(vicinityView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vicinityView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow1.dismiss();
            }
        });


        popupWindow1.setFocusable(true);
        popupWindow1.setWidth(ViewGroup.LayoutParams.FILL_PARENT);
        popupWindow1.setHeight(ViewGroup.LayoutParams.FILL_PARENT);
        popupWindow1.setBackgroundDrawable(new BitmapDrawable());
        popupWindow1.showAsDropDown(radiobut_Brand, 0, 20);
        popupWindow1.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

                shop_group.clearCheck();


            }
        });


    }

    private void initPettypeView1(View vicinityView) {
        recycler_view = (RecyclerView) vicinityView.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AppService.baseActivity);
        recycler_view.setLayoutManager(linearLayoutManager);
        contacts = new ArrayList<>();

        Shop_Popuwindow1_Adapter myAdapter = new Shop_Popuwindow1_Adapter(contacts, AppService.baseActivity);
        recycler_view.setAdapter(myAdapter);

        Log.e("TAG", myAdapter + "");
        WaveSideBar waveSideBar = (WaveSideBar) vicinityView.findViewById(R.id.side_bar);
        waveSideBar.setTextColor(Color.BLACK);
        waveSideBar.setMaxOffset(10);//字母偏移量
        waveSideBar.setPosition(WaveSideBar.POSITION_RIGHT);//侧边栏在左边还是右边
        waveSideBar.setLazyRespond(true);//false:列表随侧边栏的滚动滚动
        waveSideBar.setOnSelectIndexItemListener(this);

        contacts.addAll(Contact.getEnglishContacts());

    }

    @Override
    public void onSelectIndexItem(String index) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getIndex().equals(index)) {
                ((LinearLayoutManager) recycler_view.getLayoutManager()).scrollToPositionWithOffset(i, 0);
                return;
            }
        }

    }

    //初始化PopupWindow
    private void popupWindow2(View vicinityView) {


        popupWindow = new PopupWindow(vicinityView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vicinityView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        popupWindow.setFocusable(true);
        popupWindow.setWidth(ViewGroup.LayoutParams.FILL_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.FILL_PARENT);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.showAsDropDown(radiobut_Brand, 0, 20);
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
                        startActivity(new Intent(AppService.baseActivity, ShopActivity.class));
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
