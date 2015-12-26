package com.example.focus.androidnote.glide;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.focus.androidnote.BaseActivity;
import com.example.focus.androidnote.R;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by xdj on 15/11/2.
 */
public class GlideActivity extends BaseActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        imageView = (ImageView) findViewById(R.id.my_image_view);
        Glide.with(this).load("http://img.netbian.com/file/2015/1029/c083c3542cb48b50924f32429526a6ab.jpg").into(imageView);
    }

    public void clearCacheOnClick(View view) {
        Glide.clear(imageView);
        Glide.get(this).clearMemory();
        new Thread() {
            @Override
            public void run() {
                super.run();
                Glide.get(GlideActivity.this.getApplication()).clearDiskCache(); // 需要在子线程中运行
            }
        };

    }

    public void resumeLoadOnClick(View view) {
        Glide.with(this).load("http://img.netbian.com/file/2015/1029/c083c3542cb48b50924f32429526a6ab.jpg").into(imageView);
    }

    public void transformationOnClick(View view) {
//        Glide.with(this)
//                .load("http://img.netbian.com/file/2015/1029/c083c3542cb48b50924f32429526a6ab.jpg")
//                .bitmapTransform(new RoundedCornersTransformation(mContext, 50, 0, RoundedCornersTransformation.CornerType.ALL),
//                        new RoundedCornersTransformation(mContext, 50, 0, RoundedCornersTransformation.CornerType.TOP_RIGHT))
//                .into(imageView);
//        .load("http://pleaseenjoy.com/wp-content/uploads/2012/06/google_circle_logo.jpg")

        Glide.with(this)
//                .load("https://media.giphy.com/media/gXcIuJBbRi2Va/giphy.gif")
                .load("http://pleaseenjoy.com/wp-content/uploads/2012/06/google_circle_logo.jpg")
                .bitmapTransform(new RoundedCornersTransformation(mContext, 50, 0, RoundedCornersTransformation.CornerType.TOP))
                .into(imageView);
    }
}
