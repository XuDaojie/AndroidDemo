package com.example.xdj.androiddemo.recyclerviewsample;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.xdj.androiddemo.BaseActivity;
import com.example.xdj.androiddemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;

/**
 * Created by xdj on 16/6/13.
 */
public class ScrollRecyclerActivity extends BaseActivity {
    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;

    private SectionedRecyclerViewAdapter mSectionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_recycler_activity);
        ButterKnife.bind(this);
//        recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
//        recyclerView.setAdapter(new RecyclerAdapter());

        // ExpandableGridView 与 NestedScrollView嵌套时会卡顿
        mSectionAdapter = new SectionedRecyclerViewAdapter();
        for (int i = 0; i < 10; i++) {
            mSectionAdapter.addSection(new ExpandableMovieSection("Group" + i));
        }

        GridLayoutManager layoutManager = new GridLayoutManager(mContext, 3);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch(mSectionAdapter.getSectionItemViewType(position)) {
                    case SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER:
                        return 2;
                    default:
                        return 1;
                }
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mSectionAdapter);
    }


    class ExpandableMovieSection extends StatelessSection {

        String title;
        String[] data = new String[]{
                "yyy", "xxx", "zzzz"
        };
        boolean expanded = true;

        public ExpandableMovieSection(String title) {
            super(R.layout.recycler_item, R.layout.recycler_item);

            this.title = title;
        }

        @Override
        public int getContentItemsTotal() {
            return expanded ? data.length : 0;
        }

        @Override
        public RecyclerView.ViewHolder getItemViewHolder(View view) {
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
            final ItemViewHolder itemHolder = (ItemViewHolder) holder;

            itemHolder.mTextTv.setText(data[position]);
        }

        @Override
        public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
            final ItemViewHolder headerHolder = (ItemViewHolder) holder;

            headerHolder.mTextTv.setText(title);

            headerHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    expanded = !expanded;
//                    headerHolder.imgArrow.setImageResource(
//                            expanded ? R.drawable.ic_keyboard_arrow_up_black_18dp : R.drawable.ic_keyboard_arrow_down_black_18dp
//                    );
                    mSectionAdapter.notifyDataSetChanged();
                }
            });
        }

        class ItemViewHolder extends RecyclerView.ViewHolder {
            @Bind(R.id.text_tv)
            TextView mTextTv;

            ItemViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
            }
        }
    }
}
