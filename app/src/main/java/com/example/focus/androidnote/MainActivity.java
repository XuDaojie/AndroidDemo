package com.example.focus.androidnote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.focus.androidnote.activitylifecycle.LifeCycleActivity;
import com.example.focus.androidnote.broadcastreceiver.BroadcastReceveierActivity;
import com.example.focus.androidnote.customview.CustomViewActivity;
import com.example.focus.androidnote.fresco.FrescoActivity;
import com.example.focus.androidnote.frgament.FragmentActivity;
import com.example.focus.androidnote.glide.GlideActivity;
import com.example.focus.androidnote.handle.HandleActivity;
import com.example.focus.androidnote.popupwindow.PopupWindowActivity;
import com.example.focus.androidnote.recyclerviewsample.RecyclerViewActivity;
import com.example.focus.androidnote.reflact.ReflactActivity;
import com.example.focus.androidnote.retrofitsample.RetrofitActivity;
import com.example.focus.androidnote.statusbar.StatusBarActivity;
import com.example.focus.androidnote.supportdesign.CoordinatorLayoutActivity;
import com.example.focus.androidnote.toolbar.ToolbarActivity;
import com.example.focus.androidnote.toolbar.ToolbarFadeInActivity;
import com.example.focus.androidnote.toolbar.ToolbarSlidingTabActivity;
import com.example.focus.androidnote.viewpager.ViewPagerActivity;
import com.example.focus.androidnote.vitamio.MediaPlayerActivity;
import com.example.focus.androidnote.volley.VolleyActivity;
import com.example.focus.androidnote.webview.WebViewActivity;
import com.example.focus.androidnote.wheelview.WheelViewActivity;


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
        } else if (id == R.id.handle_tv) {
            intent = new Intent(mContext, HandleActivity.class);
        } else if (id == R.id.fragment_tv) {
            intent = new Intent(mContext, FragmentActivity.class);
        } else if (id == R.id.volley_tv) {
            intent = new Intent(mContext, VolleyActivity.class);
        } else if (id == R.id.pop_window_tv) {
            intent = new Intent(mContext, PopupWindowActivity.class);
        } else if (id == R.id.media_player_tv) {
            intent = new Intent(mContext, MediaPlayerActivity.class);
        } else if (id == R.id.fresco_tv) {
            intent = new Intent(mContext, FrescoActivity.class);
        } else if (id == R.id.glide_tv) {
            intent = new Intent(mContext, GlideActivity.class);
        } else if (id == R.id.web_view_tv) {
            intent = new Intent(mContext, WebViewActivity.class);
        } else if (id == R.id.retrofit_tv) {
            intent = new Intent(mContext, RetrofitActivity.class);
        } else if (id == R.id.wheel_view_tv) {
            intent = new Intent(mContext, WheelViewActivity.class);
        } else if (id == R.id.recycler_view_tv) {
            intent = new Intent(mContext, RecyclerViewActivity.class);
        } else if (id == R.id.reflect_tv) {
            intent = new Intent(mContext, ReflactActivity.class);
        } else if (id == R.id.coordinator_tv) {
            intent = new Intent(mContext, CoordinatorLayoutActivity.class);
        }

        startActivity(intent);
    }
}
