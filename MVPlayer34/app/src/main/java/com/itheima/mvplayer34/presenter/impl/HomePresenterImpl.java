package com.itheima.mvplayer34.presenter.impl;

import com.itheima.leon.funhttplib.NetworkListener;
import com.itheima.mvplayer34.model.HomeListItemBean;
import com.itheima.mvplayer34.network.HomeRequest;
import com.itheima.mvplayer34.presenter.BaseListPresenter;
import com.itheima.mvplayer34.utils.URLProviderUtil;
import com.itheima.mvplayer34.view.BaseListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leon on 2017/1/16.
 */

public class HomePresenterImpl implements BaseListPresenter<HomeListItemBean> {

    private static final String TAG = "HomePresenterImpl";

    private List<HomeListItemBean> mHomeListItems;

    private BaseListView mHomeView;//Presenter层要持有一个View层的引用

    public HomePresenterImpl(BaseListView homeView) {
        mHomeListItems = new ArrayList<HomeListItemBean>();
        mHomeView = homeView;
    }


    @Override
    public void loadDataList() {
        loadDataList(0);
    }

    @Override
    public void refresh() {
        mHomeListItems.clear();
        loadDataList(0);
    }

    @Override
    public void loadMoreData() {
        loadDataList(mHomeListItems.size());
    }

    @Override
    public List<HomeListItemBean> getDataList() {
        return mHomeListItems;
    }

    private void loadDataList(int offset) {
        String url = URLProviderUtil.getHomeUrl(offset, 10);
        new HomeRequest(url, mListNetworkListener).execute();
    }

    private NetworkListener<List<HomeListItemBean>> mListNetworkListener = new NetworkListener<List<HomeListItemBean>>() {
        @Override
        public void onFailed(String s) {
            mHomeView.onDataLoadedFailed();
        }

        @Override
        public void onSuccess(List<HomeListItemBean> homeListItemBeen) {
            mHomeListItems.addAll(homeListItemBeen);
            mHomeView.onDataLoadedSuccess();
        }
    };
}
