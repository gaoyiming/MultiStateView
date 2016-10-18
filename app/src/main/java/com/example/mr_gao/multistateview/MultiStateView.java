package com.example.mr_gao.multistateview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

/**
 * @ClassName: MultiStateView
 * @Description: ${TODO}
 * @author: Mr_gao
 * @date: 2016/10/18 22:13
 */
public class MultiStateView extends FrameLayout {
    private  Context context;

    public MultiStateView(Context context) {
        this(context,null);
    }

    public MultiStateView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MultiStateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MultiStateView, 0, 0);
        int empty_layout = typedArray.getResourceId(R.styleable.MultiStateView_emptylayout, R.layout.empty_layout);
        int loading_layout = typedArray.getResourceId(R.styleable.MultiStateView_loadinglayout, R.layout.loading_layout);
        int nonet_layout = typedArray.getResourceId(R.styleable.MultiStateView_nonoetlayout, R.layout.nonet_layout);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        layoutInflater.inflate(empty_layout,this,true);
        layoutInflater.inflate(loading_layout,this,true);
        layoutInflater.inflate(nonet_layout,this,true);
    }


    public MultiStateView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    public void showEmptyView(){

    }
    public void showLoadingView(){

    }
    public void showNoNetView(){

    }
    public void showContentView(){

    }
    public void GoneAllViews(){

    }
}
