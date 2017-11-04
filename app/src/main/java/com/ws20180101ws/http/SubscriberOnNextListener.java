package com.ws20180101ws.http;

/**
 * Created by liukun on 16/icon_cs3/10.
 */
public interface SubscriberOnNextListener<T> {
    void onNext(T t);
    void onError(String Code);
}
