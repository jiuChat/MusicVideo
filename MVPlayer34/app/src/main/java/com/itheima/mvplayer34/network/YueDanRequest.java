package com.itheima.mvplayer34.network;

import com.itheima.leon.funhttplib.NetworkListener;
import com.itheima.leon.funhttplib.Request;
import com.itheima.mvplayer34.model.YueDanBean;

/**
 * Created by Leon on 2017/1/16.
 */

public class YueDanRequest extends Request<YueDanBean> {

    public YueDanRequest(String url, NetworkListener listener) {
        super(url, listener);
    }
}
