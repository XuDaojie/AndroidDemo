package io.github.xudaojie.recyclerview;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import java.util.List;

/**
 * Created by xdj on 16/8/25.
 */

public class MyDiffCallBack extends DiffUtil.Callback {

    private List<String> mOldData;
    private List<String> mNewData;

    @Override
    public int getOldListSize() {
        return mOldData.size();
    }

    @Override
    public int getNewListSize() {
        return mOldData.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return false;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return false;
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
