package com.ysd.keepcar.view.home.activity.washcar;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.gson.Gson;
import com.ysd.keepcar.R;
import com.ysd.keepcar.app.BaseActivity;
import com.ysd.keepcar.custom.CustomTool;
import com.ysd.keepcar.utils.OkhttpUtil;
import com.ysd.keepcar.utils.UrlPath;
import com.ysd.keepcar.utils.ZJson;
import com.ysd.keepcar.view.home.adapter.WashCarAdapter;
import com.ysd.keepcar.view.home.bean.WashCarBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

//洗车Activity
public class WashCarActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    CustomTool customTool;
    private ToggleButton dianpu_washcar;
    private ToggleButton paixu_washcar;
    private LinearLayout linear_washcar;
    private PopupWindow popu1;
    ListView listView;
    private View v1;

    ArrayList<WashCarBean.DataBean.ListBean> arrayList=new ArrayList();
    private WashCarAdapter washCarAdapter;

    @Override
    public int getInitId() {
        return R.layout.activity_wash_car;
    }

    @Override
    public void initView() {
        progress();
        customTool = findViewById(R.id.washcar_custom);
        dianpu_washcar = findViewById(R.id.dianpu_washcar);
        paixu_washcar = findViewById(R.id.paixu_washcar);
        linear_washcar = findViewById(R.id.linear_washcar);
        listView = findViewById(R.id.washcar_list);
        dianpu_washcar.setOnCheckedChangeListener(this);
        paixu_washcar.setOnCheckedChangeListener(this);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        customTool.setAppTitle(title);
        getData();
    }

    private void getData() {
        Map map=new HashMap();
//        map.put("cityId","");
//        map.put("tk","");
        map.put("shopCode","店面不限");
        map.put("sortType","默认排序");
        map.put("pageNum",0);
        map.put("pageSize",10);
        String jsonMap = ZJson.toJSONMap(map);
        OkhttpUtil.getInstance().post((UrlPath.URLPATHAPP+UrlPath.URLWASHCAR), jsonMap, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson=new Gson();
                WashCarBean washCarBean = gson.fromJson(string, WashCarBean.class);
                final List<WashCarBean.DataBean.ListBean> list = washCarBean.getData().getList();
                arrayList.addAll(list);
//                Log.e("---WashCarActivity---",string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(arrayList!=null){
                            washCarAdapter.notifyDataSetChanged();
                            progressDialog.dismiss();
                        }
                    }
                });
            }
        });
    }

    @Override
    public void initAdapter() {
        washCarAdapter = new WashCarAdapter(arrayList,this);
        listView.setAdapter(washCarAdapter);
    }

    @Override
    public void initLinstener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(WashCarActivity.this,WashShopActivity.class);
                startActivity(intent);
            }
        });
    }

    //头标签
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


    //弹出popu
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.dianpu_washcar:
                if (isChecked){
                    Toast.makeText(this, "111", Toast.LENGTH_SHORT).show();
                    //显示popuwindow
                    v1 = LayoutInflater.from(WashCarActivity.this).inflate(R.layout.popu1_layout, null);
                    //创建一个popuwindow对象
                    popu1 = new PopupWindow(v1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    //默认获取不到焦点，设置获取焦点
                    popu1.setFocusable(true);
                    //点击窗口以外区域，窗口消失
                    popu1.setBackgroundDrawable(new BitmapDrawable());
                    //弹出或者消失的时候带动画效果
//                popu.setAnimationStyle(R.style.mypopu);
                    //显示popuwindow
                    popu1.showAsDropDown(linear_washcar,0, 0);
                    popu1.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            dianpu_washcar.setChecked(false);
                        }
                    });
                    RadioButton buxian_washcar = v1.findViewById(R.id.buxian_washcar);
                    RadioButton quanbu_washcar = v1.findViewById(R.id.quanbu_washcar);
                    RadioButton huiyuan_washcar = v1.findViewById(R.id.huiyuan_washcar);
                    RadioButton pinpai_washcar = v1.findViewById(R.id.pinpai_washcar);
                    RadioButton lishi_washcar = v1.findViewById(R.id.lishi_washcar);

                    buxian_washcar.setOnClickListener(this);
                    quanbu_washcar.setOnClickListener(this);
                    huiyuan_washcar.setOnClickListener(this);
                    pinpai_washcar.setOnClickListener(this);
                    lishi_washcar.setOnClickListener(this);
                }
                    break;
            case R.id.paixu_washcar:
                if (isChecked){
                    Toast.makeText(this, "111", Toast.LENGTH_SHORT).show();
                    //显示popuwindow
                    v1 = LayoutInflater.from(WashCarActivity.this).inflate(R.layout.popu2_layout, null);
                    //创建一个popuwindow对象
                    popu1 = new PopupWindow(v1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    //默认获取不到焦点，设置获取焦点
                    popu1.setFocusable(true);
                    //点击窗口以外区域，窗口消失
                    popu1.setBackgroundDrawable(new BitmapDrawable());
                    //弹出或者消失的时候带动画效果
//                popu.setAnimationStyle(R.style.mypopu);
                    //显示popuwindow
                    popu1.showAsDropDown(linear_washcar,0, 0);
                    popu1.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            paixu_washcar.setChecked(false);
                        }
                    });

                    RadioButton moren_washcar = v1.findViewById(R.id.moren_washcar);
                    RadioButton juli_washcar = v1.findViewById(R.id.juli_washcar);
                    RadioButton pingjia_washcar = v1.findViewById(R.id.pingjia_washcar);
                    RadioButton jiage_washcar = v1.findViewById(R.id.jiage_washcar);

                    moren_washcar.setOnClickListener(this);
                    juli_washcar.setOnClickListener(this);
                    pingjia_washcar.setOnClickListener(this);
                    jiage_washcar.setOnClickListener(this);
                }
                break;

        }
    }

    //弹出popu菜单点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buxian_washcar:
                Toast.makeText(this, "店面不限", Toast.LENGTH_SHORT).show();
                break;
            case R.id.quanbu_washcar:
                Toast.makeText(this, "全部洗车店", Toast.LENGTH_SHORT).show();
                break;
            case R.id.huiyuan_washcar:
                Toast.makeText(this, "全部会员店", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pinpai_washcar:
                Toast.makeText(this, "品牌4S店", Toast.LENGTH_SHORT).show();
                break;
            case R.id.lishi_washcar:
                Toast.makeText(this, "历史下单店", Toast.LENGTH_SHORT).show();
                break;
            case R.id.moren_washcar:
                Toast.makeText(this, "默认排序", Toast.LENGTH_SHORT).show();
                break;
            case R.id.juli_washcar:
                Toast.makeText(this, "距离最近", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pingjia_washcar:
                Toast.makeText(this, "评价最高", Toast.LENGTH_SHORT).show();
                break;
            case R.id.jiage_washcar:
                Toast.makeText(this, "价格最低", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
