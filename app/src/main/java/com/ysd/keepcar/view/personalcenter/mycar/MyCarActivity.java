package com.ysd.keepcar.view.personalcenter.mycar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.custom.CustomTool;

import java.util.ArrayList;
import java.util.List;

public class MyCarActivity extends AppCompatActivity {

    private CustomTool customTool;
    private CustomTool tool_car;
    private ListView listview_mycar;
    private TextView title_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_car);
        initView();
        initData();
    }

    private void initData() {
    }

    private void initView() {
        tool_car = (CustomTool) findViewById(R.id.tool_car);
        listview_mycar = (ListView) findViewById(R.id.listview_mycar);
        title_tv = tool_car.findViewById(R.id.Title_tv);

        title_tv.setText("选择爱车");
        tool_car.initViewsVisible(true, false, true, false, false);
    }
}
