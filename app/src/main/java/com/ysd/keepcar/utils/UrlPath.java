package com.ysd.keepcar.utils;

/**
 * Created by 阿禹 on 2017/12/26.
 */

public class UrlPath {
    //app接口服务器地址
    public static final String URLPATHAPP = "http://39.106.173.47:8080/app/";
    //图片服务器地址
    public static final String URLPATHIMG="http://39.106.173.47:8080/saas-img";
    //用户登录
    public static final String URLPATHLOGIN = "account/m_login/v1_0.do";
    //发送验证码
    public static final String URLPATHVERCODE="vcode/m_sendSms_v1_0.do";
    //4S--我的会员店和我的历史下单店
    public static final String URLFOURSDIANMIAN="myAccount/queryMyVipShop_v1_0.do";
    //品牌
    public static final String URLFOURSBRAND="carBrand/querySubBrand.do";
    //获取4s店列表
    public static final String URLFOURSLIEBIAO="4sShop/shopList.do";

    public static final String URLFOURS="integralMall/showProduct_v1_0.do";
    //轮播图地址
    public static final String URLPATHBANNER = "main/queryBrandImg.do";
    // 根据城市名称转换成系统统一id
    public static final String URLCITYID = "address/queryByCityName.do";
    //热门
    public static final String URLREMEN = "main/queryHotProduct.do";
    //中间滚动部分展示当前账户所在的4s店
    public static final String URLGUNDONGTIAO = "myAccount/queryMyVipShop_v1_0.do";
    //积分商城数据列表
    public static final String URLINTEGRALSHOP= "integralMall/showProduct_v1_0.do";
    //精彩活动
    public static final String URLACTIVITY= "boutique/showProduct.do";
    //洗车
    public static final String URLWASHCAR= "washcar/queryWashShops.do";
    //4s店展厅 二手车展厅列表
    public static final String URLERSHOUCHE= "carExhibition/oldCarList.do";
    //4s店展厅 新车展厅列表
    public static final String URLNEWCHE= "carExhibition/newCarList.do";
}
