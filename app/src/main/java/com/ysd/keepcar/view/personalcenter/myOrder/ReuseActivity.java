package com.ysd.keepcar.view.personalcenter.myOrder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.app.BaseActivity;
import com.ysd.keepcar.custom.CustomTool;

public class ReuseActivity extends BaseActivity implements View.OnClickListener {

    private CustomTool toll_reuse;
    private TextView bianhao_reuse;
    private TextView riqi_reuse;
    private TextView leixing_reuse;
    private TextView zhuangtai_reuse;
    private TextView heji_reuse;
    private TextView yizhifu_reuse;
    private TextView weizhifu_reuse;
    private TextView peisongfangshi_reuse;
    private TextView yueding_reuse;
    private TextView shouhuoren_reuse;
    private TextView shouji_reuse;
    private TextView dizhi_reuse;
    private TextView dianming_reuse;
    private TextView dizhi1_reuse;
    private TextView dianhua_reuse;
    private TextView name_reuse;
    private TextView shoujihao_reuse;
    private TextView chepai_reuse;
    private TextView chexing_reuse;
    private Button but_reuse;
    @Override
    public int getInitId() {
        return R.layout.activity_reuse;
    }

    public void initView() {
        toll_reuse = (CustomTool) findViewById(R.id.toll_reuse);
        bianhao_reuse = (TextView) findViewById(R.id.bianhao_reuse);
        riqi_reuse = (TextView) findViewById(R.id.riqi_reuse);
        leixing_reuse = (TextView) findViewById(R.id.leixing_reuse);
        zhuangtai_reuse = (TextView) findViewById(R.id.zhuangtai_reuse);
        heji_reuse = (TextView) findViewById(R.id.heji_reuse);
        yizhifu_reuse = (TextView) findViewById(R.id.yizhifu_reuse);
        weizhifu_reuse = (TextView) findViewById(R.id.weizhifu_reuse);
        peisongfangshi_reuse = (TextView) findViewById(R.id.peisongfangshi_reuse);
        yueding_reuse = (TextView) findViewById(R.id.yueding_reuse);
        shouhuoren_reuse = (TextView) findViewById(R.id.shouhuoren_reuse);
        shouji_reuse = (TextView) findViewById(R.id.shouji_reuse);
        dizhi_reuse = (TextView) findViewById(R.id.dizhi_reuse);
        dianming_reuse = (TextView) findViewById(R.id.dianming_reuse);
        dizhi1_reuse = (TextView) findViewById(R.id.dizhi1_reuse);
        dianhua_reuse = (TextView) findViewById(R.id.dianhua_reuse);
        name_reuse = (TextView) findViewById(R.id.name_reuse);
        shoujihao_reuse = (TextView) findViewById(R.id.shoujihao_reuse);
        chepai_reuse = (TextView) findViewById(R.id.chepai_reuse);
        chexing_reuse = (TextView) findViewById(R.id.chexing_reuse);
        but_reuse = (Button) findViewById(R.id.but_reuse);

        toll_reuse.setAppTitle("我的订单");
        toll_reuse.initViewsVisible(true,false,true,false,false);
        ImageView return_img = toll_reuse.findViewById(R.id.Return_img);
        return_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        but_reuse.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initAdapter() {

    }

    @Override
    public void initLinstener() {

    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_reuse:

                break;
        }
    }
}
