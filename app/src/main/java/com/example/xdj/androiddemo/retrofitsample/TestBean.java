package com.example.xdj.androiddemo.retrofitsample;

/**
 * Created by xdj on 15/12/24.
 */
public class TestBean {

    /**
     * timeline : 1450929062
     * returnNo : 0000
     * returnInfo : 操作成功
     * secure : 0
     * content : {"id":"1","password":"9a3749436e553d63bcf1a4844c55b46c","mobile":"18768143566","mobile_yezhu":"18768143566","type":"1","uname":"niu","nickname":"lala","sex":"1","photo":"http://192.168.0.239/ch/upload/2015/12/14/14500649297079h38ow.png","reg_time":"1450404786","login_time":"1450927149","point":"0","sign":null,"tag":null,"loupan":null,"house":null}
     */

    private int timeline;
    private String returnNo;
    private String returnInfo;
    private int secure;
    /**
     * id : 1
     * password : 9a3749436e553d63bcf1a4844c55b46c
     * mobile : 18768143566
     * mobile_yezhu : 18768143566
     * type : 1
     * uname : niu
     * nickname : lala
     * sex : 1
     * photo : http://192.168.0.239/ch/upload/2015/12/14/14500649297079h38ow.png
     * reg_time : 1450404786
     * login_time : 1450927149
     * point : 0
     * sign : null
     * tag : null
     * loupan : null
     * house : null
     */

    private ContentEntity content;

    public void setTimeline(int timeline) {
        this.timeline = timeline;
    }

    public void setReturnNo(String returnNo) {
        this.returnNo = returnNo;
    }

    public void setReturnInfo(String returnInfo) {
        this.returnInfo = returnInfo;
    }

    public void setSecure(int secure) {
        this.secure = secure;
    }

    public void setContent(ContentEntity content) {
        this.content = content;
    }

    public int getTimeline() {
        return timeline;
    }

    public String getReturnNo() {
        return returnNo;
    }

    public String getReturnInfo() {
        return returnInfo;
    }

    public int getSecure() {
        return secure;
    }

    public ContentEntity getContent() {
        return content;
    }

    public static class ContentEntity {
        private String id;
        private String password;
        private String mobile;
        private String mobile_yezhu;
        private String type;
        private String uname;
        private String nickname;
        private String sex;
        private String photo;
        private String reg_time;
        private String login_time;
        private String point;
        private Object sign;
        private Object tag;
        private Object loupan;
        private Object house;

        public void setId(String id) {
            this.id = id;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public void setMobile_yezhu(String mobile_yezhu) {
            this.mobile_yezhu = mobile_yezhu;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public void setReg_time(String reg_time) {
            this.reg_time = reg_time;
        }

        public void setLogin_time(String login_time) {
            this.login_time = login_time;
        }

        public void setPoint(String point) {
            this.point = point;
        }

        public void setSign(Object sign) {
            this.sign = sign;
        }

        public void setTag(Object tag) {
            this.tag = tag;
        }

        public void setLoupan(Object loupan) {
            this.loupan = loupan;
        }

        public void setHouse(Object house) {
            this.house = house;
        }

        public String getId() {
            return id;
        }

        public String getPassword() {
            return password;
        }

        public String getMobile() {
            return mobile;
        }

        public String getMobile_yezhu() {
            return mobile_yezhu;
        }

        public String getType() {
            return type;
        }

        public String getUname() {
            return uname;
        }

        public String getNickname() {
            return nickname;
        }

        public String getSex() {
            return sex;
        }

        public String getPhoto() {
            return photo;
        }

        public String getReg_time() {
            return reg_time;
        }

        public String getLogin_time() {
            return login_time;
        }

        public String getPoint() {
            return point;
        }

        public Object getSign() {
            return sign;
        }

        public Object getTag() {
            return tag;
        }

        public Object getLoupan() {
            return loupan;
        }

        public Object getHouse() {
            return house;
        }
    }
}
