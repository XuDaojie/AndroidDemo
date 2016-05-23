package com.example.xdj.androiddemo.supportdesign;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.xdj.androiddemo.R;

/**
 * Created by xdj on 16/1/12.
 */
public class CoordinatorLayoutPagerActivity extends AppCompatActivity {
    private Toolbar mToobar;
    private TabLayout mTabLayout;
    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinator_pager_activity);
        mToobar = (Toolbar) findViewById(R.id.toolbar);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mPager = (ViewPager) findViewById(R.id.pager);
        mToobar.setTitle("RecyclerView");
        mPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));

        mTabLayout.setupWithViewPager(mPager);
    }

    class PagerAdapter extends FragmentPagerAdapter {
        String[] titles = new String[] {"TAB1", "TAB2", "TAB3"};

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new RecyclerFragment();
//            return new ListFragment();
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
