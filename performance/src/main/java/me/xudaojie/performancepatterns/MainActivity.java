package me.xudaojie.performancepatterns;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Android性能优化
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.img);
//        Bitmap.createScaledBitmap(bmp, 200, 200, true);

        findViewById(R.id.pre_scaling_bitmap_btn)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(mActivity, PreScalingBitmapActivity.class);
                        startActivity(i);
                    }
                });
        
    }
}
