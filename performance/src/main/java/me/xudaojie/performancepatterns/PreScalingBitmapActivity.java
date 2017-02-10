package me.xudaojie.performancepatterns;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import static android.graphics.BitmapFactory.decodeResource;

/**
 * Created by xdj on 2017/2/9.
 */

public class PreScalingBitmapActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pre_scaling_bitmap_act);

        ImageView originIv = (ImageView) findViewById(R.id.origin_iv);
        ImageView scalingIv = (ImageView) findViewById(R.id.scale_iv);
        // 无法正常加载
//        originIv.setImageResource(R.mipmap.img);


        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 4; // 尺寸为原尺寸的 1/4
        Bitmap scalingBmp = decodeResource(getResources(), R.mipmap.img, options);
        scalingIv.setImageBitmap(scalingBmp);

//        获取原始图片尺寸
//        BitmapFactory.Options optionsSize = new BitmapFactory.Options();
//        optionsSize.inJustDecodeBounds = true;
//        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.id.scale_iv, options);
//        int bmpHeight = optionsSize.outHeight;
//        int bmpWidth = optionsSize.outWidth;

//        不推荐,
//        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.img);
//        Bitmap.createScaledBitmap(bmp, 64, 128, true);
    }
}
