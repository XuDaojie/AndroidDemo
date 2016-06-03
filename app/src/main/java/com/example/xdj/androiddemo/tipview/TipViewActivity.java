package com.example.xdj.androiddemo.tipview;

import android.os.Bundle;

import com.example.xdj.androiddemo.BaseActivity;
import com.example.xdj.androiddemo.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xdj on 16/6/2.
 */
public class TipViewActivity extends BaseActivity {
    @Bind(R.id.tip_view)
    TipView mTipView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tip_view_activity);
        ButterKnife.bind(this);

        ArrayList<String> tipList = new ArrayList<>();
        tipList.add("xxxxx" + System.currentTimeMillis());
        tipList.add("xxxxx" + System.currentTimeMillis());
        tipList.add("xxxxx" + System.currentTimeMillis());
        tipList.add("xxxxx" + System.currentTimeMillis());
        tipList.add("xxxxx" + System.currentTimeMillis());

        mTipView.setTipList(tipList);
    }


}
