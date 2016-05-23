package com.example.xdj.androiddemo.supportdesign;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xdj.androiddemo.R;

import java.util.ArrayList;

/**
 * Created by xdj on 16/1/12.
 */
public class CoordinatorActivity extends AppCompatActivity {
    private Context mContext;

    private Toolbar mToobar;
    private TabLayout mTabLayout;
    private RecyclerView mContainer;
    private ArrayList<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.coordinator_activity);
        mToobar = (Toolbar) findViewById(R.id.toolbar);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mContainer = (RecyclerView) findViewById(R.id.container);
        mToobar.setTitle("Title");
        init();
    }

    private void init() {
        mData = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mData.add(i + "");
        }
        mContainer.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mContainer.setAdapter(new ListAdapter());
    }

    class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

        @Override
        public ListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_1, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ListAdapter.MyViewHolder holder, int position) {
            holder.text1.setText(mData.get(position));
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView text1;

            public MyViewHolder(View itemView) {
                super(itemView);
                text1 = (TextView) itemView.findViewById(android.R.id.text1);
            }
        }
    }
}
