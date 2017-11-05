package com.ws20180101ws.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/11/5.
 */

public class FuBean {

    /**
     * rows : 5
     * code : fc3d
     * info : 免费接口随机延迟3-6分钟，实时接口请访问opencai.net或QQ:23081452(注明彩票或API)
     * data : [{"expect":"2017301","opencode":"3,9,1","opentime":"2017-11-04 21:20:00","opentimestamp":1509801600},{"expect":"2017300","opencode":"0,5,0","opentime":"2017-11-03 21:20:00","opentimestamp":1509715200},{"expect":"2017299","opencode":"9,2,1","opentime":"2017-11-02 21:20:00","opentimestamp":1509628800},{"expect":"2017298","opencode":"2,1,8","opentime":"2017-11-01 21:20:00","opentimestamp":1509542400},{"expect":"2017297","opencode":"4,6,2","opentime":"2017-10-31 21:20:00","opentimestamp":1509456000}]
     */

    private int rows;
    private String code;
    private String info;
    private List<DataBean> data;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * expect : 2017301
         * opencode : 3,9,1
         * opentime : 2017-11-04 21:20:00
         * opentimestamp : 1509801600
         */

        private String expect;
        private String opencode;
        private String opentime;
        private int opentimestamp;

        public String getExpect() {
            return expect;
        }

        public void setExpect(String expect) {
            this.expect = expect;
        }

        public String getOpencode() {
            return opencode;
        }

        public void setOpencode(String opencode) {
            this.opencode = opencode;
        }

        public String getOpentime() {
            return opentime;
        }

        public void setOpentime(String opentime) {
            this.opentime = opentime;
        }

        public int getOpentimestamp() {
            return opentimestamp;
        }

        public void setOpentimestamp(int opentimestamp) {
            this.opentimestamp = opentimestamp;
        }
    }
}
