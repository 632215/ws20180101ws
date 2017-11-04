package com.ws20180101ws.ui.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.ws20180101ws.R;
import com.ws20180101ws.base.BaseActivity;
import com.ws20180101ws.bean.HttpResult;
import com.ws20180101ws.bean.URLBean;
import com.ws20180101ws.http.HttpMethods;
import com.ws20180101ws.http.ProgressSubscriber;
import com.ws20180101ws.http.SubscriberOnNextListener;
import com.ws20180101ws.ui.fragment.ChangeFragment;
import com.ws20180101ws.ui.fragment.MainFragment;
import com.ws20180101ws.ui.fragment.SetFragment;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    @Bind(R.id.fl_main)
    FrameLayout flMain;
    @Bind(R.id.rg_main)
    RadioGroup rgMain;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    private MainFragment mainFragment;
    private ChangeFragment changeFragment;
    private SetFragment setFragment;

    @Override
    protected int childSetContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        rgMain.setOnCheckedChangeListener(this);
        setDefaultFragment();
//        Map map = new HashMap();
//        map.put("appid", "no170001");
//        map.put("type", "android");
//
//        SubscriberOnNextListener nextListener = new SubscriberOnNextListener<URLBean>() {
//            @Override
//            public void onNext(URLBean urlBean) {
//                String url = urlBean.getUrl();
//            }
//
//            @Override
//            public void onError(String Code) {
//
//            }
//        };
//        HttpMethods.getInstance().getURL(new ProgressSubscriber<HttpResult<URLBean>>(nextListener, this), map);
    }

    private void setDefaultFragment() {
        if (mainFragment == null) {
            mainFragment = new MainFragment();
        }
        transaction.add(R.id.fl_main, mainFragment);
        transaction.commit();
        rgMain.check(R.id.rb_home);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        switch (i) {
            case R.id.rb_home:
                if (mainFragment == null) {
                    mainFragment = new MainFragment();
                }
                transaction.replace(R.id.fl_main, mainFragment);
                transaction.commit();
                break;
            case R.id.rb_change:

                if (changeFragment == null) {
                    changeFragment = new ChangeFragment();
                }
                transaction.replace(R.id.fl_main, changeFragment);
                transaction.commit();
                break;

            case R.id.rb_set:
                if (setFragment == null) {
                    setFragment = new SetFragment();
                }
                transaction.replace(R.id.fl_main, setFragment);
                transaction.commit();
                break;

        }

    }
}
