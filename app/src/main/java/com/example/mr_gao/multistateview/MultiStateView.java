package com.example.mr_gao.multistateview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.CollapsingToolbarLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * @ClassName: MultiStateView
 * @Description: ${TODO}
 * @author: Mr_gao
 * @date: 2016/10/18 22:13
 */
public class MultiStateView extends FrameLayout {
    private static final int EMPTYVIEW = 1;
    private static final int LOADINGVIEW = 2;
    private static final int NONETVIEW = 3;
    private static final int ALLVIEW = 4;
    private Context context;
    private View emptyView;
    private View loadingView;
    private View noNetView;
    private LayoutParams layoutParams;

    public MultiStateView(Context context) {
        this(context, null);
    }

    public MultiStateView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MultiStateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MultiStateView, 0, 0);
        int empty_layout = typedArray.getResourceId(R.styleable.MultiStateView_emptylayout, R.layout.empty_layout);
        int loading_layout = typedArray.getResourceId(R.styleable.MultiStateView_loadinglayout, R.layout.loading_layout);
        int nonet_layout = typedArray.getResourceId(R.styleable.MultiStateView_nonoetlayout, R.layout.nonet_layout);
        layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        emptyView = View.inflate(context, empty_layout,null);
        loadingView = View.inflate(context, loading_layout,null);
        noNetView = View.inflate(context, nonet_layout,null);
        addView(emptyView,layoutParams);
        addView(loadingView,layoutParams);
        addView(noNetView,layoutParams);
//        emptyView = layoutInflater.inflate(empty_layout, this, true);
//        loadingView = layoutInflater.inflate(loading_layout, this, true);
//        noNetView = layoutInflater.inflate(nonet_layout, this, true);
    }


    public MultiStateView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void showEmptyView() {
        GoneOtherViews(EMPTYVIEW);
    }

    public void showLoadingView() {
        GoneOtherViews(LOADINGVIEW);
    }

    public void showNoNetView() {
        GoneOtherViews(NONETVIEW);
    }

    public void showContentView(View view) {
        GoneOtherViews(ALLVIEW);
      //  addView(view, layoutParams);
    }

    public void GoneOtherViews(int ViewTag) {
        switch (ViewTag) {
            case EMPTYVIEW:
                emptyView.setVisibility(VISIBLE);
                loadingView.setVisibility(INVISIBLE);
                noNetView.setVisibility(INVISIBLE);
                break;
            case LOADINGVIEW:
                emptyView.setVisibility(INVISIBLE);
                loadingView.setVisibility(VISIBLE);
                noNetView.setVisibility(INVISIBLE);
                break;
            case NONETVIEW:
                emptyView.setVisibility(INVISIBLE);
                loadingView.setVisibility(INVISIBLE);
                noNetView.setVisibility(VISIBLE);
                break;
            case ALLVIEW:
                emptyView.setVisibility(INVISIBLE);
                loadingView.setVisibility(INVISIBLE);
                noNetView.setVisibility(INVISIBLE);
                break;

        }


    }
}
