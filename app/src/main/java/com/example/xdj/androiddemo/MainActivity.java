package com.example.xdj.androiddemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.xdj.androiddemo.lifecycle.LifecycleActivity;
import com.example.xdj.androiddemo.broadcastreceiver.BroadcastReceveierActivity;
import com.example.xdj.androiddemo.cardview.CardViewActivity;
import com.example.xdj.androiddemo.customview.CustomViewActivity;
import com.example.xdj.androiddemo.event.EventActivity;
import com.example.xdj.androiddemo.fresco.FrescoActivity;
import com.example.xdj.androiddemo.frgament.FragmentActivity;
import com.example.xdj.androiddemo.glide.GlideActivity;
import com.example.xdj.androiddemo.handle.HandleActivity;
import com.example.xdj.androiddemo.layout.LayoutActivity;
import com.example.xdj.androiddemo.listview.ListViewActivity;
import com.example.xdj.androiddemo.popupwindow.PopupWindowActivity;
import com.example.xdj.androiddemo.recyclerviewsample.RecyclerGridActivity;
import com.example.xdj.androiddemo.recyclerviewsample.RecyclerViewActivity;
import com.example.xdj.androiddemo.reflact.ReflactActivity;
import com.example.xdj.androiddemo.retrofitsample.RetrofitActivity;
import com.example.xdj.androiddemo.statusbar.StatusBarActivity;
import com.example.xdj.androiddemo.supportdesign.CoordinatorActivity;
import com.example.xdj.androiddemo.supportdesign.CoordinatorLayoutPagerActivity;
import com.example.xdj.androiddemo.supportdesign.CoordinatorNestedPagerActivity;
import com.example.xdj.androiddemo.tipview.TipViewActivity;
import com.example.xdj.androiddemo.toolbar.ToolbarActivity;
import com.example.xdj.androiddemo.toolbar.ToolbarFadeInActivity;
import com.example.xdj.androiddemo.toolbar.ToolbarSlidingTabActivity;
import com.example.xdj.androiddemo.viewpager.ViewPagerActivity;
import com.example.xdj.androiddemo.vitamio.MediaPlayerActivity;
import com.example.xdj.androiddemo.volley.VolleyActivity;
import com.example.xdj.androiddemo.webview.WebViewActivity;
import com.example.xdj.androiddemo.wheelview.WheelViewActivity;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.xdj.androiddemo.R.layout.main_activity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.example.xdj.androiddemo.R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == com.example.xdj.androiddemo.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tvOnClick(View view) {
        int id = view.getId();
        Intent intent = null;
        if (id == R.id.life_cycle_activity_tv) {
            intent = new Intent(mContext, LifecycleActivity.class);
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
        } else if (id == R.id.coordinator_pager_tv) {
            intent = new Intent(mContext, CoordinatorLayoutPagerActivity.class);
        } else if (id == R.id.recycler_grid_tv) {
            intent = new Intent(mContext, RecyclerGridActivity.class);
        } else if (id == R.id.coordinator_tv) {
            intent = new Intent(mContext, CoordinatorActivity.class);
        } else if (id == R.id.coordinator_nested_tv) {
            intent = new Intent(mContext, CoordinatorNestedPagerActivity.class);
        } else if (id == R.id.card_view_tv) {
            intent = new Intent(mContext, CardViewActivity.class);
        } else if (id == R.id.event_tv) {
            intent = new Intent(mContext, EventActivity.class);
        } else if (id == R.id.layout_tv) {
            intent = new Intent(mContext, LayoutActivity.class);
        } else if (id == R.id.listview_tv) {
            intent = new Intent(mContext, ListViewActivity.class);
        } else if (id == R.id.tipview_tv) {
            intent = new Intent(mContext, TipViewActivity.class);
        }

        startActivity(intent);
    }
}
