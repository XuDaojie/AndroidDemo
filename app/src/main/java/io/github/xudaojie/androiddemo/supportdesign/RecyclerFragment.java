package io.github.xudaojie.androiddemo.supportdesign;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import io.github.xudaojie.androiddemo.R;

/**
 * Created by xdj on 16/1/17.
 */
public class RecyclerFragment extends Fragment {
    private Context mContext;

    private RecyclerView mContainer;
    private ArrayList<String> mData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        View view = inflater.inflate(R.layout.recycler_fragment, container, false);
        mContainer = (RecyclerView) view.findViewById(R.id.container);
        init();
        return view;
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
