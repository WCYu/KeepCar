package com.ysd.keepcar.view.shop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ysd.keepcar.utils.OkhttpUtil;
import com.ysd.keepcar.utils.UrlPath;
import com.ysd.keepcar.utils.ZJson;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

//
//                       _oo0oo_
//                      o8888888o
//                      88" . "88
//                      (| -_- |)
//                      0\  =  /0
//                    ___/`---'\___
//                  .' \\|     |// '.
//                 / \\|||  :  |||// \
//                / _||||| -:- |||||- \
//               |   | \\\  -  /// |   |
//               | \_|  ''\---/''  |_/ |
//               \  .-\__  '-'  ___/-. /
//             ___'. .'  /--.--\  `. .'___
//          ."" '<  `.___\_<|>_/___.' >' "".
//         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//         \  \ `_.   \_ __\ /__ _/   .-` /  /
//     =====`-.____`.___ \_____/___.-`___.-'=====
//                       `=---='
//
//
//     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//               佛祖保佑         永无BUG
//
//
//积分商城
public class Integral_Mall_Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("productType","");
        map.put("shopCode","");
        map.put("searchType","");
        map.put("cityId","");
        map.put("pageSize","10");
        map.put("pageNum","0");
        map.put("tk","");
        map.put("q","");
        String str = ZJson.toJSONMap(map);
        OkhttpUtil.getInstance().post(UrlPath.URLPATHAPP + UrlPath.URLFOURS, str, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                Log.e("TAG",response.body().string());
            }
        });
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
