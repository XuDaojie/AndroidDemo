package com.example.focus.androidnote.popupwindow;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.focus.androidnote.BaseActivity;
import com.example.focus.androidnote.R;

public class PopupWindowActivity extends BaseActivity {

    private Button mPopWindowBtn;
    private Button mPopMenuBtn;

    private View mPopWindowView;
    private PopupWindow mPopWindow;

    private PopupMenu mPopMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);

        mPopWindowBtn = (Button) findViewById(R.id.pop_window_btn);
        mPopMenuBtn = (Button) findViewById(R.id.pop_menu_btn);

        mPopMenu = new PopupMenu(mContext, mPopMenuBtn);
        mPopMenu.getMenuInflater().inflate(R.menu.menu_popup_window, mPopMenu.getMenu());

        mPopWindowView = getLayoutInflater().inflate(R.layout.pop_window_layout, null);
        mPopWindow = new PopupWindow(mPopWindowView, 150, 120, true); // Focusable 为True，PopupWindow的点击事件才会相应
        mPopWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // 必须在代码中设置一下背景色，点击外面不会隐藏此弹窗
        //mPopWindow.setOutsideTouchable(true); // Focusable 为False时，不执行则点击外面不会隐藏此弹窗

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_popup_window, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(mContext, "Settings", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_refresh) {
            Toast.makeText(mContext, "Refresh", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    public void popMenuBtnOnClick(View view) {
        mPopMenu.show();
    }

    public void popWindowBtnOnClick(View view) {
        mPopWindow.showAsDropDown(view);
    }
}
