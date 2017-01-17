package com.itheima.mvplayer34.view;

/**
 * Created by Leon on 2017/1/16.
 */

/**
 * BaseListFragment对应的view
 */

public interface BaseListView {
    //数据加载成功后的回调
    void onDataLoadedSuccess();
    //数据加载失败
    void onDataLoadedFailed();
    //定义ui层相关的逻辑
}
