package io.github.xudaojie.recyclerview;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

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
            return;
        }

        detachAndScrapAttachedViews(recycler);

        //定义竖直方向的偏移量
        int offsetY = 0;
        // 所有item等高等宽
        View childView = recycler.getViewForPosition(0);
        measureChildWithMargins(childView, 0, 0);
        int childWidth = getDecoratedMeasuredWidth(childView);
        int childHeight = getDecoratedMeasuredHeight(childView);
        for (int i = 0; i < getItemCount(); i++) {
//            if (offsetY < getVerticalSpace()) {
//                View view = getChildAt(i);
//                //这里就是从缓存里面取出 如果缓存中不存在则会创建新的ViewHolder
//                if (view == null) {
//                    view = recycler.getViewForPosition(i);
//                }
//                Log.d(TAG, "--" + view.toString());
//                //将View加入到RecyclerView中
//                addView(view);
//                //对子View进行测量
//                measureChildWithMargins(view, 0, 0);
//                //把宽高拿到，宽高都是包含ItemDecorate的尺寸
//                childWidth = getDecoratedMeasuredWidth(view);
//                childHeight = getDecoratedMeasuredHeight(view);
//                //最后，将View布局
//                layoutDecorated(view, 0, offsetY, childWidth, offsetY + childHeight);
//            }

            Rect frame = mItemFrames.get(i);
            if (frame == null) {
                frame = new Rect();
            }
            frame.set(0, offsetY, childWidth, offsetY + childHeight);
            //将竖直方向偏移量增大height
            offsetY += childHeight;
            mItemFrames.put(i, frame);
        }
        mTotalOffsetY = Math.max(offsetY, getHeight());
        fill(recycler, state);
    }

    @Override
    public boolean canScrollVertically() {
        return true;
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
//        return super.scrollVerticallyBy(dy, recycler, state);
        return scrollBy(dy, recycler, state);
    }

//    int scrollBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
//        int scrolled = dy;
//        offsetChildrenVertical(-dy);
//        return scrolled;
//    }

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
//            // 回收未显示的View，并显示新的View
//            Rect displayRect = new Rect(0, mValidOffset, getHorizontalSpace(), mValidOffset + getVerticalSpace());
//            Log.d(TAG, 0 + ", " + mValidOffset + ", " + getHorizontalSpace() + ", " + (mValidOffset + getVerticalSpace()));
//            Rect childRect = new Rect();
//            Log.d(TAG, "remove before --getChildCount " + getChildCount() + " " + "getItemCount" + getItemCount());
//            for (int i = 0; i < getChildCount(); i++) {
//                View child = getChildAt(i);
//                childRect.left = getDecoratedLeft(child);
//                childRect.top = getDecoratedTop(child);
//                childRect.right = getDecoratedRight(child);
//                childRect.bottom = getDecoratedBottom(child);
//
//                if (!Rect.intersects(displayRect, childRect)) {
////                    removeAndRecycleView(child, recycler);
////                    detachAndScrapView(child, recycler);
//                }
//            }
//            Log.d(TAG, "remove after --getChildCount " + getChildCount() + " " + "getItemCount" + getItemCount());
//
//            for (int i = 0; i < getItemCount(); i++) {
//                if (Rect.intersects(displayRect, mItemFrames.get(i))) {
//                    //
//                    View scrap = recycler.getViewForPosition(i);
//                    measureChildWithMargins(scrap, 0, 0);
//                    addView(scrap);
//
//                    Rect frame = mItemFrames.get(i);
//                    layoutDecorated(
//                            scrap,
//                            frame.left,
//                            frame.top - mValidOffset,
//                            frame.right,
//                            frame.bottom - mValidOffset);
//                }
//            }
//            Log.d(TAG, "getChildCount " + getChildCount() + " " + "getItemCount" + getItemCount());
            fill(recycler, state);
        }

        return scrolled;
    }


    void fill(RecyclerView.Recycler recycler, RecyclerView.State state) {
        for (int i = 0; i < getItemCount(); i++) {
            Rect displayRect = new Rect(0,
                    mValidOffset, getHorizontalSpace(),
                    mValidOffset + getVerticalSpace());
            if (Rect.intersects(displayRect, mItemFrames.get(i))) {
                View scrap = nextViewFromScrapList(recycler);
                if (scrap == null) {
                    scrap = recycler.getViewForPosition(i);
                    measureChildWithMargins(scrap, 0, 0);
                    addView(scrap);
                } else {
                    // TODO: 2016/10/18
                    recycler.bindViewToPosition(scrap, i);
                    addView(scrap);
                }
                Rect frame = mItemFrames.get(i);
                layoutDecorated(
                        scrap,
                        frame.left,
                        frame.top - mValidOffset,
                        frame.right,
                        frame.bottom - mValidOffset);
            }
        }
    }

    View nextViewFromScrapList(RecyclerView.Recycler recycler) {
        final List<RecyclerView.ViewHolder> scrapList = recycler.getScrapList();
        final int size = scrapList.size();
        for (int i = 0; i < size; i++) {
            final View view = scrapList.get(i).itemView;
            final RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) view.getLayoutParams();
            if (lp.isItemRemoved()) {
                continue;
            }
            return view;
        }
        return null;
    }

    private int getHorizontalSpace() {
        return getWidth() - getPaddingRight() - getPaddingLeft();
    }

    private int getVerticalSpace() {
        return getHeight() - getPaddingBottom() - getPaddingTop();
    }
}
