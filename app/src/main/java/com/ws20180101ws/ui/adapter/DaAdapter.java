package com.ws20180101ws.ui.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.ws20180101ws.R;
import com.ws20180101ws.bean.DaBean;
import com.ws20180101ws.bean.FuBean;
import com.ws20180101ws.ui.adapter.base.BaseViewHolder;
import com.ws20180101ws.ui.adapter.base.CommonAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/11/5.
 */

public class DaAdapter extends CommonAdapter<DaBean.DataBean> {

    public DaAdapter(@NonNull Context context, @LayoutRes int layoutResId, @NonNull List<DaBean.DataBean> dataList) {
        super(context, layoutResId, dataList);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, DaBean.DataBean o, int position) {
        TextView tx_expect = (TextView) baseViewHolder.getViewByViewId(R.id.tx_expect);
        TextView tx_opentime = (TextView) baseViewHolder.getViewByViewId(R.id.tx_opentime);
        TextView tx_opencode = (TextView) baseViewHolder.getViewByViewId(R.id.tx_opencode);
        TextView tx_line = (TextView) baseViewHolder.getViewByViewId(R.id.tx_line);

        tx_expect.setText("期号：" + o.getExpect());
        tx_opentime.setText("开奖日期：" + o.getOpentime());
        tx_opencode.setText("开奖号码：" + o.getOpencode());
    }
}