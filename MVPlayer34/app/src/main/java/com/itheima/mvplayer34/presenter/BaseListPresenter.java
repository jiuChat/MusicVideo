package com.itheima.mvplayer34.presenter;

import java.util.List;

/**
 * Created by Leon on 2017/1/16.
 */

public interface BaseListPresenter<T> {
    //定义更UI不相关的业务逻辑
    //初始化加载数据
    void loadDataList();

    //刷新
    void refresh();

    //加载更多
    void loadMoreData();

    /**
     * 返回数据集合
     * @return
     */
    List<T> getDataList();
}
