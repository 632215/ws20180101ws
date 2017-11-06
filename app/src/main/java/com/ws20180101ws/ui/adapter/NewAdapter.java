package com.ws20180101ws.ui.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ws20180101ws.R;
import com.ws20180101ws.bean.NewBean;
import com.ws20180101ws.ui.adapter.base.BaseViewHolder;
import com.ws20180101ws.ui.adapter.base.CommonAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/11/6.
 */

public class NewAdapter extends CommonAdapter<NewBean> {
    private ItemClick listener;

    public ItemClick getListener() {
        return listener;
    }

    public void setListener(ItemClick listener) {
        this.listener = listener;
    }

    public NewAdapter(@NonNull Context context, @LayoutRes int layoutResId, @NonNull List<NewBean> dataList) {
        super(context, layoutResId, dataList);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, final NewBean newBean, int position) {
        RelativeLayout rl_root = (RelativeLayout) baseViewHolder.getViewByViewId(R.id.rl_root);
        TextView tx_title = (TextView) baseViewHolder.getViewByViewId(R.id.tx_title);
        TextView tx_time = (TextView) baseViewHolder.getViewByViewId(R.id.tx_time);
        tx_title.setText(newBean.getTitle());
        tx_time.setText(newBean.getTime());
        rl_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(newBean.getUrl());
            }
        });
    }

    public interface ItemClick {
        void onItemClick(String url);
    }
}
