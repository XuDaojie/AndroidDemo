package me.xdj.animatenote;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by xdj on 2016/12/7.
 */

public class TestActivity extends BaseActivity {
    private static final String TAG = TestActivity.class.getSimpleName();
    private AnimatorSet mAnimatorSet1;
    private AnimatorSet mAnimatorSet2;
    private AnimatorSet mCurrentAnimator;
    private AnimatorSet mNextAnimator;

    private boolean mRunning;
    private boolean mStart;
//    private boolean mPaused;

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            if (mNextAnimator != null
                    && mStart
                    && !mNextAnimator.isStarted()) { // 不判断会导致动画启动两次
                mNextAnimator.start();
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        final TextView codeBadTv = (TextView) findViewById(R.id.code_bad_tv);
        final TextView packageBadTv = (TextView) findViewById(R.id.package_bad_tv);
        Button startBtn = (Button) findViewById(R.id.start_btn);
        Button cancelBtn = (Button) findViewById(R.id.cancel_btn);
        Button endBtn = (Button) findViewById(R.id.end_btn);
        Button pauseBtn = (Button) findViewById(R.id.pause_btn);
        Button resumeBtn = (Button) findViewById(R.id.resume_btn);
        codeBadTv.bringToFront();

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnimatorSet1 == null) {
                    int height = codeBadTv.getHeight();
                    ObjectAnimator animator1 = ObjectAnimator.ofFloat(codeBadTv, View.TRANSLATION_Y, 0, -height);
                    ObjectAnimator animator2 = ObjectAnimator.ofFloat(packageBadTv, View.TRANSLATION_Y, height, 0);

                    mAnimatorSet1 = new AnimatorSet();
                    mAnimatorSet1.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            super.onAnimationStart(animation);
                            Log.d(TAG, "onAnimationStart1");
                            mCurrentAnimator = mAnimatorSet1;
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            Log.d(TAG, "onAnimationEnd1");
                            mCurrentAnimator = null;
                            activeAnimator(codeBadTv, mAnimatorSet2);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {
                            super.onAnimationCancel(animation);
                            Log.d(TAG, "onAnimationCancel1");
                        }
                    });
                    mAnimatorSet1.setDuration(5000);
//                    mAnimatorSet1.setStartDelay(2000);
                    mAnimatorSet1.playTogether(animator1, animator2);

                    // -------
                    ObjectAnimator animatorA = ObjectAnimator.ofFloat(packageBadTv, View.TRANSLATION_Y, 0, -height);
                    ObjectAnimator animatorB = ObjectAnimator.ofFloat(codeBadTv, View.TRANSLATION_Y, height, 0);

                    mAnimatorSet2 = new AnimatorSet();
                    mAnimatorSet2.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            super.onAnimationStart(animation);
                            Log.d(TAG, "onAnimationStart2");
                            mCurrentAnimator = mAnimatorSet2;

                            mRunning = true;
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            Log.d(TAG, "onAnimationEnd2");
                            mCurrentAnimator = null;
                            activeAnimator(codeBadTv, mAnimatorSet1);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {
                            super.onAnimationCancel(animation);
                            Log.d(TAG, "onAnimationCancel2");
                        }
                    });
                    mAnimatorSet2.setDuration(5000);
//                    mAnimatorSet2.setStartDelay(2000);
                    mAnimatorSet2.playTogether(animatorA, animatorB);
                }
                if (mNextAnimator != null) {
                    activeAnimator(codeBadTv, mNextAnimator);
                } else {
                    activeAnimator(codeBadTv, mAnimatorSet1);
                }

                mStart = true;
            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStart = false;
//                mPaused = false;
                mRunning = false;

                if (mCurrentAnimator != null) {
                    mCurrentAnimator.cancel();
                }
            }
        });
        endBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStart = false;
//                mPaused = false;
                mRunning = false;

                if (mCurrentAnimator != null) {
                    mCurrentAnimator.end();
                }
            }
        });
//        pauseBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mStart = false;
//                mPaused = true;
//                mRunning = false;
//
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                    mCurrentAnimator.pause();
//                }
//            }
//        });
//        resumeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mStart = false;
//                mPaused = false;
//                mRunning = false;
//
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                    mCurrentAnimator.resume();
//                }
//            }
//        });
    }

    public void start() {

    }

    /**
     * 启动动画，与start不同，start是启动整个动画
     * activeAnimator是启动子动画
     * @param ancher
     * @param animatorSet
     */
    private void activeAnimator(View ancher, AnimatorSet animatorSet) {
        mNextAnimator = animatorSet;
        ancher.postDelayed(mRunnable, 2000);
    }

}
