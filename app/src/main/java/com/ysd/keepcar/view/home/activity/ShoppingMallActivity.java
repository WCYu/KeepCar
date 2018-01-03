package com.ysd.keepcar.view.home.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ysd.keepcar.R;
import com.ysd.keepcar.app.AppService;
import com.ysd.keepcar.app.BaseActivity;
import com.ysd.keepcar.custom.CustomTool;

//商场Activity
public class ShoppingMallActivity extends BaseActivity {

    CustomTool customTool;
    private RadioGroup shopping_group;
    private RadioButton radiobut_brand;
    private RadioButton radiobut_shopping_brand;
    private RadioButton radiobut_shopping_storefront;
    private RadioButton radiobut_shopping_sort;
    private RecyclerView recycler_shopping_view;
    private PopupWindow popupWindow1;
    private RadioGroup brand_group;
    private RadioButton radio_classification_unlimited;
    private RadioButton radiobut_boutique;
    private RadioButton radiobut_fixed_value_voucher;
    private RadioButton radio_but_yu_e;
    private RadioButton radiobut_project;
    private RadioButton radiobut_car_wash;
    private RadioButton radiobut_whole_vip_store;
    private RadioButton radio_not_limited_to_the_store;

    @Override
    public int getInitId() {
        return R.layout.activity_shopping_mall;
    }

    @Override
    public void initView() {
        customTool = findViewById(R.id.shopping_custom);
        shopping_group = findViewById(R.id.shopping_group);
        radiobut_shopping_brand = findViewById(R.id.radiobut_shopping_Brand);
        radiobut_shopping_storefront = findViewById(R.id.radiobut_shopping_Storefront);
        radiobut_shopping_sort = findViewById(R.id.radiobut_shopping_sort);
        recycler_shopping_view = findViewById(R.id.recycler_shopping_view);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        customTool.setAppTitle(title);


        shopping_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.radiobut_shopping_Brand:
                        if (radiobut_shopping_brand.isChecked()) {
                            View vicinityView = LayoutInflater.from(AppService.baseActivity).inflate(R.layout.shopping_mall_popuwindow_01, null);
                            initPettypeView1(vicinityView);
                            popupWindow1(vicinityView);
                        }
                        break;

                    case R.id.radiobut_shopping_Storefront:
                        if (radiobut_shopping_storefront.isChecked()) {
                            View vicinityView = LayoutInflater.from(AppService.baseActivity).inflate(R.layout.shopping_mall_popuwindow_02, null);
                            initPettypeView2(vicinityView);
                            popupWindow1(vicinityView);
                        }
                        break;

                    case R.id.radiobut_shopping_sort:
                        if (radiobut_shopping_sort.isChecked()) {
                            View vicinityView = LayoutInflater.from(AppService.baseActivity).inflate(R.layout.shopping_mall_popuwindow_03, null);
                            initPettypeView3(vicinityView);
                            popupWindow1(vicinityView);
                        }
                        break;
                }
            }


        });

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

    private void popupWindow1(View vicinityView) {

        popupWindow1 = new PopupWindow(vicinityView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vicinityView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow1.dismiss();
            }
        });


        popupWindow1.setFocusable(true);
        popupWindow1.setWidth(ViewGroup.LayoutParams.FILL_PARENT);
        popupWindow1.setHeight(ViewGroup.LayoutParams.FILL_PARENT);
        popupWindow1.setBackgroundDrawable(new BitmapDrawable());
        popupWindow1.showAsDropDown(radiobut_shopping_brand, 0, 20);

        popupWindow1.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

                shopping_group.clearCheck();

            }
        });


    }

    private void initPettypeView1(View vicinityView) {
        brand_group = vicinityView.findViewById(R.id.brand_Group);
        radio_classification_unlimited = vicinityView.findViewById(R.id.radio_Classification_unlimited);
        radiobut_boutique = vicinityView.findViewById(R.id.radiobut_Boutique);
        radiobut_fixed_value_voucher = vicinityView.findViewById(R.id.radiobut_Fixed_value_Voucher);
        radio_but_yu_e = vicinityView.findViewById(R.id.radio_but_yu_e);
        radiobut_project = vicinityView.findViewById(R.id.radiobut_project);
        radiobut_car_wash = vicinityView.findViewById(R.id.radiobut_Car_Wash);

    }

    private void initPettypeView2(View vicinityView) {
        radio_not_limited_to_the_store = vicinityView.findViewById(R.id.radio_Not_limited_to_the_store);
        radiobut_whole_vip_store = vicinityView.findViewById(R.id.radiobut_whole_VIP_Store);

    }

    private void initPettypeView3(View vicinityView) {


    }


}
