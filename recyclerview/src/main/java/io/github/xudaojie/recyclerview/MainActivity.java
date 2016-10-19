package io.github.xudaojie.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//        mRecyclerView.setLayoutManager(new TestLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        mRecyclerView.setLayoutManager(new MyLinearLayoutManager());
        mRecyclerView.setLayoutManager(new MyGridLayoutManager(4));
//        mRecyclerView.setLayoutManager(new MyExpandGridLayoutManager());
        mRecyclerView.setAdapter(new RecyclerAdapter());
//        DiffUtil.
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        return super.onOptionsItemSelected(item);
        int id = item.getItemId();
        if (id == R.id.action_diff) {

        }
        return true;
    }


}
