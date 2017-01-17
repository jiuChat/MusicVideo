package com.itheima.mvplayer34.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.itheima.mvplayer34.R;
import com.itheima.mvplayer34.model.HomeListItemBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Leon on 2017/1/15.
 */

public class HomeListItemView extends RelativeLayout {

    @BindView(R.id.mv_image)
    ImageView mMvImage;
    @BindView(R.id.home_page_video_icon)
    ImageView mHomePageVideoIcon;
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.description)
    TextView mDescription;

    /**
     * 代码里面new 一个view时会调用
     *
     * @param context
     */
    public HomeListItemView(Context context) {
        this(context, null);
    }

    /**
     * xml 里面解析view时会找带两个参数构造方法创建view, 创建view后才能通过findViewById找到
     *
     * @param context
     * @param attrs
     */
    public HomeListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        //初始化布局
        LayoutInflater.from(getContext()).inflate(R.layout.view_home_list_item, this);
        ButterKnife.bind(this, this);//target: 绑定的类， view：绑定的view
    }

    public void bindView(HomeListItemBean homeListItemBean) {
        //更新标题
        mTitle.setText(homeListItemBean.getTitle());
        //更新描述
        mDescription.setText(homeListItemBean.getDescription());

        Glide.with(getContext()).load(homeListItemBean.getPosterPic()).centerCrop().into(mMvImage);
    }
}
