package com.itheima.mvplayer34.presenter.impl;

import com.itheima.leon.funhttplib.NetworkListener;
import com.itheima.mvplayer34.model.YueDanBean;
import com.itheima.mvplayer34.network.YueDanRequest;
import com.itheima.mvplayer34.presenter.BaseListPresenter;
import com.itheima.mvplayer34.utils.URLProviderUtil;
import com.itheima.mvplayer34.view.BaseListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leon on 2017/1/16.
 */

public class YueDanPresenterImpl implements BaseListPresenter<YueDanBean.PlayListsBean> {

    private BaseListView mYueDanView;

    private List<YueDanBean.PlayListsBean> mDataList;

    public YueDanPresenterImpl(BaseListView yueDanView) {
        mYueDanView = yueDanView;
        mDataList = new ArrayList<YueDanBean.PlayListsBean>();
    }

    @Override
    public void loadDataList() {
        loadDataList(0);
    }

    @Override
    public List<YueDanBean.PlayListsBean> getDataList() {
        return mDataList;
    }

    @Override
    public void refresh() {
        mDataList.clear();
        loadDataList();
    }

    @Override
    public void loadMoreData() {
        loadDataList(mDataList.size());
    }

    private void loadDataList(int offset) {
        String url = URLProviderUtil.getYueDanUrl(offset, 10);
        new YueDanRequest(url, mYueDanBeanNetworkListener).execute();
    }

    private NetworkListener<YueDanBean> mYueDanBeanNetworkListener = new NetworkListener<YueDanBean>() {
        @Override
        public void onFailed(String s) {
            mYueDanView.onDataLoadedFailed();
        }

        @Override
        public void onSuccess(YueDanBean yueDanBean) {
            //将网络请求的结果加入到数据集合
            mDataList.addAll(yueDanBean.getPlayLists());
            //通知view层数据加载成功
            mYueDanView.onDataLoadedSuccess();
        }
    };
}
