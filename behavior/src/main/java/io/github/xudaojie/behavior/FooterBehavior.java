package io.github.xudaojie.behavior;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by xdj on 16/8/19.
 */

public class FooterBehavior extends CoordinatorLayout.Behavior {

    private static final String TAG = "FooterBehavior";

    private AnimatorSet mAnimatorSetIn;
    private AnimatorSet mAnimatorSetOut;

    private Animator mCurrentAnim;

    public FooterBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 确定依赖关系
     *
     * @param parent
     * @param child      设置了Behavior的View
     * @param dependency 触发Behavior的角色
     * @return
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return super.layoutDependsOn(parent, child, dependency);
    }

    /**
     * 当依赖的View位置或者大小改变时触发
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        return super.onDependentViewChanged(parent, child, dependency);
    }

    /**
     *
     */
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
//        return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
        Log.d(TAG, "onStartNestedScroll");
        return true;
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, final View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        Log.d(TAG, "onNestedScroll");
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);

        if (target instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) target;
            // 通过Tag判断是否已添加滚动事件监听
            if (recyclerView.getTag() == null) {
                RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);
                    }

                    @Override
                    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                        super.onScrollStateChanged(recyclerView, newState);
                        if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                            //得到当前显示的最后一个item的view
                            View lastChildView = recyclerView.getLayoutManager()
                                    .getChildAt(recyclerView.getLayoutManager().getChildCount() - 1);
                            //得到lastChildView的bottom坐标值
                            int lastChildBottom = lastChildView.getBottom();
                            //得到Recyclerview的底部坐标减去底部padding值，也就是显示内容最底部的坐标
                            int recyclerBottom = recyclerView.getBottom() - recyclerView.getPaddingBottom();
                            //通过这个lastChildView得到这个view当前的position值
                            int lastPosition = recyclerView.getLayoutManager().getPosition(lastChildView);

                            //判断lastChildView的bottom值跟recyclerBottom
                            //判断lastPosition是不是最后一个position
                            //如果两个条件都满足则说明是真正的滑动到了底部
                            if (lastChildBottom == recyclerBottom
                                    && lastPosition == recyclerView.getLayoutManager().getItemCount() - 1) {
                                Log.d(TAG, "RecyclerView滑到底了");
                                animationIn(child);
                            }
                        }
                    }
                };

                recyclerView.addOnScrollListener(onScrollListener);
                recyclerView.setTag(onScrollListener);
            }

        }

        if (dyConsumed > 0 && dyUnconsumed == 0) {
            System.out.println("上滑中。。。");
            animationOut(child);
        }
        if (dyConsumed == 0 && dyUnconsumed > 0) {
            System.out.println("到边界了,但手势还在上滑。。。");
            animationIn(child);
        }
        if (dyConsumed < 0 && dyUnconsumed == 0) {
            System.out.println("下滑中。。。");
            animationIn(child);
        }
        if (dyConsumed == 0 && dyUnconsumed < 0) {
            System.out.println("到边界了，但手势还在下滑。。。");
        }

        Log.d(TAG, dyConsumed + "/" + dyUnconsumed);
    }

    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY, boolean consumed) {
        Log.d(TAG, "onNestedFling");
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }

    private void animationIn(View child) {
        Log.d(TAG, "animationIn");
        if (mAnimatorSetIn == null) {
            mAnimatorSetIn = new AnimatorSet();
            mAnimatorSetIn
                    .play(ObjectAnimator.ofFloat(child, View.TRANSLATION_Y, 0));
            mAnimatorSetIn.setDuration(300);
        }
        if (mCurrentAnim != mAnimatorSetIn) {
            mAnimatorSetIn.start();
            mCurrentAnim = mAnimatorSetIn;
        }
    }

    private void animationOut(View child) {
        Log.d(TAG, "animationOut");
        if (mAnimatorSetOut == null) {
            mAnimatorSetOut = new AnimatorSet();
            mAnimatorSetOut
                    .play(ObjectAnimator.ofFloat(child, View.TRANSLATION_Y, child.getHeight()));
            mAnimatorSetOut.setDuration(300);
        }
        if (mCurrentAnim != mAnimatorSetOut) {
            mAnimatorSetOut.start();
            mCurrentAnim = mAnimatorSetOut;
        }
    }
}
