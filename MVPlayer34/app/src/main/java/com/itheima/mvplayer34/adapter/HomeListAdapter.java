package com.itheima.mvplayer34.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.itheima.mvplayer34.model.HomeListItemBean;
import com.itheima.mvplayer34.widget.HomeListItemView;

import java.util.List;

/**
 * Created by Leon on 2017/1/15.
 */

public class HomeListAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<HomeListItemBean> mHomeListItems;

    public HomeListAdapter(Context context) {
        mContext = context;
    }

    public HomeListAdapter(Context context, List<HomeListItemBean> homeListItems) {
        mContext = context;
        mHomeListItems = homeListItems;
    }

    /**
     * 创建ViewHolder, holder里面要holder一个view
     * @param parent
     * @param viewType
     * @return 返回RecyclerView定义的ViewHolder
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeListItemViewHolder(new HomeListItemView(mContext));
    }

    /**
     * 绑定ViewHolder， 拿到position对应位置的数据来刷新holder hold住的item
     * @param holder
     * @param position item的位置
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((HomeListItemView)holder.itemView).bindView(mHomeListItems.get(position));
    }

    /**
     * 返回item个数 通ListView getCount
     * @return
     */
    @Override
    public int getItemCount() {
        return mHomeListItems.size();
    }

    public class HomeListItemViewHolder extends RecyclerView.ViewHolder {

        /**
         *
         * @param itemView ViewHolder要hold住的view
         */
        public HomeListItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
