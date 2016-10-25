package io.github.xudaojie.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by xdj on 2016/10/20.
 */
// todo undone 未完成
public class MyExpendGridAdapter<T extends RecyclerView.ViewHolder, E extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter {

    private static final int GROUP = 0;
    private static final int CHILD = 1;

    private List<Integer> mGroupPositions;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (GROUP == position) {
            onBindGroupViewHolder((E) holder, position);
        } else {
            onBindGroupViewHolder((E) holder, position);
        }
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
            return GROUP;
        } else {
            // todo 二分排序
            for (int i = 0; i < mGroupPositions.size() - 2; i++) {
                int left = mGroupPositions.get(i);
                int right = mGroupPositions.get(i + 1);
                if (left < position && right < position) {
                    return CHILD;
                }
            }
        }
//        return super.getItemViewType(position);
        // TODO: 2016/10/23
        return 0;
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

    public void onBindChildViewHolder(E holder, int position) {

    }

    public void onBindGroupViewHolder(E holder, int position) {
    }

    /**
     *
     * @param array 数组
     * @param value 需查询数字
     */
    private void binarySearch(int[] array, int value) {
        int leftPos = 0;
        int rightPos = array.length - 1;

        while (leftPos <= rightPos) {
            
        }
    }
}
