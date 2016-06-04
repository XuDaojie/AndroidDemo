package com.example.xdj.androiddemo.lifecycle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.xdj.androiddemo.BaseActivity;
import com.example.xdj.androiddemo.R;

/**
 * Created by xdj on 15/7/25.
 * Activity生命周期
 */
public class LifecycleActivity extends BaseActivity {
    private static final String TAG = "LifeCycleActivity";

    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.lifecycle_activity);
        mLinearLayout = (LinearLayout) findViewById(R.id.root);

        Fragment fragment = new LifecycleFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_fl, fragment);
        ft.commit();
        Log.d(TAG, "onCreateEnd");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onReStart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        Log.d(TAG, "onContentChanged");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.d(TAG, "onPostCreate");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(TAG, "onPostResume");
    }

    /**
     * 可能被销毁时触发
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
    }

    /**
     * 确实被销毁并重建后触发
     * 不常用，一般直接在onCreate放发里回复即可
     * @param savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState");
    }

    /**
     * Test lifecycle onContentChange
     * @param view
     */
    public void addOnClick(View view) {
        View view1 = LayoutInflater.from(mContext)
                .inflate(R.layout.popup_window_activity, mLinearLayout, false);
        addContentView(view1, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
    }

}
