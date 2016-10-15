package io.github.xudaojie.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xdj on 2016/10/15.
 */

public class MyLinearLayoutManager extends RecyclerView.LayoutManager {
    private static final String TAG = MyLinearLayoutManager.class.getSimpleName();

    private int mHeight;
    private int mValidOffset;

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        if (getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
        }

        detachAndScrapAttachedViews(recycler);
        //定义竖直方向的偏移量
        int offsetY = 0;
        for (int i = 0; i < getItemCount(); i++) {
            //这里就是从缓存里面取出
            View view = recycler.getViewForPosition(i);
            //将View加入到RecyclerView中
            addView(view);
            //对子View进行测量
            measureChildWithMargins(view, 0, 0);
            //把宽高拿到，宽高都是包含ItemDecorate的尺寸
            int width = getDecoratedMeasuredWidth(view);
            int height = getDecoratedMeasuredHeight(view);
            //最后，将View布局
            layoutDecorated(view, 0, offsetY, width, offsetY + height);
            //将竖直方向偏移量增大height
            offsetY += height;
        }
        mHeight = offsetY;
    }

    @Override
    public boolean canScrollVertically() {
        return true;
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(dy, recycler, state);
    }


    int scrollBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Log.d(TAG, mValidOffset + " + " + dy);
        int scrolled = dy;

        if (mValidOffset + dy > mHeight - getHeight()) {
            scrolled = mHeight - mValidOffset - getHeight();
        } else if (mValidOffset + dy < 0) {
            scrolled = -mValidOffset;
        }
        mValidOffset += scrolled;

        offsetChildrenVertical(-scrolled);
        return scrolled;
    }
}
