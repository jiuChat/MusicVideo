package com.itheima.mvplayer34.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.itheima.leon.funhttplib.NetworkListener;
import com.itheima.mvplayer34.R;
import com.itheima.mvplayer34.adapter.MVPageAdapter;
import com.itheima.mvplayer34.model.MVAreaItemBean;
import com.itheima.mvplayer34.network.MVAreaRequest;
import com.itheima.mvplayer34.utils.URLProviderUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Leon on 2017/1/15.
 */

public class MVFragment extends BaseFragment {
    private static final String TAG = "MVFragment";
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    private MVPageAdapter mMVPageAdapter;

    private List<MVAreaItemBean> mMVAreaItemBean = new ArrayList<MVAreaItemBean>();

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_mv;
    }

    @Override
    protected void init() {
        super.init();

        //因为MVFragment本身是一个Fragment, viewpager内部每个页面都是一个fragment，
        //传入childFragmentManager来管理fragment里面的fragment
        mMVPageAdapter = new MVPageAdapter(getChildFragmentManager(), mMVAreaItemBean);
        mViewPager.setAdapter(mMVPageAdapter);

        //TabLayout关联ViewPager
        mTabLayout.setupWithViewPager(mViewPager);


        String url = URLProviderUtil.getMVareaUrl();
        new MVAreaRequest(url, mListNetworkListener).execute();
    }

    private NetworkListener<List<MVAreaItemBean>> mListNetworkListener = new NetworkListener<List<MVAreaItemBean>>() {
        @Override
        public void onFailed(String s) {

        }

        @Override
        public void onSuccess(List<MVAreaItemBean> mvAreaItemBeen) {
            mMVAreaItemBean.addAll(mvAreaItemBeen);
            //通知adatper更新
            mMVPageAdapter.notifyDataSetChanged();
        }
    };

}
