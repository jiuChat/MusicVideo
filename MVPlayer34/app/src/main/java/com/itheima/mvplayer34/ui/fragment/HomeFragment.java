package com.itheima.mvplayer34.ui.fragment;

import android.support.v7.widget.RecyclerView;

import com.itheima.mvplayer34.adapter.HomeListAdapter;
import com.itheima.mvplayer34.presenter.BaseListPresenter;
import com.itheima.mvplayer34.presenter.impl.HomePresenterImpl;
import com.itheima.mvplayer34.view.BaseListView;

/**
 * Created by Leon on 2017/1/15.
 */

public class HomeFragment extends BaseListFragment{

    private BaseListPresenter mBaseListPresenter;

    @Override
    public RecyclerView.Adapter getAdapter() {
        return new HomeListAdapter(getContext(), mBaseListPresenter.getDataList());
    }

    @Override
    public BaseListPresenter getPresenter(BaseListView baseListView) {
        mBaseListPresenter = new HomePresenterImpl(baseListView);
        return mBaseListPresenter;
    }
}
