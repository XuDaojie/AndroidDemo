package com.example.xdj.androiddemo.fresco;

import android.net.Uri;
import android.os.Bundle;

import com.example.xdj.androiddemo.BaseActivity;
import com.example.xdj.androiddemo.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by xdj on 15/10/29.
 */
public class FrescoActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.fresco_activity);
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view1);

        // 定制图片加载效果
        GenericDraweeHierarchyBuilder builder =
                new GenericDraweeHierarchyBuilder(getResources());
        GenericDraweeHierarchy hierarchy = builder
                .setFadeDuration(300)
                .setProgressBarImage(new ProgressBarDrawable())
                .build();
        draweeView.setHierarchy(hierarchy);
        draweeView.setImageURI(Uri.parse("http://img.netbian.com/file/2015/1029/c083c3542cb48b50924f32429526a6ab.jpg"));
    }
}
