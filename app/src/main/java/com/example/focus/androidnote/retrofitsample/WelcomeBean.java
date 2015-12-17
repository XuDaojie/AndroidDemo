package com.example.focus.androidnote.retrofitsample;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xdj on 15/11/25.
 */
public class WelcomeBean {
    /**
     * return_code : 0
     * msg : 验证成功！
     * data : {"ban_list":[{"title":"222","link":"http://www.google.com","imgurl":"http://121.41.128.239:8105/jizhong/upload/2015/09/18/14425453897067obu50.png","product_id":"2","linktype":"1"},{"title":"淘宝视觉营销班","link":"http://www.baidu.com","imgurl":"http://121.41.128.239:8105/jizhong/upload/2015/08/31/144100919269536c2p8.png","product_id":"1","linktype":"0"}],"flag_list":[{"pro_id":"8","title":"微信营销实战班","whenlong":"5","intro":"","imgurl":"http://121.41.128.239:8105/jizhong/upload/2015/10/13/14447021747785pcr0t.jpg","click":"1","hot":"1","flag":"1","free":"0"},{"pro_id":"7","title":"淘宝客服全能班","whenlong":"10课时-350分钟","intro":"","imgurl":"http://121.41.128.239:8105/jizhong/upload/2015/09/14/14422233330569o8l23.png","click":"4","hot":"0","flag":"1","free":"0"},{"pro_id":"6","title":"淘宝视觉营销班","whenlong":"4课时-20分钟","intro":"","imgurl":"http://121.41.128.239:8105/jizhong/upload/2015/10/13/14447016160285ancwd.jpg","click":"2","hot":"1","flag":"1","free":"0"},{"pro_id":"3","title":"淘宝SEO精通班","whenlong":"","intro":"","imgurl":"http://121.41.128.239:8105/jizhong/upload/2015/09/14/14422231171078ydfse.png","click":"2","hot":"0","flag":"1","free":"0"},{"pro_id":"1","title":"微商运营全能班","whenlong":"4课时-100分钟","intro":"课程针对自身店铺情况，进行一下培训。。。","imgurl":"http://121.41.128.239:8105/jizhong/upload/2015/10/13/144470196790967oi64.jpg","click":"3","hot":"1","flag":"1","free":"0"}]}
     */

    private int return_code;
    private String msg;
    private DataEntity data;

    public void setReturn_code(int return_code) {
        this.return_code = return_code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public int getReturn_code() {
        return return_code;
    }

    public String getMsg() {
        return msg;
    }

    public DataEntity getData() {
        return data;
    }

    public static class DataEntity {
        /**
         * ban_list : [{"title":"222","link":"http://www.google.com","imgurl":"http://121.41.128.239:8105/jizhong/upload/2015/09/18/14425453897067obu50.png","product_id":"2","linktype":"1"},{"title":"淘宝视觉营销班","link":"http://www.baidu.com","imgurl":"http://121.41.128.239:8105/jizhong/upload/2015/08/31/144100919269536c2p8.png","product_id":"1","linktype":"0"}]
         * flag_list : [{"pro_id":"8","title":"微信营销实战班","whenlong":"5","intro":"","imgurl":"http://121.41.128.239:8105/jizhong/upload/2015/10/13/14447021747785pcr0t.jpg","click":"1","hot":"1","flag":"1","free":"0"},{"pro_id":"7","title":"淘宝客服全能班","whenlong":"10课时-350分钟","intro":"","imgurl":"http://121.41.128.239:8105/jizhong/upload/2015/09/14/14422233330569o8l23.png","click":"4","hot":"0","flag":"1","free":"0"},{"pro_id":"6","title":"淘宝视觉营销班","whenlong":"4课时-20分钟","intro":"","imgurl":"http://121.41.128.239:8105/jizhong/upload/2015/10/13/14447016160285ancwd.jpg","click":"2","hot":"1","flag":"1","free":"0"},{"pro_id":"3","title":"淘宝SEO精通班","whenlong":"","intro":"","imgurl":"http://121.41.128.239:8105/jizhong/upload/2015/09/14/14422231171078ydfse.png","click":"2","hot":"0","flag":"1","free":"0"},{"pro_id":"1","title":"微商运营全能班","whenlong":"4课时-100分钟","intro":"课程针对自身店铺情况，进行一下培训。。。","imgurl":"http://121.41.128.239:8105/jizhong/upload/2015/10/13/144470196790967oi64.jpg","click":"3","hot":"1","flag":"1","free":"0"}]
         */

        private List<BanListEntity> ban_list;
        private List<FlagListEntity> flag_list;

        public void setBan_list(List<BanListEntity> ban_list) {
            this.ban_list = ban_list;
        }

        public void setFlag_list(List<FlagListEntity> flag_list) {
            this.flag_list = flag_list;
        }

        public List<BanListEntity> getBan_list() {
            return ban_list;
        }

        public List<FlagListEntity> getFlag_list() {
            return flag_list;
        }

        public static class BanListEntity implements Serializable {
            /**
             * title : 222
             * link : http://www.google.com
             * imgurl : http://121.41.128.239:8105/jizhong/upload/2015/09/18/14425453897067obu50.png
             * product_id : 2
             * linktype : 1
             */

            private String title;
            private String link;
            private String imgurl;
            private String product_id;
            private String linktype;

            public void setTitle(String title) {
                this.title = title;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public void setImgurl(String imgurl) {
                this.imgurl = imgurl;
            }

            public void setProduct_id(String product_id) {
                this.product_id = product_id;
            }

            public void setLinktype(String linktype) {
                this.linktype = linktype;
            }

            public String getTitle() {
                return title;
            }

            public String getLink() {
                return link;
            }

            public String getImgurl() {
                return imgurl;
            }

            public String getProduct_id() {
                return product_id;
            }

            public String getLinktype() {
                return linktype;
            }
        }

        public static class FlagListEntity {
            /**
             * pro_id : 8
             * title : 微信营销实战班
             * whenlong : 5
             * intro :
             * imgurl : http://121.41.128.239:8105/jizhong/upload/2015/10/13/14447021747785pcr0t.jpg
             * click : 1
             * hot : 1
             * flag : 1
             * free : 0
             */

            private String pro_id;
            private String title;
            private String whenlong;
            private String intro;
            private String imgurl;
            private String click;
            private String hot;
            private String flag;
            private String free;

            public void setPro_id(String pro_id) {
                this.pro_id = pro_id;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setWhenlong(String whenlong) {
                this.whenlong = whenlong;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public void setImgurl(String imgurl) {
                this.imgurl = imgurl;
            }

            public void setClick(String click) {
                this.click = click;
            }

            public void setHot(String hot) {
                this.hot = hot;
            }

            public void setFlag(String flag) {
                this.flag = flag;
            }

            public void setFree(String free) {
                this.free = free;
            }

            public String getPro_id() {
                return pro_id;
            }

            public String getTitle() {
                return title;
            }

            public String getWhenlong() {
                return whenlong;
            }

            public String getIntro() {
                return intro;
            }

            public String getImgurl() {
                return imgurl;
            }

            public String getClick() {
                return click;
            }

            public String getHot() {
                return hot;
            }

            public String getFlag() {
                return flag;
            }

            public String getFree() {
                return free;
            }
        }
    }
}
