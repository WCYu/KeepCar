package com.ysd.keepcar.view.home.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.ysd.keepcar.R;
import com.ysd.keepcar.app.BaseFragment;
import com.ysd.keepcar.utils.OkhttpUtil;
import com.ysd.keepcar.utils.UrlPath;
import com.ysd.keepcar.utils.ZJson;
import com.ysd.keepcar.view.home.activity.exhibition.ErShouCarActivity;
import com.ysd.keepcar.view.home.activity.exhibition.ExhibitionActivity;
import com.ysd.keepcar.view.home.activity.exhibition.XinCarInfoActivity;
import com.ysd.keepcar.view.home.adapter.ErShouFragmentAdapter;
import com.ysd.keepcar.view.home.adapter.XinCarAdapter;
import com.ysd.keepcar.view.home.bean.ErShouFragmentBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ErShouFragment extends BaseFragment {

    private ArrayList<ErShouFragmentBean.DataBean.ListBean> arrayList=new ArrayList<>();

    ListView listView;
    private ErShouFragmentAdapter erShouFragmentAdapter;

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
        getData();
    }

    private void getData() {
        Map map=new HashMap();
        map.put("tk",getArguments().getString("tk"));
        map.put("pageNum",0);
        map.put("pageSize",10);
        map.put("shopCode","店面不限");
        map.put("sortType","默认排序");
//        map.put("brandId","");
//        map.put("carType","");
//        map.put("emissionStandard","");
//        map.put("gearBox","");
//        map.put("displacementBegin","");
//        map.put("displacementEnd","");
        String jsonMap = ZJson.toJSONMap(map);
        OkhttpUtil.getInstance().post((UrlPath.URLPATHAPP+UrlPath.URLERSHOUCHE), jsonMap, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("---ErShouFragment---",string);
                Gson gson=new Gson();
                ErShouFragmentBean erShouFragmentBean = gson.fromJson(string, ErShouFragmentBean.class);
                List<ErShouFragmentBean.DataBean.ListBean> listBeans = erShouFragmentBean.getData().getList();
                arrayList.addAll(listBeans);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        erShouFragmentAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    @Override
    public void initAdapter() {
        erShouFragmentAdapter = new ErShouFragmentAdapter(arrayList,getActivity());
        listView.setAdapter(erShouFragmentAdapter);
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
