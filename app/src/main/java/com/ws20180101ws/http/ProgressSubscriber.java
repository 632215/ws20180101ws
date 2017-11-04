package com.ws20180101ws.http;

import android.content.Context;


import com.ws20180101ws.bean.HttpResult;
import com.ws20180101ws.util.LogUtils;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;

import rx.Subscriber;

public class ProgressSubscriber<T> extends Subscriber<T> implements ProgressCancelListener {
    private SubscriberOnNextListener mSubscriberOnNextListener;
    private Context context;
    //对应HTTP的状态码
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;

    public ProgressSubscriber(SubscriberOnNextListener mSubscriberOnNextListener, Context context) {
        this.mSubscriberOnNextListener = mSubscriberOnNextListener;
        this.context = context;
    }

    @Override
    public void onStart() {
//        showProgressDialog();
    }

    @Override
    public void onCompleted() {
//        dismissProgressDialog();
    }

    @Override
    public void onError(Throwable e) {
        LogUtils.i("errorMsg---" + e.getLocalizedMessage());
        if (e instanceof SocketTimeoutException) {
            mSubscriberOnNextListener.onError("404");
        } else if (e instanceof ConnectException) {
            mSubscriberOnNextListener.onError("404");
        } else if (e instanceof UnknownHostException) {
            mSubscriberOnNextListener.onError("404");
        } else if (e instanceof UnknownServiceException) {
            mSubscriberOnNextListener.onError("404");
        }
    }

    /**
     * 将onNext方法中的返回结果交给Activity或Fragment自己处理
     *
     * @param t 创建Subscriber时的泛型类型
     */
    @Override
    public void onNext(T t) {
        HttpResult httpResult = (HttpResult) t;
        if (mSubscriberOnNextListener != null) {
            switch (httpResult.getRt_code()) {
                case 200:
                    mSubscriberOnNextListener.onNext(httpResult.getData());
                    break;
                default:
                    mSubscriberOnNextListener.onError(String.valueOf(httpResult.getRt_code()));
                    break;
            }
        }
    }

    /**
     * 取消ProgressDialog的时候，取消对observable的订阅，同时也取消了http请求
     */
    @Override
    public void onCancelProgress() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }
}