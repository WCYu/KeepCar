package com.ysd.keepcar.view.shop.entity;

import java.util.List;

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
//
public class FourSList_Bean {


    /**
     * code : 200
     * msg : 查询成功
     * data : {"total":2,"list":[{"shopCode":"SHOP00000010","logo":"/upload/static/carbrand/36.png","shopImg":"","shopName":"一汽大众\u2014北京昌平分店","provinceName":"山西","cityName":"吕梁","star":0,"distance":null},{"shopCode":"SHOP00000016","logo":"/upload/static/carbrand/1.png","shopImg":"","shopName":"北京朝阳奥迪4S店","provinceName":"广西","cityName":"来宾","star":0,"distance":null}],"pages":1,"hasNext":false}
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
         * total : 2
         * list : [{"shopCode":"SHOP00000010","logo":"/upload/static/carbrand/36.png","shopImg":"","shopName":"一汽大众\u2014北京昌平分店","provinceName":"山西","cityName":"吕梁","star":0,"distance":null},{"shopCode":"SHOP00000016","logo":"/upload/static/carbrand/1.png","shopImg":"","shopName":"北京朝阳奥迪4S店","provinceName":"广西","cityName":"来宾","star":0,"distance":null}]
         * pages : 1
         * hasNext : false
         */

        private int total;
        private int pages;
        private boolean hasNext;
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

        public boolean isHasNext() {
            return hasNext;
        }

        public void setHasNext(boolean hasNext) {
            this.hasNext = hasNext;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * shopCode : SHOP00000010
             * logo : /upload/static/carbrand/36.png
             * shopImg :
             * shopName : 一汽大众—北京昌平分店
             * provinceName : 山西
             * cityName : 吕梁
             * star : 0.0
             * distance : null
             */

            private String shopCode;
            private String logo;
            private String shopImg;
            private String shopName;
            private String provinceName;
            private String cityName;
            private double star;
            private Object distance;

            public String getShopCode() {
                return shopCode;
            }

            public void setShopCode(String shopCode) {
                this.shopCode = shopCode;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public String getShopImg() {
                return shopImg;
            }

            public void setShopImg(String shopImg) {
                this.shopImg = shopImg;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }

            public String getProvinceName() {
                return provinceName;
            }

            public void setProvinceName(String provinceName) {
                this.provinceName = provinceName;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public double getStar() {
                return star;
            }

            public void setStar(double star) {
                this.star = star;
            }

            public Object getDistance() {
                return distance;
            }

            public void setDistance(Object distance) {
                this.distance = distance;
            }
        }
    }
}
