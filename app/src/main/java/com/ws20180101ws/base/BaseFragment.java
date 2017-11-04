package com.ws20180101ws.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ws20180101ws.R;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/11/3.
 */

public abstract class BaseFragment extends Fragment {
    private FrameLayout layoutContent;
    private TextView textTitle;
    private TextView buttonBackward;
    private TextView buttonForward;
    private TextView titleLine;
    private RelativeLayout layout_titlebar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base_title, container, false);
        initChild(view, inflater);
        ButterKnife.bind(this, view);
        initView(view, savedInstanceState);
        return view;
    }

    protected void initChild(View view, LayoutInflater inflater) {
        textTitle = (TextView) view.findViewById(R.id.text_title);
        titleLine = (TextView) view.findViewById(R.id.layout_title_bar_line);
        layout_titlebar = (RelativeLayout) view.findViewById(R.id.layout_titlebar);
        layoutContent = (FrameLayout) view.findViewById(R.id.layout_content);
        layoutContent.removeAllViews();
        View child = inflater.inflate(getLayoutId(), null);
        layoutContent.addView(child);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    /**
     * 隐藏标题栏线
     */
    protected void hindTitleLine(int visibility) {
        titleLine.setVisibility(visibility);
    }

    /**
     * 设置标题栏背景色
     *
     * @param titleBarBgColor
     */
    protected void setTitleBarBgColor(int titleBarBgColor) {
        layout_titlebar.setBackgroundResource(titleBarBgColor);
    }

    /**
     * 设置标题内容
     *
     * @param titleId
     */
    public void setTitle(String titleId) {
        layout_titlebar.setVisibility(View.VISIBLE);
        textTitle.setText(titleId);
    }

    protected abstract int getLayoutId();

    protected abstract void initView(View view, Bundle savedInstanceState);

}
