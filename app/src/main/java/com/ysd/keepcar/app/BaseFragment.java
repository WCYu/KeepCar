package com.ysd.keepcar.app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public abstract class BaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getInitId(), container, false);
        initView(view);
        initData();
        initAdapter();
        initLinstener();
        return view;
    }
    public abstract int getInitId();

    public abstract void initView(View view);

    public abstract void initData();

    public abstract void initAdapter();

    public abstract void initLinstener();
}
