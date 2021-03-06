package io.github.xudaojie.androiddemo.event;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.github.xudaojie.androiddemo.BaseActivity;
import io.github.xudaojie.androiddemo.R;

/**
 * Created by xdj on 16/3/31.
 * 事件分发与上传
 */
public class EventActivity extends BaseActivity {
    @Bind(R.id.container)
    ListView mContainer;
    @Bind(R.id.refresh)
    SwipeRefreshLayout mRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_activity);
        ButterKnife.bind(this);

        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mRefresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRefresh.setRefreshing(false);
                    }
                }, 1500);
            }
        });
    }
}
