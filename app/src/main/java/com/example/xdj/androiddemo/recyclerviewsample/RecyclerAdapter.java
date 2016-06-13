package com.example.xdj.androiddemo.recyclerviewsample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xdj.androiddemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xdj on 16/6/13.
 */

public class RecyclerAdapter extends RecyclerView.Adapter {

    String[] mData = new String[30];

    public RecyclerAdapter() {
        for (int i = 0; i < mData.length; i++) {
            mData[i] = "text" + i;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.textTv.setText(mData[position]);
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.text_tv)
        TextView textTv;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
