package me.xdj.animatenote;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RadioGroup;

/**
 * Created by xdj on 16/2/11.
 */
public class TweenedActivity extends BaseActivity {
    private RadioGroup mGroup;
    private ImageView mImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweend);
        mImg = (ImageView) findViewById(R.id.img);
        mGroup = (RadioGroup) findViewById(R.id.group);
        mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Animation anim = null;
                switch (checkedId) {
                    case R.id.alpha_rb:
                        anim = AnimationUtils.loadAnimation(mContext, R.anim.alpha_first);
//                        mImg.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.alpha_first));
                        break;
                    case R.id.scale_rb:
                        anim = AnimationUtils.loadAnimation(mContext, R.anim.scale_first);
                        break;
                    case R.id.rotate_rb:
                        anim = AnimationUtils.loadAnimation(mContext, R.anim.roate_first);
                        break;
                    case R.id.translate_rb:
                        anim = AnimationUtils.loadAnimation(mContext, R.anim.translate_first);
                        break;
                    case R.id.set_rb:
                        anim = AnimationUtils.loadAnimation(mContext, R.anim.set_first);
                        break;
                }
                mImg.startAnimation(anim);
            }
        });
        mImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "onClick", Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
