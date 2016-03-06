package com.example.focus.androidnote.toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.focus.androidnote.BaseActivity;
import com.example.focus.androidnote.R;

import java.util.ArrayList;

public class ToolbarSlidingTabActivity extends BaseActivity {
    protected Toolbar mToolbar;
    protected ArrayList<Fragment> mListFragment;
    protected SlidingTabLayout mTabLayout;
    protected ViewPager mPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar_sliding_tab_activity);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        mTabLayout = (SlidingTabLayout) findViewById(R.id.tab_layout);
        mPage = (ViewPager) findViewById(R.id.pager);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        //替换ActionBar
        setSupportActionBar(mToolbar);
        //getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //关联menu布局文件
        //mToolbar.inflateMenu(R.menu.menu_main);
        //mToolbar.setTitle("Title");
        //设置导航按钮
        //mToolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        //mToolbar.setNavigationIcon(R.drawable.abc_ic_launcher);
        //
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "点击Menu", Toast.LENGTH_SHORT).show();
            }
        });
        //menu点击事件
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.action_settings) {
                    Toast.makeText(mContext, "点击Menu item", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        mListFragment = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Fragment fragment = TextFragment.newInstance("Fragment" + i);
            mListFragment.add(fragment);
        }

        PagerAdapter adapter = new TabPagerAdapter(getSupportFragmentManager());
        mPage.setAdapter(adapter);

        mTabLayout.setViewPager(mPage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
//        mToolbar.inflateMenu(R.menu.menu_main);
//        Log.d(getClass().getName(), "onCreateOptionMenu");
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
            Toast.makeText(mContext, "点击menu item", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    class TabPagerAdapter extends FragmentPagerAdapter {

        public TabPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mListFragment.get(position);
        }

        @Override
        public int getCount() {
            return mListFragment.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Fragment" + position;
        }
    }
}
