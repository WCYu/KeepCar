package com.ysd.keepcar.view.personalcenter.tab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ysd.keepcar.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChuZhiFragment extends Fragment {




    public ChuZhiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_chu_zhi, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {

    }
}
