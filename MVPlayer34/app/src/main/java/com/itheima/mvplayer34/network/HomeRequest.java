package com.itheima.mvplayer34.network;

import com.itheima.leon.funhttplib.NetworkListener;
import com.itheima.leon.funhttplib.Request;
import com.itheima.mvplayer34.model.HomeListItemBean;

import java.util.List;

/**
 * Created by Leon on 2017/1/16.
 */

public class HomeRequest extends Request<List<HomeListItemBean>> {

    public HomeRequest(String url, NetworkListener listener) {
        super(url, listener);
    }
}
