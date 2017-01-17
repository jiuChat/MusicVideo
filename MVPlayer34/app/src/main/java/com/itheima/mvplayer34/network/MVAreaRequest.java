package com.itheima.mvplayer34.network;

import com.itheima.leon.funhttplib.NetworkListener;
import com.itheima.leon.funhttplib.Request;
import com.itheima.mvplayer34.model.MVAreaItemBean;

import java.util.List;

/**
 * Created by Leon on 2017/1/16.
 */

public class MVAreaRequest extends Request<List<MVAreaItemBean>> {

    public MVAreaRequest(String url, NetworkListener listener) {
        super(url, listener);
    }
}
