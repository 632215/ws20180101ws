package com.ws20180101ws.http;


import com.ws20180101ws.bean.HttpResult;
import com.ws20180101ws.bean.URLBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by liukun on 16/icon_cs3/9.
 */
public interface AppService {

    @GET("Lottery_server/check_and_get_url.php")
    Observable<HttpResult<URLBean>> getURL(@QueryMap Map<String, String> map);
}
