package me.xdj.drawablenote;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch (id) {
            case R.id.action_shape_rect:
                ft.replace(R.id.container, new ShapeRectFragment());
                break;
            case R.id.action_shape_oval:
                ft.replace(R.id.container, new ShapeOvalFragment());
                break;
            case R.id.action_shape_line:
                ft.replace(R.id.container, new ShapeLineFragment());
                break;
            case R.id.action_layer_list:
                break;
        }
        ft.commit();
        setTitle(item.getTitle());
        return true;
    }
}
