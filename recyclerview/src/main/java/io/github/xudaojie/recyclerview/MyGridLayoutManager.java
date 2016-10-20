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

public class MyGridLayoutManager extends RecyclerView.LayoutManager {
    private static final String TAG = MyGridLayoutManager.class.getSimpleName();

    private int mTotalOffsetY;
    private int mValidOffset;

    private SparseArray<Rect> mItemFrames = new SparseArray<>();

    public int mSpanCount;

    public MyGridLayoutManager(int spanCount) {
        mSpanCount = spanCount;
    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        return super.generateLayoutParams(lp);
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
        int gridPosition = 0;
        int offsetY = 0;
        // 所有item等高等宽
        View childView = recycler.getViewForPosition(0);
        measureChildWithMargins(childView, 0, 0);
        // 网格
        int groupWidth = getDecoratedMeasuredWidth(childView);
        int childWidth = getHorizontalSpace() / 4;
//        int childWidth = getDecoratedMeasuredWidth(childView);
        int childHeight = getDecoratedMeasuredHeight(childView);
        for (int i = 0; i < getItemCount(); i++) {
            Rect frame = mItemFrames.get(i);
            if (frame == null) {
                frame = new Rect();
            }
            // Child
            frame.set(gridPosition * childWidth, offsetY, gridPosition * childWidth + childWidth, offsetY + childHeight);
            if (gridPosition == mSpanCount - 1) {
                gridPosition = 0;
                offsetY += childHeight;
            } else {
                ++gridPosition;
            }
            // 如果是最后一个
            if (i == (getItemCount() - 1)) {
                offsetY += childHeight;
            }
//            frame.set(0, offsetY, childWidth, offsetY + childHeight);
            //将竖直方向偏移量增大height
            mItemFrames.put(i, frame);
        }
//        mTotalOffsetY = getItemCount() * childHeight;
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
                Rect frame = mItemFrames.get(i);
                if (scrap == null) {
                    scrap = recycler.getViewForPosition(i);
                    // 必须要在计算宽高之前设置
                    RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) scrap.getLayoutParams();
                    lp.width = frame.right - frame.left;
                    scrap.setLayoutParams(lp);

                    // 会触发generateLayoutParams
                    measureChildWithMargins(scrap, 0, 0);
                    addView(scrap);
                } else {
                    // TODO: 2016/10/18
                    recycler.bindViewToPosition(scrap, i);
                    addView(scrap);
                }

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
