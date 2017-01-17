package com.itheima.mvplayer34.ui.activity;

import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import com.itheima.mvplayer34.R;

/**
 * Created by Leon on 2017/1/15.
 */
public class AboutActivity  extends BaseActivity{
    @Override
    public int getLayoutResId() {
        return R.layout.activity_about;
    }

    @Override
    protected void init() {
        super.init();
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle(R.string.about);
        supportActionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
