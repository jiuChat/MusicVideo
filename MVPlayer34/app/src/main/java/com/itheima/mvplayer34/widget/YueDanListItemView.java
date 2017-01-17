package com.itheima.mvplayer34.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.itheima.mvplayer34.R;
import com.itheima.mvplayer34.model.YueDanBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by Leon on 2017/1/16.
 */

public class YueDanListItemView extends RelativeLayout {

    @BindView(R.id.mv_image)
    ImageView mMvImage;
    @BindView(R.id.avatar)
    ImageView mAvatar;
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.author)
    TextView mAuthor;
    @BindView(R.id.mv_count)
    TextView mMvCount;

    public YueDanListItemView(Context context) {
        this(context, null);
    }

    public YueDanListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yue_list_item, this);
        ButterKnife.bind(this, this);
    }

    public void bindView(YueDanBean.PlayListsBean playListsBean) {
        //刷新标题
        mTitle.setText(playListsBean.getTitle());
        //刷新悦单创建者昵称
        mAuthor.setText(playListsBean.getCreator().getNickName());
        //刷新mv个数
        String count = String.format(getContext().getString(R.string.mv_count), playListsBean.getVideoCount());//格式化字符串
        mMvCount.setText(count);
        //刷新头像
        Glide.with(getContext())
                .load(playListsBean.getCreator()
                        .getLargeAvatar())
                .bitmapTransform(new CropCircleTransformation(getContext())).into(mAvatar);
        //刷新背景图
        Glide.with(getContext()).load(playListsBean.getPlayListBigPic()).centerCrop().into(mMvImage);
    }
}
