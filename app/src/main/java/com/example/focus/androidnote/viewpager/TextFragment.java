package com.example.focus.androidnote.viewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.focus.androidnote.R;

public class TextFragment extends Fragment {
    private static final String TAG = "TextFragment";
    String mText;
    String mBackground;
    TextView mTextTv;

    public static TextFragment newInstance(String text, String background) {
        TextFragment fragment = new TextFragment();
        fragment.mText = text;
        fragment.mBackground = background;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.text_fragment, container, false);
        if (!TextUtils.isEmpty(mBackground)) {
            root.setBackgroundColor(Color.parseColor(mBackground));
        }
        mTextTv = (TextView) root.findViewById(R.id.text_tv);
        mTextTv.setText(mText);
        Log.d(TAG, "onCreateView");
        return root;
    }

}
