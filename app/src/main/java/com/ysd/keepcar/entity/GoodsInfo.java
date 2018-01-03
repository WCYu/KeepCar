package com.ysd.keepcar.entity;

/**
 * Created by Administrator on 2017-12-27.
 * 商品信息
 */

public class GoodsInfo {
    //id
    private String id;
    //商品名称
    private String name;
    //是否选择
    private boolean isChoosed;
    //图片地址
    private String imageUrl;
    //派送
    private String desc;
    //价格
    private double price;
    //车辆详情
    private String carMsg;
    //取货方式
    private String getWay;
    //索引
    private int postion;
    private int count;
    //goods
    private int goodsImg;
    //是否对单一编辑
    private boolean isEditor;
    //是否对全部的条目进行编辑
    private boolean ActionBarEditor;

    public boolean isEditor() {
        return isEditor;
    }

    public void setEditor(boolean editor) {
        isEditor = editor;
    }

    public boolean isActionBarEditor() {
        return ActionBarEditor;
    }

    public void setActionBarEditor(boolean actionBarEditor) {
        ActionBarEditor = actionBarEditor;
    }

    public GoodsInfo(String id, String name, String desc, double price, String carMsg, String getWay, int goodsImg, int count) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.carMsg = carMsg;
        this.getWay = getWay;
        this.goodsImg = goodsImg;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChoosed() {
        return isChoosed;
    }

    public void setChoosed(boolean choosed) {
        isChoosed = choosed;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCarMsg() {
        return carMsg;
    }

    public void setCarMsg(String carMsg) {
        this.carMsg = carMsg;
    }

    public String getGetWay() {
        return getWay;
    }

    public void setGetWay(String getWay) {
        this.getWay = getWay;
    }

    public int getPostion() {
        return postion;
    }

    public void setPostion(int postion) {
        this.postion = postion;
    }

    public int getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(int goodsImg) {
        this.goodsImg = goodsImg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
