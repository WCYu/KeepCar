package com.ysd.keepcar.utils;

/**
 * Created by 阿禹 on 2017/12/26.
 */

public class UrlPath {
    //app接口服务器地址
    public static final String URLPATHAPP="http://39.106.173.47:8080/app/";

    //图片服务器地址
    public static final String URLPATHIMG="http://39.106.173.47:8080/saas-img";

    //用户登录
    public static final String URLPATHLOGIN="account/m_login/v1_0.do";

    //发送验证码
    public static final String URLPATHVERCODE="vcode/m_sendSms_v1_0.do";

//<---------------------------------4S店---------------------------------------------->
    //4S--我的会员店和我的历史下单店
    public static final String URLFOURSDIANMIAN="myAccount/queryMyVipShop_v1_0.do";
    //品牌
    public static final String URLFOURSBRAND="carBrand/querySubBrand.do";
    //获取4s店列表
    public static final String URLFOURSLIEBIAO="4sShop/shopList.do";
    public static final String URLFOURS="integralMall/showProduct_v1_0.do";

//<------------------------------------------------------------------------------->



//    //图片服务器地址
//    public static final String URLPATHIMG=" http://39.106.173.47:8080/saas-img/";
    //轮播图地址
    public static final String URLPATHBANNER="main/queryBrandImg.do";
}
