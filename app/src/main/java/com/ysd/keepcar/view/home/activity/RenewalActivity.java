package com.ysd.keepcar.view.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.app.BaseActivity;
import com.ysd.keepcar.custom.CustomTool;

//Renewal续保Activity
public class RenewalActivity extends BaseActivity implements View.OnClickListener{

    CustomTool customTool;
    private TextView renewal_car;
    private LinearLayout renewal_car_choice;
    private EditText renewal_car_price;
    private TextView renewal_last_insurance;
    private LinearLayout renewal_shangqi;
    private TextView renewal_this_insurance;
    private LinearLayout renewal_benqi;
    private TextView renewal_insurance_type;
    private LinearLayout renewal_xianzhong;
    private CheckBox renewal_select;
    private CheckBox renewal_claim;
    private CheckBox renewal_claim2;
    private Button renewal_claim_btn;

    @Override
    public int getInitId() {
        return R.layout.activity_renewal;
    }

    @Override
    public void initView() {
        customTool = findViewById(R.id.renewal_custom);
        renewal_car = findViewById(R.id.renewal_car);
        renewal_car_choice = findViewById(R.id.renewal_car_choice);
        renewal_car_price = findViewById(R.id.renewal_car_price);
        renewal_last_insurance = findViewById(R.id.renewal_last_insurance);
        renewal_shangqi = findViewById(R.id.renewal_shangqi);
        renewal_this_insurance = findViewById(R.id.renewal_this_insurance);
        renewal_benqi = findViewById(R.id.renewal_benqi);
        renewal_insurance_type = findViewById(R.id.renewal_insurance_type);
        renewal_xianzhong = findViewById(R.id.renewal_xianzhong);
        renewal_select = findViewById(R.id.renewal_select);
        renewal_claim = findViewById(R.id.renewal_claim);
        renewal_claim2 = findViewById(R.id.renewal_claim2);
        renewal_claim_btn = findViewById(R.id.renewal_claim_btn);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        customTool.setAppTitle(title);
    }

    @Override
    public void initAdapter() {

    }

    @Override
    public void initLinstener() {

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

    @Override
    public void onClick(View v) {

    }
}
