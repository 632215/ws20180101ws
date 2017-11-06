package com.ws20180101ws.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.donkingliang.banner.CustomBanner;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.ws20180101ws.R;
import com.ws20180101ws.base.BaseFragment;
import com.ws20180101ws.bean.DaBean;
import com.ws20180101ws.bean.FuBean;
import com.ws20180101ws.ui.adapter.DaAdapter;
import com.ws20180101ws.ui.adapter.FuAdapter;
import com.ws20180101ws.ui.widget.FillListView;
import com.ws20180101ws.util.GsonUtils;
import com.ws20180101ws.util.LogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


/**
 * Created by Administrator on 2017/11/3.
 */

public class MainFragment extends BaseFragment {
    @Bind(R.id.tx_main)
    TextView txMain;
    @Bind(R.id.custom_banner)
    CustomBanner mBanner;
    @Bind(R.id.list_view_fu)
    FillListView fuListView;
    @Bind(R.id.list_view_da)
    FillListView daListView;
    private List<Integer> bannerList = new ArrayList<>();
    private FuAdapter fuAdapter;
    private List<FuBean.DataBean> fuList = new ArrayList<>();

    private DaAdapter daAdapter;
    private List<DaBean.DataBean> daList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        setTitle("主页");
        initList();

    }

    private void getDaList() {
        daAdapter = new DaAdapter(getActivity(), R.layout.item_fu, daList);
        daListView.setAdapter(daAdapter);
        RequestParams params = new RequestParams();
        HttpUtils http = new HttpUtils(200000);
        http.send(HttpRequest.HttpMethod.POST,
                "http://f.apiplus.net/dlt.json", params,
                new RequestCallBack<String>() {
                    @Override
                    public void onSuccess(ResponseInfo<String> responseInfo) {
                        try {
                            DaBean bean = GsonUtils.GsonToBean(responseInfo.result, DaBean.class);
                            daList = bean.getData();
                            daAdapter.setDataList(daList);
                        } catch (Exception e) {
                        }
                    }

                    @Override
                    public void onFailure(HttpException e, String s) {
                        LogUtils.e("onFailure");
                    }
                });
    }

    private void getFuList() {
        fuAdapter = new FuAdapter(getActivity(), R.layout.item_fu, fuList);
        fuListView.setAdapter(fuAdapter);
        RequestParams params = new RequestParams();
        HttpUtils http = new HttpUtils(200000);
        http.send(HttpRequest.HttpMethod.POST,
                "http://f.apiplus.net/fc3d.json", params,
                new RequestCallBack<String>() {
                    @Override
                    public void onSuccess(ResponseInfo<String> responseInfo) {
                        try {
                            FuBean bean = GsonUtils.GsonToBean(responseInfo.result, FuBean.class);
                            fuList = bean.getData();
                            fuAdapter.setDataList(fuList);
                        } catch (Exception e) {
                        }
                    }

                    @Override
                    public void onFailure(HttpException e, String s) {
                        LogUtils.e("onFailure");
                    }
                });
    }

    private void initList() {
        bannerList.clear();
        bannerList.add(R.mipmap.icon_banner1);
        bannerList.add(R.mipmap.icon_banner2);
        mBanner.setPages(new CustomBanner.ViewCreator<Integer>() {
            @Override
            public View createView(Context context, int position) {
                //这里返回的是轮播图的项的布局 支持任何的布局
                //position 轮播图的第几个项
                ImageView imageView = new ImageView(context);
                return imageView;
            }

            @Override
            public void updateUI(Context context, View view, int position, Integer data) {
                //在这里更新轮播图的UI
                //position 轮播图的第几个项
                //view 轮播图当前项的布局 它是createView方法的返回值
                //data 轮播图当前项对应的数据
                Glide.with(context).load(data).into((ImageView) view);
            }
        }, bannerList);
    }

    @Override
    public void onResume() {
        super.onResume();
        getFuList();
        getDaList();
    }
}
