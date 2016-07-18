package io.github.xudaojie.simple;

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

import io.github.xudaojie.R;

/**
 * Created by xdj on 16/7/17.
 */

public class LoginFragment extends Fragment implements LoginContact.View {

    private EditText mUsernameEt;
    private EditText mPasswordEt;
    private Button mLoginBtn;

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
        mUsernameEt = (EditText) mRootView.findViewById(R.id.username_et);
        mPasswordEt = (EditText) mRootView.findViewById(R.id.password_et);
        mLoginBtn = (Button) mRootView.findViewById(R.id.login_btn);

//        mPresenter.start();

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUsernameEt.getText().toString();
                String password = mPasswordEt.getText().toString();
//                mPresenter.login(username, password);
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

}
