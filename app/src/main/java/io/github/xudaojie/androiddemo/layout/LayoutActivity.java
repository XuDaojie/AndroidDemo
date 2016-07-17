package io.github.xudaojie.androiddemo.layout;

import android.os.Bundle;
import android.view.ViewStub;

import io.github.xudaojie.androiddemo.BaseActivity;
import io.github.xudaojie.androiddemo.R;

/**
 * Created by xdj on 16/5/23.
 */
public class LayoutActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity);

        // 对应一些默认不显示的View可以使用此控件进行占位，优化性能
        ViewStub viewStub = (ViewStub) findViewById(R.id.view_stub);
        viewStub.inflate();
    }
}
