package com.ws20180101ws.bean;

/**
 * Created by Administrator on 2017/11/1.
 */

public class HttpResult<T> {
    /**
     * data : {"id":"2","url":"fenqile.com","type":"ios","showurl":"0","appid":"com.deep.lee","comment":"text02","createAt":"2017-07-12 07:09:31","updateAt":"2017-07-17 01:52:44"}
     * rt_code : 200
     */

    private T data;
    private String rt_code;

    public HttpResult(T data, String rt_code) {
        this.data = data;
        this.rt_code = rt_code;
    }

    public HttpResult() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getRt_code() {
        return Integer.parseInt(rt_code);
    }

    public void setRt_code(String rt_code) {
        this.rt_code = rt_code;
    }
}
