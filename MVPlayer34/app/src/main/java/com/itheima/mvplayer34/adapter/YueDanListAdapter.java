package com.itheima.mvplayer34.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.itheima.mvplayer34.model.YueDanBean;
import com.itheima.mvplayer34.widget.YueDanListItemView;

import java.util.List;

/**
 * Created by Leon on 2017/1/16.
 */

public class YueDanListAdapter extends RecyclerView.Adapter {

    private Context mContext;

    private List<YueDanBean.PlayListsBean> mPlayList;
    public YueDanListAdapter(Context context) {
        mContext = context;
    }

    public YueDanListAdapter(Context context, List<YueDanBean.PlayListsBean> dataList) {
        mContext = context;
        mPlayList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new YueDanListItemViewHolder(new YueDanListItemView(mContext));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((YueDanListItemView)holder.itemView).bindView(mPlayList.get(position));
    }

    @Override
    public int getItemCount() {
        return mPlayList.size();
    }

    public class YueDanListItemViewHolder extends RecyclerView.ViewHolder {

        public YueDanListItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
