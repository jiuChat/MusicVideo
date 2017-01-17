package com.itheima.mvplayer34.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by Leon on 2017/1/15.
 */

/**
 * 封装Activity通用的功能 相当于一个Activity的小的框架
 * 有利于代码的扩展性
 */
public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
        init();
    }

    /**
     * 子类如果要做初始化，可以覆写该方法
     *
     * 做Activity通用初始化
     */
    protected void init() {
        //摇一摇初始化
    }

    /**
     * 子类必须去实现该方法，返回一个布局的资源id
     * @return
     */
    public abstract int getLayoutResId();
}
