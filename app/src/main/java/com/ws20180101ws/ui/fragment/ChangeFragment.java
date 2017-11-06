package com.ws20180101ws.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ws20180101ws.R;
import com.ws20180101ws.base.BaseFragment;
import com.ws20180101ws.bean.NewBean;
import com.ws20180101ws.ui.activity.WebActivity;
import com.ws20180101ws.ui.adapter.NewAdapter;
import com.ws20180101ws.ui.widget.FillListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/11/3.
 */

public class ChangeFragment extends BaseFragment implements NewAdapter.ItemClick {
    @Bind(R.id.list_view)
    FillListView listView;

    private NewAdapter newAdapter;
    private List<NewBean> newList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_change;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        setTitle("新闻");
        initNewList();
    }

    private void initNewList() {
        initList();
        newAdapter = new NewAdapter(getActivity(), R.layout.item_news, newList);
        newAdapter.setListener(this);
        listView.setAdapter(newAdapter);
    }

    private void initList() {
        newList.clear();
        newList.add(new NewBean("谁能今晚中得1000万大奖 生肖鼠虎兔被内定了", "http://cai.163.com/article/17/1106/08/D2I013GD000597U8.html", "11-06 08:28"));
        newList.add(new NewBean("小伙手机APP购彩中奖867万 照常返回公司上班", "http://cai.163.com/article/17/1106/08/D2HV2D6N000597ST.html", "11-06 08:11"));
        newList.add(new NewBean("双色球第17130期开奖快讯:红球一组同尾+蓝球02", "http://cai.163.com/article/17/1105/21/D2GQ1G41000597U8.html", "11-05 21:24"));
        newList.add(new NewBean("男子中1600万连夜坐火车领奖 单期花费上千元", "http://cai.163.com/article/17/1105/07/D2FBJN9F000597U8.html", "11-05 07:52"));
        newList.add(new NewBean("彩友中653万称只激动一会 早就预感会中大奖", "http://cai.163.com/article/17/1104/07/D2CP2C5G000597U8.html", "11-04 07:50"));
        newList.add(new NewBean("男子两年内两中头奖金额2300万 为妻子治病", "http://cai.163.com/article/17/1104/07/D2COKTSM000597U8.html", "11-04 07:43"));
    }

    @Override
    public void onItemClick(String url) {
        Intent intent = new Intent(getActivity(), WebActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }
}
