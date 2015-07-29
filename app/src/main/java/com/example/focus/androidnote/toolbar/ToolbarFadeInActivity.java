package com.example.focus.androidnote.toolbar;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.nfc.Tag;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.focus.androidnote.BaseActivity;
import com.example.focus.androidnote.R;
import com.example.focus.androidnote.viewpager.*;
import com.example.focus.androidnote.viewpager.TextFragment;

import java.util.ArrayList;

public class ToolbarFadeInActivity extends BaseActivity {

    private static final String TAG = "ToolbarFadeInActivity";

    private MyScrollView mMainLayout;
    private LinearLayout mToolbarLayout;
    private Toolbar mToolbar;
    private Toolbar mToolbarTab;
    private SlidingTabLayout mTabLayout;
    private ViewPager mPager;

    private String[] mBackgrounds;
    private ArrayList<Fragment> mFragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_fade_in);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbarTab = (Toolbar) findViewById(R.id.toolbar_tab);
        mTabLayout = (SlidingTabLayout) findViewById(R.id.tab_layout);
        mPager = (ViewPager) findViewById(R.id.page);
        mMainLayout = (MyScrollView) findViewById(R.id.main_layout);

        mBackgrounds = new String[] {"#616161", "#9E9E9E", "#F5F5F5"};
        mFragmentList = new ArrayList<>();

        setSupportActionBar(mToolbar);
        //显示回退按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        for (int i = 0; i < mBackgrounds.length; i++) {
            Fragment fragment = TextFragment.newInstance("Fragment" + i, mBackgrounds[i]);
            mFragmentList.add(fragment);
        }

        mPager.setAdapter(new TagPageAdapter(getSupportFragmentManager()));
        mTabLayout.setViewPager(mPager);

        mMainLayout.setScrollViewListener(new MyScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(int x, int y, int oldxX, int oldY) {
                if (y >=0 && y <= 255) {
                    mToolbar.setBackgroundColor(Color.argb(y, 0, 0, 255));
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_toolbar_fade_in, menu);
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

    class TagPageAdapter extends FragmentPagerAdapter {
        public TagPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "标题" + position;
        }
    }
}
