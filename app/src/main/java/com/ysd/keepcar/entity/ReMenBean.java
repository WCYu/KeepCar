package com.ysd.keepcar.entity;

import java.util.List;

/**
 * Created by 阿禹 on 2018/1/2.
 */

public class ReMenBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"total":1,"list":[{"code":"RSIB16D37195960A4B7697347C06929596FB","productType":"保险","salesWays":"零售","promotionType":"无","productName":"保险存5000送2000限时活动","shopName":null,"shopCode":null,"salesNum":0,"discountPrice":0,"originalPrice":5000,"poster":"/upload/P01/P01001/P01_P01001_M007_SHOP00000010_8D19B34EB2474F9C91D619F7066DD662.jpg","activeCondition":"无","useYear":4,"activeBeginDate":null,"activeEndDate":null,"isPackage":"否","isShowMemberFlag":"1","logo":null,"activeState":null}],"pages":1}
     */

    private String code;
    private String msg;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * total : 1
         * list : [{"code":"RSIB16D37195960A4B7697347C06929596FB","productType":"保险","salesWays":"零售","promotionType":"无","productName":"保险存5000送2000限时活动","shopName":null,"shopCode":null,"salesNum":0,"discountPrice":0,"originalPrice":5000,"poster":"/upload/P01/P01001/P01_P01001_M007_SHOP00000010_8D19B34EB2474F9C91D619F7066DD662.jpg","activeCondition":"无","useYear":4,"activeBeginDate":null,"activeEndDate":null,"isPackage":"否","isShowMemberFlag":"1","logo":null,"activeState":null}]
         * pages : 1
         */

        private int total;
        private int pages;
        private List<ListBean> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * code : RSIB16D37195960A4B7697347C06929596FB
             * productType : 保险
             * salesWays : 零售
             * promotionType : 无
             * productName : 保险存5000送2000限时活动
             * shopName : null
             * shopCode : null
             * salesNum : 0
             * discountPrice : 0.0
             * originalPrice : 5000.0
             * poster : /upload/P01/P01001/P01_P01001_M007_SHOP00000010_8D19B34EB2474F9C91D619F7066DD662.jpg
             * activeCondition : 无
             * useYear : 4.0
             * activeBeginDate : null
             * activeEndDate : null
             * isPackage : 否
             * isShowMemberFlag : 1
             * logo : null
             * activeState : null
             */

            private String code;
            private String productType;
            private String salesWays;
            private String promotionType;
            private String productName;
            private Object shopName;
            private Object shopCode;
            private int salesNum;
            private double discountPrice;
            private double originalPrice;
            private String poster;
            private String activeCondition;
            private double useYear;
            private Object activeBeginDate;
            private Object activeEndDate;
            private String isPackage;
            private String isShowMemberFlag;
            private Object logo;
            private Object activeState;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getProductType() {
                return productType;
            }

            public void setProductType(String productType) {
                this.productType = productType;
            }

            public String getSalesWays() {
                return salesWays;
            }

            public void setSalesWays(String salesWays) {
                this.salesWays = salesWays;
            }

            public String getPromotionType() {
                return promotionType;
            }

            public void setPromotionType(String promotionType) {
                this.promotionType = promotionType;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public Object getShopName() {
                return shopName;
            }

            public void setShopName(Object shopName) {
                this.shopName = shopName;
            }

            public Object getShopCode() {
                return shopCode;
            }

            public void setShopCode(Object shopCode) {
                this.shopCode = shopCode;
            }

            public int getSalesNum() {
                return salesNum;
            }

            public void setSalesNum(int salesNum) {
                this.salesNum = salesNum;
            }

            public double getDiscountPrice() {
                return discountPrice;
            }

            public void setDiscountPrice(double discountPrice) {
                this.discountPrice = discountPrice;
            }

            public double getOriginalPrice() {
                return originalPrice;
            }

            public void setOriginalPrice(double originalPrice) {
                this.originalPrice = originalPrice;
            }

            public String getPoster() {
                return poster;
            }

            public void setPoster(String poster) {
                this.poster = poster;
            }

            public String getActiveCondition() {
                return activeCondition;
            }

            public void setActiveCondition(String activeCondition) {
                this.activeCondition = activeCondition;
            }

            public double getUseYear() {
                return useYear;
            }

            public void setUseYear(double useYear) {
                this.useYear = useYear;
            }

            public Object getActiveBeginDate() {
                return activeBeginDate;
            }

            public void setActiveBeginDate(Object activeBeginDate) {
                this.activeBeginDate = activeBeginDate;
            }

            public Object getActiveEndDate() {
                return activeEndDate;
            }

            public void setActiveEndDate(Object activeEndDate) {
                this.activeEndDate = activeEndDate;
            }

            public String getIsPackage() {
                return isPackage;
            }

            public void setIsPackage(String isPackage) {
                this.isPackage = isPackage;
            }

            public String getIsShowMemberFlag() {
                return isShowMemberFlag;
            }

            public void setIsShowMemberFlag(String isShowMemberFlag) {
                this.isShowMemberFlag = isShowMemberFlag;
            }

            public Object getLogo() {
                return logo;
            }

            public void setLogo(Object logo) {
                this.logo = logo;
            }

            public Object getActiveState() {
                return activeState;
            }

            public void setActiveState(Object activeState) {
                this.activeState = activeState;
            }
        }
    }
}
