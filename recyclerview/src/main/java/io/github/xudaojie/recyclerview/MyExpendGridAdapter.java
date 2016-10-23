package io.github.xudaojie.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by xdj on 2016/10/20.
 */

public class MyExpendGridAdapter<T extends RecyclerView.ViewHolder, E extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter {

    private List<Integer> mGroupPositions;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        int itemCount = 0;
        for (int i = 0; i < getGroupCount(); i++) {
            mGroupPositions.add(itemCount);
            ++itemCount;
            itemCount += getChildCount(i);
        }
        return itemCount;
    }

    @Override
    public int getItemViewType(int position) {
        int groupIdx = mGroupPositions.indexOf(position);
        if (groupIdx != -1) {
            return getGroupType(groupIdx);
        } else {
            // 二分排序
        }
//        return super.getItemViewType(position);
    }

    public int getChildCount(int groupPosition) {
        return 0;
    }

    public int getGroupCount() {
        return 0;
    }

    public Object getGroup(int position) {
        return null;
    }

    public Object getChild(int position) {
        return null;
    }

    public long getGroupId(int position) {
        return 0;
    }

    public long getChildId(int position) {
        return 0;
    }

    public void onCreateGroupViewHolder() {

    }

    public void onBindChildViewHolder(ViewGroup parent, int viewType) {

    }

    public void onBindGroupViewHolder(E holder, int position) {
    }

    public int getGroupType(int position) {
        return 0;
    }

    public int getChildType(int groupPosition, int childPosition) {
        return 1;
    }

}
