package com.example.focus.androidnote.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.focus.androidnote.R;

/**
 * Created by focus on 15/8/16.
 * 自定义控件 倒计时
 */
public class CountView extends View{
    private Paint mPaint;

    public CountView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(getResources().getColor(R.color.background_blue));
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
    }
}
