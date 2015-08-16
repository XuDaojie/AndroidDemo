package com.example.focus.androidnote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.focus.androidnote.activitylifecycle.LifeCycleActivity;
import com.example.focus.androidnote.broadcastreceiver.BroadcastReceveierActivity;
import com.example.focus.androidnote.customview.CustomViewActivity;
import com.example.focus.androidnote.statusbar.StatusBarActivity;
import com.example.focus.androidnote.toolbar.ToolbarActivity;
import com.example.focus.androidnote.toolbar.ToolbarFadeInActivity;
import com.example.focus.androidnote.toolbar.ToolbarSlidingTabActivity;
import com.example.focus.androidnote.viewpager.ViewPagerActivity;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tvOnClick(View view) {
        int id = view.getId();
        Intent intent = null;
        if (id == R.id.life_cycle_activity_tv) {
            intent = new Intent(mContext, LifeCycleActivity.class);
        } else if (id == R.id.broadcast_receveier_tv) {
            intent = new Intent(mContext, BroadcastReceveierActivity.class);
        } else if (id == R.id.toolbar_tv) {
            intent = new Intent(mContext, ToolbarActivity.class);
        } else if (id == R.id.toolbar_sliding_tab_tv) {
            intent = new Intent(mContext, ToolbarSlidingTabActivity.class);
        } else if (id == R.id.view_pager_tv) {
            intent = new Intent(mContext, ViewPagerActivity.class);
        } else if (id == R.id.toolbar_fade_in_tv) {
            intent = new Intent(mContext, ToolbarFadeInActivity.class);
        } else if (id == R.id.status_bar_tv) {
            intent = new Intent(mContext, StatusBarActivity.class);
        } else if (id == R.id.custom_view_tv) {
            intent = new Intent(mContext, CustomViewActivity.class);
        }
        startActivity(intent);
    }
}
