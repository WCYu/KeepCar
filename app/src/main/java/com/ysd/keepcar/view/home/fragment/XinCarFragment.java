package com.ysd.keepcar.view.home.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ysd.keepcar.R;
import com.ysd.keepcar.app.BaseFragment;
import com.ysd.keepcar.view.home.activity.exhibition.XinCarInfoActivity;
import com.ysd.keepcar.view.home.adapter.XinCarAdapter;

import java.util.ArrayList;

public class XinCarFragment extends BaseFragment {

    ListView listView;
    private ArrayList<Object> arrayList;
    private RadioButton XinCar_brand;
    private RadioButton XinCar_sort;
    private RadioGroup XinCar_group;

    @Override
    public int getInitId() {
        return R.layout.fragment_xin_car;
    }

    @Override
    public void initView(View view) {
        listView = view.findViewById(R.id.XinCar_list);
        XinCar_group = view.findViewById(R.id.XinCar_group);
        XinCar_brand = view.findViewById(R.id.XinCar_brand);
        XinCar_sort = view.findViewById(R.id.XinCar_sort);
    }

    @Override
    public void initData() {
        arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrayList.add("新车");
        }
    }

    @Override
    public void initAdapter() {
        XinCarAdapter xinCarAdapter = new XinCarAdapter(getActivity(), arrayList);
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
