package com.ws20180101ws.util;

import android.content.Context;

/**
 * Created by Administrator on 2017/11/1.
 */

public class Utils {
    public static Context context;

    private Utils() {
        throw new UnsupportedOperationException("u can\'t instantiate me...");
    }

    public static void init(Context context) {
        Utils.context = context.getApplicationContext();
    }
}
