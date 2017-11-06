package com.ws20180101ws.bean;

/**
 * Created by Administrator on 2017/11/6.
 */

public class NewBean {
    String title;
    String url;
    String time;

    public NewBean(String title, String url, String time) {
        this.title = title;
        this.url = url;
        this.time = time;
    }

    public NewBean() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
