package com.example.focus.androidnote.toolbar;

import android.support.v4.view.PagerAdapter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.focus.androidnote.BaseActivity;
import com.example.focus.androidnote.R;

import java.util.ArrayList;

public class ToolbarSlidingTabActivity extends BaseActivity {
    protected Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_sliding_tab);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        //替换ActionBar
        setSupportActionBar(mToolbar);
        //getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //关联menu布局文件
        //mToolbar.inflateMenu(R.menu.menu_main);
        //mToolbar.setTitle("Title");
        //设置导航按钮
        mToolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
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
//        MyAdapte adapter= new MyAdapte();
//        mPage.setAdapter(adapter);
//        mSlidingTabLayout.setViewPager(mPage);
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

    int[] colors={0xFF123456,0xFF654321,0xFF336699};

    class MyAdapte extends PagerAdapter {
        String[] titles={"AA","BB","CC"};

        ArrayList<LinearLayout> layouts=new ArrayList<LinearLayout>();
        MyAdapte() {

            for (int i = 0; i < 3; i++) {
                LinearLayout l=new LinearLayout(ToolbarSlidingTabActivity.this);
                l.setBackgroundColor(colors[i]);
                l.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
                layouts.add(l);
            }

        }

        @Override
        public int getCount() {
            return layouts.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view==o;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            LinearLayout l=layouts.get(position);
            container.addView(l);
            return l;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(layouts.get(position));
        }
        //Tab上显示的文字
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
