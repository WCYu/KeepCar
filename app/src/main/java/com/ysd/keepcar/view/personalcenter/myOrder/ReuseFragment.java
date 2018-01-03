package com.ysd.keepcar.view.personalcenter.myOrder;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ysd.keepcar.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReuseFragment extends Fragment {


    private String title;
    private TextView leixing_reuse;
    private TextView shijian_reuse;
    private TextView zhuangtai_reuse;
    private TextView gongsi_reuse;
    private TextView xinxi_reuse;
    private TextView xiangmu_reuse;
    private TextView chakan_reuse;
    private ListView lv_reuse;
    private LinearLayout linear_reuse;

    public ReuseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_quan_bu, container, false);


        //获取Activity不同的传值
        Bundle bundle = getArguments();
        if (bundle != null) {
            title = (String) bundle.get("title");
            Log.d("MyFragment", title);
        }
        switch (title) {
            case "全部":
                Toast.makeText(getActivity(), "1111", Toast.LENGTH_SHORT).show();
                break;
            case "待付款":
                Toast.makeText(getActivity(), "2222", Toast.LENGTH_SHORT).show();
                break;
            case "待施工":
                Toast.makeText(getActivity(), "3333", Toast.LENGTH_SHORT).show();
                break;
            case "代发货":
                Toast.makeText(getActivity(), "4444", Toast.LENGTH_SHORT).show();
                break;
            case "待收货":
                Toast.makeText(getActivity(), "5555", Toast.LENGTH_SHORT).show();
                break;
            case "待评价":
                Toast.makeText(getActivity(), "6666", Toast.LENGTH_SHORT).show();
                break;
        }
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        leixing_reuse = (TextView) inflate.findViewById(R.id.leixing_reuse);
        shijian_reuse = (TextView) inflate.findViewById(R.id.shijian_reuse);
        zhuangtai_reuse = (TextView) inflate.findViewById(R.id.zhuangtai_reuse);
        gongsi_reuse = (TextView) inflate.findViewById(R.id.gongsi_reuse);
        xinxi_reuse = (TextView) inflate.findViewById(R.id.xinxi_reuse);
        xiangmu_reuse = (TextView) inflate.findViewById(R.id.xiangmu_reuse);
        chakan_reuse = (TextView) inflate.findViewById(R.id.chakan_reuse);
        lv_reuse = (ListView) inflate.findViewById(R.id.lv_reuse);
        linear_reuse = inflate.findViewById(R.id.linear_reuse);

        linear_reuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ReuseActivity.class);
                startActivity(intent);
            }
        });
    }
}
