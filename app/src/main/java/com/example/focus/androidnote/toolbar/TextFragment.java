package com.example.focus.androidnote.toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.focus.androidnote.R;

/**
 * Created by focus on 15/7/26.
 */
public class TextFragment extends Fragment {
    private static final String TAG = "TextFragment";
    String mText;
    TextView mTextTv;

    public static TextFragment newInstance(String text) {
        TextFragment fragment = new TextFragment();
        fragment.mText = text;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_text, container, false);
        //root.setBackgroundColor(Color.BLUE);
        mTextTv = (TextView) root.findViewById(R.id.text_tv);
        mTextTv.setText(mText);
        Log.d(TAG, "onCreateView");
        return root;
    }


}
