package com.itheima.mvplayer34.ui.fragment;

import android.support.v7.widget.RecyclerView;

import com.itheima.mvplayer34.adapter.YueDanListAdapter;
import com.itheima.mvplayer34.presenter.BaseListPresenter;
import com.itheima.mvplayer34.presenter.impl.YueDanPresenterImpl;
import com.itheima.mvplayer34.view.BaseListView;

/**
 * Created by Leon on 2017/1/15.
 */

public class YueDanFragment extends BaseListFragment{

    private YueDanPresenterImpl mYueDanPresenter;

    @Override
    public RecyclerView.Adapter getAdapter() {
        return new YueDanListAdapter(getContext(), mYueDanPresenter.getDataList());
    }

    @Override
    public BaseListPresenter getPresenter(BaseListView baseListView) {
        mYueDanPresenter = new YueDanPresenterImpl(baseListView);
        return mYueDanPresenter;
    }
}