package com.example.xdj.androiddemo.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.example.xdj.androiddemo.R;

/**
 * Created by xdj on 15/8/16.
 * 自定义控件 倒计时
 */
public class CountView extends View implements View.OnClickListener{
    private Paint mPaint;

    private Rect mBounds;

    private int mCount;

    public CountView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mBounds = new Rect();
        setOnClickListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(getResources().getColor(R.color.background_blue));
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);

        mPaint.setColor(Color.BLUE);
        mPaint.setTextSize(60);
        String text = String.valueOf(mCount);
        mPaint.getTextBounds(text, 0, text.length(), mBounds);
        float textWidth = mBounds.width();
        float textHeight = mBounds.height();
        canvas.drawText(text, getWidth() / 2 - textWidth / 2, getHeight() / 2
                + textHeight / 2, mPaint);
    }

    @Override
    public void onClick(View v) {
        mCount++;
        invalidate();
    }
}
