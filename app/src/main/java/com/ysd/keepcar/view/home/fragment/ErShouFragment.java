package com.ysd.keepcar.view.home.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.app.BaseFragment;
import com.ysd.keepcar.view.home.activity.exhibition.ErShouCarActivity;
import com.ysd.keepcar.view.home.activity.exhibition.XinCarInfoActivity;
import com.ysd.keepcar.view.home.adapter.XinCarAdapter;

import java.util.ArrayList;

public class ErShouFragment extends BaseFragment {

    private ArrayList<String> arrayList;

    ListView listView;
    @Override
    public int getInitId() {
        return R.layout.fragment_er_shou;
    }

    @Override
    public void initView(View view) {
        listView=view.findViewById(R.id.er_shou_list);
    }

    @Override
    public void initData() {
        arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrayList.add("二手车");
        }
    }

    @Override
    public void initAdapter() {
        XinCarAdapter xinCarAdapter=new XinCarAdapter(getActivity(),arrayList);
        listView.setAdapter(xinCarAdapter);
    }

    @Override
    public void initLinstener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in=new Intent(getActivity(), ErShouCarActivity.class);
                startActivity(in);
            }
        });
    }

}
