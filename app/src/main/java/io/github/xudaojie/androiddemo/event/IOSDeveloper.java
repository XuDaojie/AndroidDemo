package io.github.xudaojie.androiddemo.event;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by xdj on 2016/10/23.
 */

public class IOSDeveloper extends TextView {

    private static final String TAG = IOSDeveloper.class.getSimpleName();

    public IOSDeveloper(Context context) {
        super(context);
    }

    public IOSDeveloper(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IOSDeveloper(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public IOSDeveloper(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i(TAG, "dispatchTouchEvent:\t\t" + event.toString());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "onTouchEvent:\t\t" + event.toString());
        return super.onTouchEvent(event);
    }
}
