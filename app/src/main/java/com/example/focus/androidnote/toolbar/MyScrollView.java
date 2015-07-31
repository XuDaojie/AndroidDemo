package com.example.focus.androidnote.toolbar;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by focus on 15/7/29.
 * 通过此子类实现监听SrollView的滚动事件
 */
public class MyScrollView extends ScrollView {
    private ScrollViewListener scrollViewListener;
    private int mLastScrollY;

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

//    @Override
//    protected void onScrollChanged(int l, int t) {
//        super.onScrollChanged(l, t, oldl, oldt);
//        if (scrollViewListener != null) {
//            scrollViewListener.onScrollChanged(l, t, oldl, oldt);
//        }
//    }

    /**
     * 用于用户手指离开MyScrollView的时候获取MyScrollView滚动的Y距离，然后回调给onScroll方法中
     */
    private Handler handler = new Handler() {

        public void handleMessage(android.os.Message msg) {
            int scrollY = MyScrollView.this.getScrollY();

            //此时的距离和记录下的距离不相等，在隔5毫秒给handler发送消息
            if(mLastScrollY != scrollY){
                mLastScrollY = scrollY;
                handler.sendMessageDelayed(handler.obtainMessage(), 5);
            }
            if(scrollViewListener != null){
                scrollViewListener.onScrollChanged(scrollY);
            }

        };

    };

    /**
     * 重写onTouchEvent， 当用户的手在MyScrollView上面的时候，
     * 直接将MyScrollView滑动的Y方向距离回调给onScroll方法中，当用户抬起手的时候，
     * MyScrollView可能还在滑动，所以当用户抬起手我们隔5毫秒给handler发送消息，在handler处理
     * MyScrollView滑动的距离
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(scrollViewListener != null){
            scrollViewListener.onScrollChanged(mLastScrollY = this.getScrollY());
        }
        switch(ev.getAction()){
            case MotionEvent.ACTION_UP:
                handler.sendMessageDelayed(handler.obtainMessage(), 5);
                break;
        }
        return super.onTouchEvent(ev);
    }

    public interface ScrollViewListener {
        void onScrollChanged(int y);
    }
}
