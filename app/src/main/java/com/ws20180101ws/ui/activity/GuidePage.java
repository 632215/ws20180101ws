package com.ws20180101ws.ui.activity;

import android.support.v4.view.ViewPager;

import com.ws20180101ws.R;
import com.ws20180101ws.base.BaseActivity;
import com.ws20180101ws.ui.adapter.ViewPagerAdapter;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/12/22.
 */

class GuidePage extends BaseActivity {
    @Bind(R.id.viewpage)
    ViewPager viewPager;

    private ViewPagerAdapter adapter;

    @Override
    protected int childSetContentView() {
        return R.layout.activity_guide;
    }

    @Override
    protected void initView() {

    }
}
