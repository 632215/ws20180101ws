package com.ws20180101ws.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ws20180101ws.R;
import com.ws20180101ws.base.BaseFragment;
import com.ws20180101ws.bean.HttpResult;
import com.ws20180101ws.bean.URLBean;
import com.ws20180101ws.http.HttpMethods;
import com.ws20180101ws.http.ProgressSubscriber;
import com.ws20180101ws.http.SubscriberOnNextListener;
import com.ws20180101ws.ui.activity.WebActivity;

import butterknife.Bind;
import butterknife.OnClick;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/3.
 */

public class SetFragment extends BaseFragment {
    @Bind(R.id.tx_show)
    TextView tx_show;
    private URLBean bean;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_set;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        setTitle("个人中心");
        getUrl();
    }

    private void getUrl() {
        Map map = new HashMap();
        map.put("appid", "no170001");
        map.put("type", "android");

        SubscriberOnNextListener nextListener = new SubscriberOnNextListener<URLBean>() {
            @Override
            public void onNext(URLBean urlBean) {
                bean = urlBean;
                tx_show.setVisibility(View.VISIBLE);
            }

            @Override
            public void onError(String Code) {

            }
        };
        HttpMethods.getInstance().getURL(new ProgressSubscriber<HttpResult<URLBean>>(nextListener, getActivity()), map);
    }

    @OnClick(R.id.tx_show)
    public void click(View view) {
        switch (view.getId()) {
            case R.id.tx_show:
                if (bean != null && bean.getShowurl() != null) {
                    if (bean.getShowurl().equals("1")) {
                        Intent intent = new Intent(getActivity(), WebActivity.class);
                        intent.putExtra("url", bean.getUrl());
                        startActivity(intent);
                    }else {
                        Toast.makeText(getActivity(), "请稍后重试", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "请稍后重试", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
