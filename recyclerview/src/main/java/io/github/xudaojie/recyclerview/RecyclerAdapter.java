package io.github.xudaojie.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xdj on 16/6/13.
 */

public class RecyclerAdapter extends RecyclerView.Adapter {

    private static final String TAG = RecyclerAdapter.class.getSimpleName();

    List<String> mData = new ArrayList<>();

    public RecyclerAdapter() {
        for (int i = 0; i < 30; i++) {
            mData.add("text" + i);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        Log.d(TAG, "onCreateViewHolder " + view.toString());
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.textTv.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textTv;

        MyViewHolder(View view) {
            super(view);
            textTv = (TextView) view.findViewById(R.id.text_tv);
        }
    }
}
