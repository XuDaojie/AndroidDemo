package io.github.xudaojie.androiddemo.recyclerviewsample;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import io.github.xudaojie.androiddemo.BaseActivity;
import io.github.xudaojie.androiddemo.BuildConfig;
import io.github.xudaojie.androiddemo.R;

/**
 * Created by xdj on 16/1/16.
 */
public class RecyclerGridActivity extends BaseActivity {
    private RecyclerView mContainer;
    private ArrayList<String> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_activity);
        mContainer = (RecyclerView) findViewById(R.id.container);
        initData();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2);
        mContainer.setAdapter(new GridAdapter());
        mContainer.setLayoutManager(gridLayoutManager);
        mContainer.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE);
                if (BuildConfig.DEBUG) Log.d("RecyclerGridActivity", "滑动后静止");
            }

        });
    }

    private void initData() {
        String[] data = new String[50];
        for (int i = 0; i < data.length; i++) {
            data[i] = (char) ('A' + i) + "";
        }
        mData = new ArrayList<> (Arrays.asList(data));
    }

    class GridAdapter extends RecyclerView.Adapter<GridAdapter.MyViewHolder> {

        @Override
        public GridAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.textView.setText(mData.get(position));
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView textView;

            public MyViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.text_tv);
            }
        }
    }
}
