package io.github.xudaojie.androiddemo.listview;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.github.xudaojie.androiddemo.BaseActivity;
import io.github.xudaojie.androiddemo.R;

/**
 * Created by xdj on 16/5/25.
 */
public class ListViewActivity extends BaseActivity {
    @Bind(R.id.list)
    ListView mList;

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        ButterKnife.bind(this);
        initListView();
    }

//    private void initListView() {
//        String[] data = new String[30];
//        for (int i = 0; i < data.length; i++) {
//            data[i] = ('a' + i) + "";
//        }
//
////        mList.setAdapter(new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_multiple_choice, data));
//        mList.setAdapter(new ArrayAdapter<>(mContext,
//                R.layout.simple_custom_list_item_multiple_choice,
//                R.id.text,
//                data));
//        mList.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
////        mList.setItemsCanFocus(false);
//        mList.setItemChecked(13, true);
//    }

    private void initListView() {
//        mList.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        mList.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        mList.setAdapter(new ListCheckedAdapter());
    }

    class ListCheckedAdapter extends BaseAdapter {

        char[] chars = new char[26];

        public ListCheckedAdapter() {
            for (int i = 0; i < chars.length; i++) {
                chars[i] = (char) ('a' + i);
            }
        }

        @Override
        public int getCount() {
            return chars.length;
        }

        @Override
        public Object getItem(int position) {
            return chars[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext)
                        .inflate(R.layout.custom_list_item_multiple_choice, parent, false);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.mTitleTv.setText(chars[position] + "");
            viewHolder.mContentTv.setText((chars[position] + "").toUpperCase());
            return convertView;
        }

        class ViewHolder {
            @Bind(R.id.title_tv)
            TextView mTitleTv;
            @Bind(R.id.content_tv)
            TextView mContentTv;
            @Bind(R.id.cek)
            CheckBox mCek;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }
}
