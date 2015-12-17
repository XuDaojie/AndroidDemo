package com.example.focus.androidnote.recyclerviewsample;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

import com.example.focus.androidnote.BaseActivity;
import com.example.focus.androidnote.R;

import java.util.ArrayList;
import java.util.Arrays;

import jp.wasabeef.recyclerview.animators.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.adapters.SlideInLeftAnimationAdapter;

/**
 * Created by xdj on 15/12/9.
 */
public class RecyclerViewActivity extends BaseActivity {
    private RecyclerView mContainer;
    private ArrayList<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        mContainer = (RecyclerView) findViewById(R.id.container);

        initData();
        mContainer.setLayoutManager(new LinearLayoutManager(mContext));
//        mContainer.setItemAnimator(new DefaultItemAnimator());
//        mContainer.setAdapter(new SampleAdapter());
        AlphaInAnimationAdapter adapter = new AlphaInAnimationAdapter(new SampleAdapter());
        adapter.setFirstOnly(false);
        adapter.setInterpolator(new OvershootInterpolator());
        mContainer.setAdapter(adapter);
    }

    private void initData() {
        String[] data = new String[26];
        for (int i = 0; i < data.length; i++) {
            data[i] = (char) ('A' + i) + "";
        }
        mData = new ArrayList<> (Arrays.asList(data));
    }

    class SampleAdapter extends RecyclerView.Adapter {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            RecyclerView.ViewHolder viewHolder = LayoutInflater.from(mContext)
//                    .inflate(R.layout.recycler_item, parent, false);
            View view = LayoutInflater.from(mContext)
                    .inflate(R.layout.recycler_item, parent, false);
            ViewHolder viewHolder = new SampleViewHolder(view);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            SampleViewHolder viewHolder = (SampleViewHolder) holder;
            viewHolder.textView.setText(mData.get(position));
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        class SampleViewHolder extends RecyclerView.ViewHolder {
            TextView textView;

            public SampleViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.text_tv);
            }
        }
    }
}
