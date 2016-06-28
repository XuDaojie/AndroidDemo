package me.xdj.animatenote;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by xdj on 16/2/11.
 */
public class PropertyActivity extends BaseActivity {
    private ImageView mImg;
    private TextView mText;
    private FrameLayout mContainer;
    private ImageView mZoomIv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        mText = (TextView) findViewById(R.id.text);
        mImg = (ImageView) findViewById(R.id.img);
        mContainer = (FrameLayout) findViewById(R.id.container);
        mZoomIv = (ImageView) findViewById(R.id.zoom_iv);

        mImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 渐显
//                Animator animator = AnimatorInflater.loadAnimator(mContext, R.animator.object_animator_first);
//                animator.setTarget(mText);
//                animator.start();

                //
//                AnimatorSet animatorSet = new AnimatorSet();
//
//                ObjectAnimator animatorX = ObjectAnimator.ofFloat(mImg, "scaleX", 0.1f, 1f); // 倍数
//                ObjectAnimator animatorY = ObjectAnimator.ofFloat(mImg, "scaleY", 0.1f, 1f);
//
//                animatorSet.setDuration(2000);
//                animatorSet.setInterpolator(new DecelerateInterpolator());
//                animatorSet.play(animatorX).with(animatorY);
//               animatorSet.start();

                Rect startBounds = new Rect();
                Rect finalBounds = new Rect();
                Point globalOffset = new Point();

                // 获取试图在屏幕坐标中的可视区域
                mImg.getGlobalVisibleRect(startBounds);
                mContainer.getGlobalVisibleRect(finalBounds, globalOffset);
                // 获取视图本身可见的坐标区域
//                mImg.getLocalVisibleRect()

                // 将坐标向上偏移 偏移量为 Toolbar.getHeight + StateBarHeight
                startBounds.offset(-globalOffset.x, -globalOffset.y);
                finalBounds.offset(-globalOffset.x, -globalOffset.y);

                float startScale;
                // 计算指定缩放比 startScale 总是按小的来
                if ((float) finalBounds.width() / finalBounds.height()
                        > (float) startBounds.width() / startBounds.height()) {
                    startScale = (float) startBounds.height() / finalBounds.height();

//                    float startWidth = startScale * finalBounds.width(); // 获得缩放后的宽
//                    float detailWidth = (startWidth - startBounds.width()) / 2;
//                    startBounds.left -= detailWidth;
//                    startBounds.right += detailWidth;
                } else {
                    startScale = (float) startBounds.width() / finalBounds.width();

                    float startHeight = startScale * finalBounds.height();
                    float deltaHeight = (startHeight - startBounds.height()) / 2;
                    startBounds.top -= deltaHeight;
                    startBounds.bottom += deltaHeight;
                }

                // 图片放大
//                mImg.setPivotX(0);
//                mImg.setPivotY(0);

                mZoomIv.setPivotX(0); // 中心点
                mZoomIv.setPivotY(0);

                // X轴的视觉起点 相对于父控件
                ObjectAnimator x = ObjectAnimator
                        .ofFloat(mZoomIv, View.X, startBounds.left, finalBounds.left);
                ObjectAnimator y = ObjectAnimator
                        .ofFloat(mZoomIv, View.Y, startBounds.top, finalBounds.top);

                ObjectAnimator scaleX = ObjectAnimator
                        .ofFloat(mZoomIv, View.SCALE_X, startScale, 1f);
                ObjectAnimator scaleY = ObjectAnimator
                        .ofFloat(mZoomIv, View.SCALE_Y, startScale, 1f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet
                        .play(x)
                        .with(y)
                        .with(scaleX)
                        .with(scaleY);

//                animatorSet
//                        .play(y);
//                        .with(y);

                mZoomIv.setImageResource(R.mipmap.img);

                mZoomIv.setVisibility(View.VISIBLE);
                animatorSet.setDuration(3000);
                animatorSet.start();
            }
        });
    }

    /**
     * 获取状态栏高度
     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
                "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
