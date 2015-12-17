package com.example.focus.androidnote.customview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.example.focus.androidnote.R;

/**
 * Created by xdj on 15/12/18.
 */
public class CustomGroupView extends FrameLayout {
    public CustomGroupView(Context context) {
        super(context);
    }

    public CustomGroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.view_custom_group_view, this);

    }

    public CustomGroupView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomGroupView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
