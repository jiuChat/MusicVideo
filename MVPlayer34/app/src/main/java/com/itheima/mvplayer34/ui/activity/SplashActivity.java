package com.itheima.mvplayer34.ui.activity;

import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.itheima.mvplayer34.R;

import butterknife.BindView;

/**
 * Created by Leon on 2017/1/15.
 */

public class SplashActivity extends BaseActivity {

    @BindView(R.id.splash_image)
    ImageView mSplashImage;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void init() {
        super.init();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_anim);
        animation.setAnimationListener(mAnimationListener);
        mSplashImage.startAnimation(animation);
    }

    private Animation.AnimationListener mAnimationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            //动画结束跳转到主界面
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };
}
