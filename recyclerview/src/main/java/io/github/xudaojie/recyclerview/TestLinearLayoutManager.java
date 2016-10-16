package io.github.xudaojie.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by xdj on 2016/10/16.
 */

public class TestLinearLayoutManager extends LinearLayoutManager {
    private static final String TAG = "TestLinearLayoutManager";

    public TestLinearLayoutManager(Context context) {
        super(context);
    }

    public TestLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public TestLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Log.d(TAG, "getChildCount " + getChildCount() + " getItemCount" + getItemCount());
        return super.scrollVerticallyBy(dy, recycler, state);
    }
}
