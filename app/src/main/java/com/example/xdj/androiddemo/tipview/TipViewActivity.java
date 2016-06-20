package com.example.xdj.androiddemo.tipview;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.example.xdj.androiddemo.BaseActivity;
import com.example.xdj.androiddemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xdj on 16/6/2.
 */
public class TipViewActivity extends BaseActivity {
    @Bind(R.id.tip_view)
    TipView mTipView;
    @Bind(R.id.text1)
    TextView mText1;
    @Bind(R.id.text2)
    TextView mText2;
    @Bind(R.id.text3)
    TextView mText3;
    @Bind(R.id.text)
    TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tip_view_activity);
        ButterKnife.bind(this);
//
//        ArrayList<String> tipList = new ArrayList<>();
//        tipList.add("xxxxx" + System.currentTimeMillis());
//        tipList.add("xxxxx" + System.currentTimeMillis());
//        tipList.add("xxxxx" + System.currentTimeMillis());
//        tipList.add("xxxxx" + System.currentTimeMillis());
//        tipList.add("xxxxx" + System.currentTimeMillis());
//
//        mTipView.setTipList(tipList);
        mText.setText(Html.fromHtml("<font color='#448AFF'>设备数量</font>"));
        mText1.setText(Html.fromHtml("<font color='#448AFF' size='20'>设备数量</font>"));
        mText2.setText(Html.fromHtml("<big><font color='#448AFF'>设备数量</font></big>"));
        mText3.setText(Html.fromHtml("<small><font color='#448AFF'>设备数量</font></small>"));
        mText1.setText(Html.fromHtml("<span style='color:#F00;'>Text</span> <font color='#F00'>Label</font>"));
    }


}
