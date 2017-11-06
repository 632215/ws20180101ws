package com.ws20180101ws.ui.activity;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ws20180101ws.R;
import com.ws20180101ws.base.BaseActivity;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/11/2.
 */

public class WebActivity extends BaseActivity {
    @Bind(R.id.web)
    WebView webView;
    private String url = "";

    @Override
    protected int childSetContentView() {
        return R.layout.activity_webview;
    }

    @Override
    protected void initView() {
        setTitle("新闻详情");
        showBackwardView("", true);
        url = getIntent().getStringExtra("url");
        initWebView();
    }

    private void initWebView() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) { //  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl(url);

    }

    @Override
    protected void onBackward(View backwardView) {
        super.onBackward(backwardView);
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            webView.destroy();
            finish();
        }
    }
}
