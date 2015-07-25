package com.example.focus.androidnote;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by focus on 15/7/24.
 */
public class BaseActivity extends ActionBarActivity {
    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = this;
    }
}
