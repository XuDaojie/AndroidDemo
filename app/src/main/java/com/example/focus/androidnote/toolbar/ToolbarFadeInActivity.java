package com.example.focus.androidnote.toolbar;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.focus.androidnote.BaseActivity;
import com.example.focus.androidnote.R;
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
        setContentView(R.layout.toolbar_fade_in_activity);

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
            public void onScrollChanged(int y) {
                if (y >= 0 && y <= 255) {
                    mToolbar.setBackgroundColor(Color.argb(y, 0, 0, 255));
                }
                int[] toolbarLocation = new int[2];
                int[] toolbarTaglocation = new int[2];
                mToolbarTab.getLocationOnScreen(toolbarTaglocation);
                mToolbar.getLocationOnScreen(toolbarLocation);
Log.d(TAG, toolbarTaglocation[1] + "");
                //
                if (toolbarLocation[1] + mToolbar.getHeight() == toolbarTaglocation[1]) {
                    Toast.makeText(mContext, "贴合", Toast.LENGTH_SHORT).show();
                    mToolbar.setBackgroundColor(Color.argb(255, 0, 0, 255));
                }
            }
        });

        //滑动停靠
        GestureDetector.OnGestureListener test = new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                //return super.onFling(e1, e2, velocityX, velocityY);
                //判断上滑还是下滑
                if (e1 == null) {
                    return false;
                }
                Log.d(TAG, "e1:" + e1.getY() + " e2:" + e2.getY());
                if (e2.getY() - e1.getY() > 100) {
                    Log.d(TAG, "Filing Down");
                    Toast.makeText(mContext, "Filing Down", Toast.LENGTH_SHORT).show();
                } else {
                    Log.d(TAG, "Filing Up");
                    //Toast.makeText(mContext, "Filing Up", Toast.LENGTH_SHORT).show();
                    mMainLayout.smoothScrollTo(0,mToolbarTab.getTop() - mToolbar.getBottom());
                    return true;
                }

                return false;
            }
        };
        final GestureDetector gestureDetector = new GestureDetector(mContext, test);

        //如果是向上快速滑动，直接贴边后继续向上滑
        mMainLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

//                int[] toolbarLocation = new int[2];
//                int[] toolbarTaglocation = new int[2];
//                mToolbarTab.getLocationOnScreen(toolbarTaglocation);
//                mToolbar.getLocationOnScreen(toolbarLocation);
//                //
//                if (toolbarLocation[1] + mToolbar.getHeight() == toolbarTaglocation[1]) {
//                    Toast.makeText(mContext, "贴合", Toast.LENGTH_SHORT).show();
//                    mToolbar.setBackgroundColor(Color.argb(255, 0, 0, 255));
//                }

//                int[] location = new int[2];
//                mToolbarTab.getLocationOnScreen(location);
//                //mMainLayout.smoothScrollTo(location[0], mToolbarBottonY);
//                //mMainLayout.scrollTo(location[0], mToolbarBottonY);
//                //
//                if (mToolbar.getBottom() == location[1]) {
//                    Toast.makeText(mContext, "贴合", Toast.LENGTH_SHORT).show();
//                    mToolbar.setBackgroundColor(Color.argb(255, 0, 0, 255));
//                }

                return gestureDetector.onTouchEvent(event);
                //return true； //停止滚动
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

    /**
     * 通过将ToolbarTab移动到和Toolbar到为同一层，
     * 来实现固定mToolbarTab
     * */
    private void setToolbarTabFix() {

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
