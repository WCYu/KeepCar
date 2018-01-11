package com.ysd.keepcar.view.home.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.gson.Gson;
import com.ysd.keepcar.R;
import com.ysd.keepcar.app.BaseFragment;
import com.ysd.keepcar.utils.OkhttpUtil;
import com.ysd.keepcar.utils.UrlPath;
import com.ysd.keepcar.utils.ZJson;
import com.ysd.keepcar.view.home.activity.exhibition.XinCarInfoActivity;
import com.ysd.keepcar.view.home.adapter.XinCarAdapter;
import com.ysd.keepcar.view.home.bean.NewCarBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class XinCarFragment extends BaseFragment {

    ListView listView;
    private ArrayList<NewCarBean.DataBean.ListBean> arrayList = new ArrayList<>();;
    private RadioButton XinCar_brand;
    private RadioButton XinCar_sort;
    private RadioGroup XinCar_group;
    private XinCarAdapter xinCarAdapter;

    @Override
    public int getInitId() {
        return R.layout.fragment_xin_car;
    }

    @Override
    public void initView(View view) {
        progress();
        listView = view.findViewById(R.id.XinCar_list);
        XinCar_group = view.findViewById(R.id.XinCar_group);
        XinCar_brand = view.findViewById(R.id.XinCar_brand);
        XinCar_sort = view.findViewById(R.id.XinCar_sort);
    }

    @Override
    public void initData() {
        Map map=new HashMap();
        map.put("brandId","品牌不限");
        map.put("sortType","默认排序");
        map.put("pageNum",0);
        map.put("pageSize",10);
        String jsonMap = ZJson.toJSONMap(map);
        OkhttpUtil.getInstance().post((UrlPath.URLPATHAPP+UrlPath.URLNEWCHE), jsonMap, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("---XinCarFragment---",string);
                Gson gson=new Gson();
                NewCarBean newCarBean = gson.fromJson(string, NewCarBean.class);
                List<NewCarBean.DataBean.ListBean> listBeans = newCarBean.getData().getList();
                arrayList.addAll(listBeans);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        xinCarAdapter.notifyDataSetChanged();
                        progressDialog.dismiss();
                    }
                });
            }
        });
    }

    @Override
    public void initAdapter() {
        xinCarAdapter = new XinCarAdapter(getActivity(), arrayList);
        listView.setAdapter(xinCarAdapter);
    }

    @Override
    public void initLinstener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in=new Intent(getActivity(), XinCarInfoActivity.class);
                startActivity(in);
            }
        });
    }

}
