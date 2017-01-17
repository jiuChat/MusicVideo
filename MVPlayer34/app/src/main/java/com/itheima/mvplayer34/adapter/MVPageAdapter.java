package com.itheima.mvplayer34.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.itheima.mvplayer34.model.MVAreaItemBean;
import com.itheima.mvplayer34.ui.fragment.MVPageFragment;

import java.util.List;

/**
 * Created by Leon on 2017/1/16.
 */

/**
 * FragmentPagerAdapter继承自PagerAdapter viewpager的每一个页面将会一个Fragment
 */
public class MVPageAdapter extends FragmentPagerAdapter {

    private List<MVAreaItemBean> mDataList;

    public MVPageAdapter(FragmentManager fm, List<MVAreaItemBean> list) {
        this(fm);
        mDataList = list;
    }

    public MVPageAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * 返回对应位置的fragment
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        return new MVPageFragment();
    }

    /**
     * 有多少个tab就有多少个页面
     * @return
     */
    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mDataList.get(position).getName();
    }
}
