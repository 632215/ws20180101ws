package com.ws20180101ws.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ws20180101ws.R;
import com.ws20180101ws.base.BaseFragment;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/11/3.
 */

public class SetFragment extends BaseFragment {
    @Bind(R.id.tx_main)
    TextView txMain;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        txMain.setText("设置");
    }
}
