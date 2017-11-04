package com.ws20180101ws.ui.activity;

import android.content.Intent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.ws20180101ws.R;
import com.ws20180101ws.base.BaseActivity;

import butterknife.Bind;

/**
 * Created by root on 17-7-22.
 */

public class StartupPageActivity extends BaseActivity {
    @Bind(R.id.iamge_start_page)
    ImageView imageView;

    @Override
    protected int childSetContentView() {
        return R.layout.activity_startpage;
    }

    @Override
    protected void initView() {
        AlphaAnimation animation = new AlphaAnimation(0.3f, 1.0f);
        animation.setDuration(2000);
        imageView.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation arg0) {
                startActivity(new Intent(StartupPageActivity.this, MainActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationStart(Animation animation) {
            }
        });
    }
}
