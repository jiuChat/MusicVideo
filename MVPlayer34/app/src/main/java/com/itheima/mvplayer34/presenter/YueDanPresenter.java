package com.itheima.mvplayer34.presenter;

import com.itheima.mvplayer34.model.YueDanBean;

import java.util.List;

/**
 * Created by Leon on 2017/1/16.
 */

public interface YueDanPresenter {

    //定义业务逻辑
    void loadDataList();

    List<YueDanBean.PlayListsBean> getDataList();

    void refresh();

    void loadMoreData();
}
