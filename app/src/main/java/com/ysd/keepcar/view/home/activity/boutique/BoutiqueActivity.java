package com.ysd.keepcar.view.home.activity.boutique;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ysd.keepcar.R;
import com.ysd.keepcar.app.BaseActivity;
import com.ysd.keepcar.custom.CustomTool;
import com.ysd.keepcar.view.home.adapter.BoutiqueAdapter;

import java.util.ArrayList;

//Boutique精品Activity
public class BoutiqueActivity extends BaseActivity {

    CustomTool customTool;
    private RadioButton boutique_fenlei;
    private RadioButton boutique_dianmian;
    private RadioButton boutique_paixu;
    private RadioGroup boutique_group;
    private GridView boutique_grid;

    @Override
    public int getInitId() {
        return R.layout.activity_boutique;
    }

    @Override
    public void initView() {
        customTool = findViewById(R.id.boutique_custom);
        boutique_fenlei = findViewById(R.id.boutique_fenlei);
        boutique_dianmian = findViewById(R.id.boutique_dianmian);
        boutique_paixu = findViewById(R.id.boutique_paixu);
        boutique_group = findViewById(R.id.boutique_group);
        boutique_grid = findViewById(R.id.boutique_grid);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        customTool.setAppTitle(title);
    }

    @Override
    public void initAdapter() {
        ArrayList arrayList=new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add("展厅");
        }
        BoutiqueAdapter boutiqueAdapter=new BoutiqueAdapter(arrayList,this);
        boutique_grid.setAdapter(boutiqueAdapter);
    }

    @Override
    public void initLinstener() {
        boutique_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(BoutiqueActivity.this,BoutiqueInfoActivity.class);
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
//        customTool.setRightIcon();
    }

}
