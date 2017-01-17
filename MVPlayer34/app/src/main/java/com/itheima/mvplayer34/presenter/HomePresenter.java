package com.itheima.mvplayer34.presenter;

/**
 * Created by Leon on 2017/1/16.
 */

import com.itheima.mvplayer34.model.HomeListItemBean;

import java.util.List;

/**
 * 对应HomeFragment的presenter
 */
public interface HomePresenter {
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
    List<HomeListItemBean> getDataList();
}
