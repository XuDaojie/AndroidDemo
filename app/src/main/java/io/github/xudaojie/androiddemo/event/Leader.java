package io.github.xudaojie.androiddemo.event;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by xdj on 2016/10/23.
*/

public class Leader extends LinearLayout {

    private static final String TAG = Leader.class.getSimpleName();

    public Leader(Context context) {
        super(context);
    }

    public Leader(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Leader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public Leader(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.w(TAG, "dispatchTouchEvent:\t\t" + ev.toString());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onInterceptTouchEvent:\t\t" + ev.toString());
//        return super.onInterceptTouchEvent(ev);
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.w(TAG, "onTouchEvent:\t\t" + event.toString());
        return super.onTouchEvent(event);
    }
}
