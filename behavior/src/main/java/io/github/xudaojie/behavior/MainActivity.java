package io.github.xudaojie.behavior;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    private Activity mContext;

    private RecyclerView mRecyclerView;
    private View mBottomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mBottomView = findViewById(R.id.bottom_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new ListAdapter());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        int id = item.getItemId();
        if (id == R.id.action_bottom_behavior) {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(mContext);
            bottomSheetDialog.setContentView(R.layout.bottom_behavior);
            bottomSheetDialog.show();
        }
        return true;
    }

    class ListAdapter extends RecyclerView.Adapter {

        private static final int ITEM_CONTENT = 0;
        private static final int ITEM_FOOT = 1;

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            if (viewType == ITEM_CONTENT) {
                view = LayoutInflater.from(mContext).inflate(R.layout.main_item, parent, false);
            } else {
                view = LayoutInflater.from(mContext).inflate(R.layout.empty_item, parent, false);
            }
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        }

        @Override
        public int getItemCount() {
            return 16 + 1;
        }

        @Override
        public int getItemViewType(int position) {
            super.getItemViewType(position);
            if (position == getItemCount() - 1) {
                return ITEM_FOOT;
            }
            return ITEM_CONTENT;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
