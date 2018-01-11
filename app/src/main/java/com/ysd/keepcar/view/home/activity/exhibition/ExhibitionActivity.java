package com.ysd.keepcar.view.home.activity.exhibition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ysd.keepcar.R;
import com.ysd.keepcar.app.BaseActivity;
import com.ysd.keepcar.custom.CustomTool;
import com.ysd.keepcar.view.home.fragment.ErShouFragment;
import com.ysd.keepcar.view.home.fragment.XinCarFragment;

import java.security.PublicKey;

//展厅Activity
public class ExhibitionActivity extends BaseActivity {

    CustomTool customTool;
    private RadioButton exhibition_xin_che;
    private RadioButton exhibition_er_shou;
    private RadioGroup exhibition_group;
    private FrameLayout exhibition_frame;
    private FragmentManager supportFragmentManager;
    private FragmentTransaction transaction;
    private ErShouFragment erShouFragment;
    private XinCarFragment xinCarFragment;
    public String tk;

    @Override
    public int getInitId() {
        return R.layout.activity_exhibition;
    }

    @Override
    public void initView() {
        customTool = findViewById(R.id.exhibition_custom);
        exhibition_xin_che = findViewById(R.id.exhibition_xin_che);
        exhibition_er_shou = findViewById(R.id.exhibition_er_shou);
        exhibition_group = findViewById(R.id.exhibition_group);
        exhibition_frame = findViewById(R.id.exhibition_frame);
        supportFragmentManager = getSupportFragmentManager();
        transaction = supportFragmentManager.beginTransaction();
        erShouFragment = new ErShouFragment();
        xinCarFragment = new XinCarFragment();
        transaction.add(R.id.exhibition_frame, erShouFragment);
        transaction.add(R.id.exhibition_frame, xinCarFragment);
        isCheckFragment(xinCarFragment);
        transaction.commit();
    }

    public void isCheckFragment(Fragment fragment) {
        transaction.hide(erShouFragment);
        transaction.hide(xinCarFragment);
        transaction.show(fragment);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        tk = intent.getStringExtra("tk");
        customTool.setAppTitle(title);
        Bundle bundle=new Bundle();
        bundle.putString("tk",tk);
        erShouFragment.setArguments(bundle);
    }

    @Override
    public void initAdapter() {

    }

    @Override
    public void initLinstener() {
        exhibition_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                transaction = supportFragmentManager.beginTransaction();
                switch (checkedId) {
                    case R.id.exhibition_xin_che:
                        isCheckFragment(xinCarFragment);
                        break;
                    case R.id.exhibition_er_shou:
                        isCheckFragment(erShouFragment);
                        break;
                }
                transaction.commit();
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
