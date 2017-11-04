package com.ws20180101ws.application;

import android.app.Application;

import com.bulong.rudeness.RudenessScreenHelper;

/**
 * Created by Administrator on 2017/11/3.
 */

public class MyApplication extends Application {

    private static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        //设计图标注的宽度
        int designWidth = 750;
        new RudenessScreenHelper(this, designWidth).activate();
    }
}
