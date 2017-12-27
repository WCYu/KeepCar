package com.ysd.keepcar.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ysd.keepcar.R;

/**
 * Created by 阿禹 on 2017/12/6.
 */

public class CustomTool extends LinearLayout {
    private OnLeftButtonClickListener mLeftButtonClickListener;
    private OnRightImgClickListener onRightImgClickListener;
    private OnRightTitleClickListener onRightTitleClick;//
    private MyViewHolder mViewHolder;
    private View viewAppTitle;

    public CustomTool(Context context) {
        this(context, null);
    }

    public CustomTool(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTool(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    //初始化标题
    private void init() {
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        viewAppTitle = inflater.inflate(R.layout.custom_tool, null);
        this.addView(viewAppTitle, layoutParams);

        mViewHolder = new MyViewHolder(this);
        //左边返回监听
        mViewHolder.return_lly.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mLeftButtonClickListener != null) {
                    mLeftButtonClickListener.onLeftButtonClick(view);
                }
            }
        });
        //右边图片监听
        mViewHolder.right_Img.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onRightImgClickListener.onRightImgClick(view);
            }
        });
        //右边标题监听
        mViewHolder.right_Title.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onRightTitleClick.onRightTitleClick(v);
            }
        });
    }

    //是否显示控件
    public void initViewsVisible(boolean isLeftImgVisile, boolean isleftTitleVisile,
                                 boolean isTitleVisile, boolean isRightImgVisile, boolean isRightTitleVisile) {
        // 左侧返回
        mViewHolder.return_img.setVisibility(isLeftImgVisile ? View.VISIBLE : View.INVISIBLE);
        mViewHolder.return_tv.setVisibility(isleftTitleVisile ? View.VISIBLE : View.INVISIBLE);
        mViewHolder.title_tv.setVisibility(isTitleVisile ? View.VISIBLE : View.INVISIBLE);
        mViewHolder.right_Img.setVisibility(isRightImgVisile ? View.VISIBLE : View.INVISIBLE);
        mViewHolder.right_Title.setVisibility(isRightTitleVisile ? View.VISIBLE : View.GONE);
    }

    //设置标题
    public void setAppTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            mViewHolder.title_tv.setText(title);
        }
    }

    //设置左边文字
    public void setLeftTv(String title) {
        if (!TextUtils.isEmpty(title)) {
            mViewHolder.return_tv.setText(title);
        }
    }

    //设置右边文字
    public void setRightTitle(String text) {
        if (!TextUtils.isEmpty(text)) {
            mViewHolder.right_Title.setText(text);
        }
    }

    //设置右边图片
    public void setRightIcon(int res) {
        if (res != 0) {
            mViewHolder.right_Img.setImageResource(res);
        }
    }

    //设置背景颜色
    public void setAppBackground(int color) {
        viewAppTitle.setBackgroundColor(color);
    }

    //设置左边监听
    public void setOnLeftButtonClickListener(OnLeftButtonClickListener listen) {
        if (listen != null) {
            mLeftButtonClickListener = listen;
        }
    }

    //设置右边图片监听
    public void setOnRightImgClickLisrener(OnRightImgClickListener onRightImgClickListener) {
        if (onRightImgClickListener != null){
            this.onRightImgClickListener = onRightImgClickListener;
        }
    }

    //设置右边文字监听
    public void setOnRightTitleClickListener(OnRightTitleClickListener listen) {
        if (listen != null) {
            onRightTitleClick = listen;
        }
    }

    public interface OnLeftButtonClickListener {
        void onLeftButtonClick(View v);
    }

    public interface OnRightImgClickListener {
        void onRightImgClick(View v);
    }

    //
    public interface OnRightTitleClickListener {
        void onRightTitleClick(View v);
    }

    static class MyViewHolder {
        private ImageView return_img;
        private TextView return_tv;
        private LinearLayout return_lly;
        private TextView title_tv;
        private ImageView right_Img;
        private TextView right_Title;

        public MyViewHolder(View v) {
            return_img = v.findViewById(R.id.Return_img);
            return_tv = v.findViewById(R.id.Return_tv);
            return_lly = v.findViewById(R.id.Return_lly);
            title_tv = v.findViewById(R.id.Title_tv);
            right_Img = v.findViewById(R.id.Right_Img);
            right_Title = v.findViewById(R.id.Right_Title);
        }
    }
}
