package io.github.xudaojie.recyclerview;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xdj on 2016/10/15.
 */

public class MyLinearLayoutManager extends RecyclerView.LayoutManager {
    private static final String TAG = MyLinearLayoutManager.class.getSimpleName();

    private int mTotalOffsetY;
    private int mValidOffset;

    private SparseArray<Rect> mItemFrames = new SparseArray<>();

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
            //这里就是从缓存里面取出 如果缓存中不存在则会创建新的ViewHolder
            View view = recycler.getViewForPosition(i);
            Log.d(TAG, "--" + view.toString());
            //将View加入到RecyclerView中
            addView(view);
            //对子View进行测量
            measureChildWithMargins(view, 0, 0);
            //把宽高拿到，宽高都是包含ItemDecorate的尺寸
            int width = getDecoratedMeasuredWidth(view);
            int height = getDecoratedMeasuredHeight(view);
            //最后，将View布局
            layoutDecorated(view, 0, offsetY, width, offsetY + height);

            Rect frame = mItemFrames.get(i);
            if (frame == null) {
                frame = new Rect();
            }
            frame.set(0, offsetY, width, offsetY + height);
            mItemFrames.put(i, frame);

            //将竖直方向偏移量增大height
            offsetY += height;
        }
        mTotalOffsetY = offsetY;
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
//        Log.d(TAG, mValidOffset + " + " + dy);
        // 将所有子View加入缓存
        detachAndScrapAttachedViews(recycler);

        int scrolled = dy;

        if (mValidOffset + dy > mTotalOffsetY - getHeight()) {
            scrolled = mTotalOffsetY - mValidOffset - getHeight();
        } else if (mValidOffset + dy < 0) {
            scrolled = -mValidOffset;
        }
        mValidOffset += scrolled;

        offsetChildrenVertical(-scrolled);

        // todo ?? 跳过preLayout，preLayout主要用于支持动画
        if (!state.isPreLayout()) {
            // 回收未显示的View，并显示新的View
            Rect displayRect = new Rect(0, mValidOffset, getHorizontalSpace(), mValidOffset + getVerticalSpace());
            Log.d(TAG, 0 + ", " + mValidOffset + ", " + getHorizontalSpace() + ", " + (mValidOffset + getVerticalSpace()));
            Rect childRect = new Rect();
            Log.d(TAG, "remove before --getChildCount " + getChildCount() + " " + "getItemCount" + getItemCount());
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                childRect.left = getDecoratedLeft(child);
                childRect.top = getDecoratedTop(child);
                childRect.right = getDecoratedRight(child);
                childRect.bottom = getDecoratedBottom(child);

                if (!Rect.intersects(displayRect, childRect)) {
                    removeAndRecycleView(child, recycler);
                }
            }
            Log.d(TAG, "remove after --getChildCount " + getChildCount() + " " + "getItemCount" + getItemCount());

            for (int i = 0; i < getItemCount(); i++) {
                if (Rect.intersects(displayRect, mItemFrames.get(i))) {
                    //
                    View scrap = recycler.getViewForPosition(i);
                    measureChildWithMargins(scrap, 0, 0);
                    addView(scrap);

                    Rect frame = mItemFrames.get(i);
                    layoutDecorated(
                            scrap,
                            frame.left,
                            frame.top - mValidOffset,
                            frame.right,
                            frame.bottom - mValidOffset);
                }
            }
            Log.d(TAG, "getChildCount " + getChildCount() + " " + "getItemCount" + getItemCount());
        }

        return scrolled;
    }

    private int getHorizontalSpace() {
        return getWidth() - getPaddingRight() - getPaddingLeft();
    }

    private int getVerticalSpace() {
        return getHeight() - getPaddingBottom() - getPaddingTop();
    }
}
