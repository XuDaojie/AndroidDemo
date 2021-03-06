package io.github.xudaojie.androiddemo.frgament;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.xudaojie.androiddemo.R;


/**
 * Created by xdj on 15/8/28.
 */
public class FirstFragment extends Fragment {

    private int mColor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.text_fragment, container, false);
        root.setBackgroundColor(mColor);

        return root;
    }

    public void setColor(int color) {
        mColor = color;
    }
}
