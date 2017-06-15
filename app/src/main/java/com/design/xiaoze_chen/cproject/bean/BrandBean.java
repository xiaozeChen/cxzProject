package com.design.xiaoze_chen.cproject.bean;

import java.util.List;

/**
 * Created by xiaoze_chen on 2017/6/15.
 */

public class BrandBean {
    @Override
    public String toString() {
        return "BrandBean{" +
                "status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }

    /**
     * status : 0
     * msg : ok
     * result : [{"id":"1","name":"奥迪","initial":"A","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/1.png","depth":"1"},{"id":"2","name":"阿斯顿·马丁","initial":"A","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/2.png","depth":"1"},{"id":"3","name":"阿尔法·罗密欧","initial":"A","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/3.png","depth":"1"},{"id":"4","name":"AC Schnitzer","initial":"A","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/4.png","depth":"1"},{"id":"5","name":"Artega","initial":"A","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/5.png","depth":"1"},{"id":"6","name":"奥克斯","initial":"A","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/6.png","depth":"1"},{"id":"7","name":"本田","initial":"B","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/7.png","depth":"1"}]
     */

    private String status;
    private String msg;
    private List<ResultBean> result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 1
         * name : 奥迪
         * initial : A
         * parentid : 0
         * logo : http://api.jisuapi.com/car/static/images/logo/300/1.png
         * depth : 1
         */

        private String id;
        private String name;
        private String initial;
        private String parentid;
        private String logo;
        private String depth;

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

        public String getInitial() {
            return initial;
        }

        public void setInitial(String initial) {
            this.initial = initial;
        }

        public String getParentid() {
            return parentid;
        }

        public void setParentid(String parentid) {
            this.parentid = parentid;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getDepth() {
            return depth;
        }

        public void setDepth(String depth) {
            this.depth = depth;
        }
    }
}
