package com.example.xdj.androiddemo.dagger;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xdj.androiddemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xdj on 16/7/17.
 */

public class LoginFragment extends Fragment implements LoginContact.View {


    @Bind(R.id.username_et)
    EditText mUsernameEt;
    @Bind(R.id.password_et)
    EditText mPasswordEt;
    @Bind(R.id.login_btn)
    Button mLoginBtn;

    private Activity mActivity;
    private View mRootView;

    private LoginContact.Presenter mPresenter;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mRootView = inflater.inflate(R.layout.dagger_frag, container, false);
        ButterKnife.bind(this, mRootView);

        mPresenter.start();

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUsernameEt.getText().toString();
                String password = mPasswordEt.getText().toString();
                mPresenter.login(username, password);
            }
        });

        return mRootView;
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(mActivity, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void pwdFail() {
        Toast.makeText(mActivity, "密码错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(LoginContact.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
