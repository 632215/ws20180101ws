package com.ws20180101ws.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.donkingliang.banner.CustomBanner;
import com.ws20180101ws.R;
import com.ws20180101ws.base.BaseFragment;

import butterknife.Bind;


/**
 * Created by Administrator on 2017/11/3.
 */

public class MainFragment extends BaseFragment {
    @Bind(R.id.tx_main)
    TextView txMain;
    @Bind(R.id.customBanner)
    CustomBanner mBanner;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        txMain.setText("主页");
//        mBanner.setPages(new CustomBanner.ViewCreator<String>() {
//            @Override
//            public View createView(Context context, int position) {
//                //这里返回的是轮播图的项的布局 支持任何的布局
//                //position 轮播图的第几个项
//                ImageView imageView = new ImageView(context);
//                return imageView;
//            }
//
//            @Override
//            public void updateUI(Context context, View view, int position, String data) {
//                //在这里更新轮播图的UI
//                //position 轮播图的第几个项
//                //view 轮播图当前项的布局 它是createView方法的返回值
//                //data 轮播图当前项对应的数据
//                Glide.with(context).load(data).into((ImageView) view);
//            }
//        }, beans);
    }
}
