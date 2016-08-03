package io.github.xudaojie.androiddemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import io.github.xudaojie.androiddemo.bottomsheet.BottomSheetActivity;
import io.github.xudaojie.androiddemo.broadcastreceiver.BroadcastReceveierActivity;
import io.github.xudaojie.androiddemo.cardview.CardViewActivity;
import io.github.xudaojie.androiddemo.customview.CustomViewActivity;
import io.github.xudaojie.androiddemo.dagger.DaggerActivity;
import io.github.xudaojie.androiddemo.download.DownloadManagerActivity;
import io.github.xudaojie.androiddemo.event.EventActivity;
import io.github.xudaojie.androiddemo.fresco.FrescoActivity;
import io.github.xudaojie.androiddemo.frgament.FragmentActivity;
import io.github.xudaojie.androiddemo.glide.GlideActivity;
import io.github.xudaojie.androiddemo.handle.HandleActivity;
import io.github.xudaojie.androiddemo.layout.LayoutActivity;
import io.github.xudaojie.androiddemo.lifecycle.LifecycleActivity;
import io.github.xudaojie.androiddemo.listview.ListViewActivity;
import io.github.xudaojie.androiddemo.popupwindow.PopupWindowActivity;
import io.github.xudaojie.androiddemo.recyclerviewsample.RecyclerGridActivity;
import io.github.xudaojie.androiddemo.recyclerviewsample.RecyclerViewActivity;
import io.github.xudaojie.androiddemo.recyclerviewsample.ScrollRecyclerActivity;
import io.github.xudaojie.androiddemo.reflact.ReflactActivity;
import io.github.xudaojie.androiddemo.retrofitsample.RetrofitActivity;
import io.github.xudaojie.androiddemo.statusbar.StatusBarActivity;
import io.github.xudaojie.androiddemo.supportdesign.CoordinatorActivity;
import io.github.xudaojie.androiddemo.supportdesign.CoordinatorLayoutPagerActivity;
import io.github.xudaojie.androiddemo.supportdesign.CoordinatorNestedPagerActivity;
import io.github.xudaojie.androiddemo.tipview.TipViewActivity;
import io.github.xudaojie.androiddemo.toolbar.ToolbarActivity;
import io.github.xudaojie.androiddemo.toolbar.ToolbarFadeInActivity;
import io.github.xudaojie.androiddemo.toolbar.ToolbarSlidingTabActivity;
import io.github.xudaojie.androiddemo.viewpager.ViewPagerActivity;
import io.github.xudaojie.androiddemo.vitamio.MediaPlayerActivity;
import io.github.xudaojie.androiddemo.volley.VolleyActivity;
import io.github.xudaojie.androiddemo.webview.WebViewActivity;
import io.github.xudaojie.androiddemo.wheelview.WheelViewActivity;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
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
        } else if (id == R.id.scroll_recycler_tv) {
            intent = new Intent(mContext, ScrollRecyclerActivity.class);
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
        } else if (id == R.id.download_tv) {
            intent = new Intent(mContext, DownloadManagerActivity.class);
        } else if (id == R.id.dagger_tv) {
            intent = new Intent(mContext, DaggerActivity.class);
        } else if (id == R.id.bottom_sheet_tv) {
            intent = new Intent(mContext, BottomSheetActivity.class);
        }

        startActivity(intent);
    }
}
