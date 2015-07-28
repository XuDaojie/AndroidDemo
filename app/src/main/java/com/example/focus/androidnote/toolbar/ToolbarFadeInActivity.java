package com.example.focus.androidnote.toolbar;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.focus.androidnote.BaseActivity;
import com.example.focus.androidnote.R;

public class ToolbarFadeInActivity extends BaseActivity {

    private Toolbar mToolbar;
    private Toolbar mToolbarTab;
    private SlidingTabLayout mTabLayout;
    private ViewPager mPager;

    private String[] mBackgrounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_fade_in);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbarTab = (Toolbar) findViewById(R.id.toolbar_tab);
        mTabLayout = (SlidingTabLayout) findViewById(R.id.tab_layout);
        mPager = (ViewPager) findViewById(R.id.page);

        mBackgrounds = new String[] {"#616161", "#9E9E9E", "#F5F5F5"};

        setSupportActionBar(mToolbar);
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
}
