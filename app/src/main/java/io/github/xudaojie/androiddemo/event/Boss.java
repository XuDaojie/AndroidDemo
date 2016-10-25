package io.github.xudaojie.androiddemo.event;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import io.github.xudaojie.androiddemo.BaseActivity;
import io.github.xudaojie.androiddemo.R;

/**
 * Created by xdj on 2016/10/23.
 */

public class Boss extends BaseActivity {

    private static final String TAG = Boss.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_distribution_activity);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "dispatchTouchEvent:\t\t" + ev.toString());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent:\t\t" + event.toString());
        return super.onTouchEvent(event);
    }
}
