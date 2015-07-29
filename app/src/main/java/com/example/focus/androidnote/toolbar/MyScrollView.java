package com.example.focus.androidnote.toolbar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by focus on 15/7/29.
 * 通过此子类实现监听SrollView的滚动事件
 */
public class MyScrollView extends ScrollView {
    private ScrollViewListener scrollViewListener;

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (scrollViewListener != null) {
            scrollViewListener.onScrollChanged(l, t, oldl, oldt);
        }
    }

    public interface ScrollViewListener {
        void onScrollChanged(int x, int y, int oldxX, int oldY);
    }
}
