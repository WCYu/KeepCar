package com.ysd.keepcar.view.home.activity.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.gson.Gson;
import com.ysd.keepcar.R;
import com.ysd.keepcar.app.BaseActivity;
import com.ysd.keepcar.custom.CustomTool;
import com.ysd.keepcar.utils.OkhttpUtil;
import com.ysd.keepcar.utils.UrlPath;
import com.ysd.keepcar.utils.ZJson;
import com.ysd.keepcar.view.home.adapter.ActivityAdapter;
import com.ysd.keepcar.view.home.bean.ActivityBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

//活动Activity
public class ActivityActivity extends BaseActivity {

    CustomTool customTool;
    private RadioButton activity_fenlei;
    private RadioButton activity_dianmian;
    private RadioButton activity_paixu;
    private RadioGroup boutique_group;
    private GridView activity_grid;
    private List<ActivityBean.DataBean.ListBean> listBeans;

    @Override
    public int getInitId() {
        return R.layout.activity_activity;
    }

    @Override
    public void initView() {
        customTool = findViewById(R.id.activity_custom);
        activity_fenlei = findViewById(R.id.activity_fenlei);
        activity_dianmian = findViewById(R.id.activity_dianmian);
        activity_paixu = findViewById(R.id.activity_paixu);
        boutique_group = findViewById(R.id.boutique_group);
        activity_grid = findViewById(R.id.activity_grid);
        progress();
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String tk = intent.getStringExtra("tk");
        int cityId = intent.getIntExtra("cityId", 0);
        customTool.setAppTitle(title);
        getData();
    }

    private void getData() {
        Map map = new HashMap();
        map.put("shopCode", "店面不限");
        map.put("sortType", "默认排序");
        map.put("pageSize", 10);
        map.put("pageNum", 0);
        map.put("activeType", "活动不限");
//        map.put("cityId",cityId);
//        map.put(" tk",tk);
        String jsonMap = ZJson.toJSONMap(map);
        OkhttpUtil.getInstance().post((UrlPath.URLPATHAPP + UrlPath.URLACTIVITY), jsonMap, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
//                Log.e("---Activity---",string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        ActivityBean activityBean = gson.fromJson(string, ActivityBean.class);
                        listBeans = activityBean.getData().getList();
                        if (listBeans != null) {
                            ActivityAdapter activityAdapter = new ActivityAdapter((ArrayList<ActivityBean.DataBean.ListBean>) listBeans, ActivityActivity.this);
                            activity_grid.setAdapter(activityAdapter);
                            progressDialog.dismiss();
                        }
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
        activity_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(ActivityActivity.this,ActivityInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initToolBar() {
        customTool.initViewsVisible(true, false, true, false, false);
        customTool.setOnLeftButtonClickListener(new CustomTool.OnLeftButtonClickListener() {
            @Override
            public void onLeftButtonClick(View v) {
                finish();
            }
        });
    }

}
