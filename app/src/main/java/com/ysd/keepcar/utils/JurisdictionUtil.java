package com.ysd.keepcar.utils;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import com.ysd.keepcar.app.AppService;

/**
 * Created by 阿禹 on 2017/12/26.
 */

public class JurisdictionUtil {
    private static JurisdictionUtil jurisdictionUtil;

    public static JurisdictionUtil getInstance(){
        if(jurisdictionUtil==null){
            synchronized (JurisdictionUtil.class){
                if(jurisdictionUtil==null){
                    jurisdictionUtil=new JurisdictionUtil();
                }
            }
        }
        return jurisdictionUtil;
    }

    //拨打电话
    public void callPhone(String phone){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri data = Uri.parse("tel:" + "18317521412");
        intent.setData(data);
        try{
            AppService.baseActivity.startActivity(intent);
        }catch (ActivityNotFoundException a){
            a.getMessage();
            Toast.makeText(AppService.baseActivity, "未获得拨打电话权限", Toast.LENGTH_SHORT).show();
        }
    }

}
