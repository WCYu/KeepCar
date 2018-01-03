package com.ysd.keepcar.view.home.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.ysd.keepcar.R;
import com.ysd.keepcar.app.BaseActivity;
import com.ysd.keepcar.custom.CustomTool;

//洗车Activity
public class WashCarActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    CustomTool customTool;
    private CustomTool washcar_custom;
    private ToggleButton dianpu_washcar;
    private ToggleButton paixu_washcar;
    private LinearLayout linear_washcar;
    private View v1;
    private PopupWindow popu1;
    private View itme_1;
    private View itme_2;
    private View itme_3;

    @Override
    public int getInitId() {
        return R.layout.activity_wash_car;
    }

    @Override
    public void initView() {
        customTool = findViewById(R.id.washcar_custom);
        dianpu_washcar = findViewById(R.id.dianpu_washcar);
        paixu_washcar = findViewById(R.id.paixu_washcar);
        linear_washcar = findViewById(R.id.linear_washcar);
        itme_1 = findViewById(R.id.itme_1);
        itme_2 = findViewById(R.id.itme_2);
        itme_3 = findViewById(R.id.itme_3);


        dianpu_washcar.setOnCheckedChangeListener(this);
        paixu_washcar.setOnCheckedChangeListener(this);
        itme_1.setOnClickListener(this);
        itme_2.setOnClickListener(this);
        itme_3.setOnClickListener(this);
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
            case R.id.itme_1:
                Intent intent1 = new Intent(WashCarActivity.this,WashShopActivity.class);
                startActivity(intent1);
                break;
            case R.id.itme_2:
                Intent intent2 = new Intent(WashCarActivity.this,WashShopActivity.class);
                startActivity(intent2);
                break;
            case R.id.itme_3:
                Intent intent3 = new Intent(WashCarActivity.this,WashShopActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
