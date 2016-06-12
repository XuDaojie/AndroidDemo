package com.example.xdj.androiddemo.glide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xdj.androiddemo.BaseActivity;
import com.example.xdj.androiddemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by xdj on 15/11/2.
 */
public class GlideActivity extends BaseActivity {
    ImageView imageView;
    ListView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glide_activity);
        imageView = (ImageView) findViewById(R.id.my_image_view);
        mList = (ListView) findViewById(R.id.list);
        Glide.with(this).load("http://img.netbian.com/file/2015/1029/c083c3542cb48b50924f32429526a6ab.jpg").into(imageView);

        mList.setAdapter(new ListAdapter());
    }

    public void clearCacheOnClick(View view) {
        Glide.clear(imageView);
        Glide.get(this).clearMemory();
        new Thread() {
            @Override
            public void run() {
                super.run();
                Glide.get(GlideActivity.this.getApplication()).clearDiskCache(); // 需要在子线程中运行
            }
        };

    }

    public void resumeLoadOnClick(View view) {
        Glide.with(this).load("http://img.netbian.com/file/2015/1029/c083c3542cb48b50924f32429526a6ab.jpg").into(imageView);
    }

    /**
     * 图片圆角
     *
     * @param view
     */
    public void transformationOnClick(View view) {
//        Glide.with(this)
//                .load("http://img.netbian.com/file/2015/1029/c083c3542cb48b50924f32429526a6ab.jpg")
//                .bitmapTransform(new RoundedCornersTransformation(mContext, 50, 0, RoundedCornersTransformation.CornerType.ALL),
//                        new RoundedCornersTransformation(mContext, 50, 0, RoundedCornersTransformation.CornerType.TOP_RIGHT))
//                .into(imageView);
//        .load("http://pleaseenjoy.com/wp-content/uploads/2012/06/google_circle_logo.jpg")

        Glide.with(this)
//                .load("https://media.giphy.com/media/gXcIuJBbRi2Va/giphy.gif")
                .load("http://pleaseenjoy.com/wp-content/uploads/2012/06/google_circle_logo.jpg")
                .bitmapTransform(new RoundedCornersTransformation(mContext, 50, 0, RoundedCornersTransformation.CornerType.TOP))
                .into(imageView);
    }

    class ListAdapter extends BaseAdapter {

        String[] urls = new String[]{
                "http://ac-olwhhm4o.clouddn.com/4063qegYjlC8nx6uEqxV0kT3hn6hdqJqVWPKpdrS",
                "http://api.aoticenter.com/upload/dongtai/tongx_64_20160612103025742.png",
                "http://api.aoticenter.com/upload/dongtai/tongx_64_20160612103010968.png",
                "http://api.aoticenter.com/upload/dongtai/tongx_64_20160612093318055.png",
                "http://api.aoticenter.com/upload/dongtai/tongx_64_20160612093257081.png",

                "http://ac-olwhhm4o.clouddn.com/4063qegYjlC8nx6uEqxV0kT3hn6hdqJqVWPKpdrS",
                "http://api.aoticenter.com/upload/dongtai/tongx_64_20160612103025742.png",
                "http://api.aoticenter.com/upload/dongtai/tongx_64_20160612103010968.png",
                "http://api.aoticenter.com/upload/dongtai/tongx_64_20160612093318055.png",
                "http://api.aoticenter.com/upload/dongtai/tongx_64_20160612093257081.png",

                "http://ac-olwhhm4o.clouddn.com/4063qegYjlC8nx6uEqxV0kT3hn6hdqJqVWPKpdrS",
                "http://api.aoticenter.com/upload/dongtai/tongx_64_20160612103025742.png",
                "http://api.aoticenter.com/upload/dongtai/tongx_64_20160612103010968.png",
                "http://api.aoticenter.com/upload/dongtai/tongx_64_20160612093318055.png",
                "http://api.aoticenter.com/upload/dongtai/tongx_64_20160612093257081.png"
        };

        @Override
        public int getCount() {
            return urls.length;
        }

        @Override
        public Object getItem(int position) {
            return urls[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.glide_list_item, parent, false);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();

            }
            viewHolder.mText.setText("text" + position);
            // 存在复用问题需要去除动画和变形（图片大小不固定）
            Glide.with(mContext)
                    .load(urls[position])
                    .dontAnimate()
                    .dontTransform()
                    .placeholder(R.mipmap.image)
                    .error(R.mipmap.image)
                    .into(viewHolder.mImage);

            return convertView;
        }

        class ViewHolder {
            @Bind(R.id.text)
            TextView mText;
            @Bind(R.id.image)
            ImageView mImage;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }

}
