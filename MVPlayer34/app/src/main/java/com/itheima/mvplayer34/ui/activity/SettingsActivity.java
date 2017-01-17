package com.itheima.mvplayer34.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.itheima.mvplayer34.R;

/**
 * Created by Leon on 2017/1/15.
 */
public class SettingsActivity extends BaseActivity{

    private static final String TAG = "SettingsActivity";

    @Override
    public int getLayoutResId() {
        return R.layout.activity_settings;
    }

    @Override
    protected void init() {
        super.init();
        //设置ActionBar的返回按钮 和标题
        ActionBar supportActionBar = getSupportActionBar();
//        getActionBar();返回空
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setTitle(R.string.settings);

        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean push_notification = defaultSharedPreferences.getBoolean("push_notification", false);
        Log.d(TAG, "init: " + push_notification);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //处理返回按钮的点击事件
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 一定public类
     */
    public static class SettingsFragment extends PreferenceFragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            addPreferencesFromResource(R.xml.settings);
            return super.onCreateView(inflater, container, savedInstanceState);
        }

        /**
         * 首选项点击处理
         * @param preferenceScreen
         * @param preference
         * @return
         */
        @Override
        public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
            if (preference.getKey().equals("about")) {
                //跳到关于界面
                Intent intent = new Intent(getActivity(), AboutActivity.class);
                startActivity(intent);
            }
            return super.onPreferenceTreeClick(preferenceScreen, preference);
        }
    }
}
