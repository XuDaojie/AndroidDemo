package com.example.xdj.androiddemo.recyclerviewsample;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.xdj.androiddemo.BaseActivity;
import com.example.xdj.androiddemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xdj on 16/6/13.
 */
public class ScrollRecyclerActivity extends BaseActivity {
    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_recycler_activity);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new RecyclerAdapter());
    }

}
