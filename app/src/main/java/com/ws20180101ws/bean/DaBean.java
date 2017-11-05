package com.ws20180101ws.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/11/5.
 */

public class DaBean {

    /**
     * rows : 5
     * code : dlt
     * info : 免费接口随机延迟3-6分钟，实时接口请访问opencai.net或QQ:23081452(注明彩票或API)
     * data : [{"expect":"2017129","opencode":"05,17,20,32,33+04,09","opentime":"2017-11-04 20:33:20","opentimestamp":1509798800},{"expect":"2017128","opencode":"09,11,13,18,33+02,03","opentime":"2017-11-01 20:33:20","opentimestamp":1509539600},{"expect":"2017127","opencode":"02,15,18,21,22+03,10","opentime":"2017-10-30 20:33:20","opentimestamp":1509366800},{"expect":"2017126","opencode":"03,04,13,24,33+01,11","opentime":"2017-10-28 20:33:20","opentimestamp":1509194000},{"expect":"2017125","opencode":"07,11,18,26,28+04,05","opentime":"2017-10-25 20:33:20","opentimestamp":1508934800}]
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
         * expect : 2017129
         * opencode : 05,17,20,32,33+04,09
         * opentime : 2017-11-04 20:33:20
         * opentimestamp : 1509798800
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
