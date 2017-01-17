package com.itheima.mvplayer34.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.itheima.mvplayer34.R;
import com.itheima.mvplayer34.presenter.BaseListPresenter;
import com.itheima.mvplayer34.view.BaseListView;

import butterknife.BindView;

/**
 * Created by Leon on 2017/1/16.
 */

/**
 * 将相同的功能 布局 和属性抽取出来，不同实现交给子类实现
 *
 * 抽取公共的布局 SwipeRefreshLayout和RecyclerView
 * 公共业务逻辑： 初始化时加载数据 下拉刷新 加载更多数据
 *
 * 不同点：每个界面的adapter不一样
 * 网络数据不一样， 不同presenter的实现
 */
public abstract class BaseListFragment extends BaseFragment implements BaseListView{

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private BaseListPresenter mBaseListPresenter;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_base_list;
    }

    @Override
    protected void init() {
        super.init();
        //初始化Presenter
        mBaseListPresenter = getPresenter(this);

        //转一圈换一种颜色
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.setOnRefreshListener(mOnRefreshListener);

        //初始化RecyclerView
        initRecyclerView();

        //加载数据
        mBaseListPresenter.loadDataList();

    }

    private void initRecyclerView() {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);//RecyclerView的大小如果是固定的，则需设置，内部会做相应的优化
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));//设置布局管理器
        //给Adapter传入数据集合,初始化集合大小为0
        mRecyclerView.setAdapter(getAdapter());//设置Adapter
        mRecyclerView.addOnScrollListener(mOnScrollListener);
    }


    /**
     * 目标判断是否滚动到底部
     */
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {

        /**
         * 滚动状态发生变化
         *
         * @param recyclerView
         * @param newState
         */
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            //只在空闲状态检查是否滚动到底部
            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                //可见item位置为最后一个item的位置
               if (layoutManager.findLastVisibleItemPosition() == mBaseListPresenter.getDataList().size() - 1) {
                    //滑动到底部
                    //加载更多数据
                    mBaseListPresenter.loadMoreData();
                }

            }
                super.onScrollStateChanged(recyclerView, newState);
            }
        };

    private SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            mBaseListPresenter.refresh();
        }
    };

    /**
     * 子类必须返回一个Adapter
     * @return
     */
    public abstract RecyclerView.Adapter getAdapter();


    /**
     * 子类返回一个具体presenter
     * @return
     */
    public abstract BaseListPresenter getPresenter(BaseListView baseListView);


    @Override
    public void onDataLoadedFailed() {
        Toast.makeText(getContext(), "数据加载失败", Toast.LENGTH_SHORT).show();
   }

    @Override
    public void onDataLoadedSuccess() {
        Toast.makeText(getContext(), "数据加载成功", Toast.LENGTH_SHORT).show();
        mRecyclerView.getAdapter().notifyDataSetChanged();//通知刷新列表
        mSwipeRefreshLayout.setRefreshing(false);//隐藏刷新头
    }

}
