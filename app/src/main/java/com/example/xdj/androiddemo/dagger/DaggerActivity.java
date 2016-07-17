package com.example.xdj.androiddemo.dagger;

import android.os.Bundle;

import com.example.xdj.androiddemo.BaseActivity;
import com.example.xdj.androiddemo.R;
import com.example.xdj.androiddemo.util.ActivityUtils;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by xdj on 16/7/17.
 * Dagger2
 */
public class DaggerActivity extends BaseActivity {

    @Inject
    LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dagger_act);
        ButterKnife.bind(this);

        LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager()
                .findFragmentById(R.id.content_frame);

        if (loginFragment == null) {
            loginFragment = LoginFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    loginFragment, R.id.content_frame);
        }

//        new LoginPresenter(loginFragment);
        DaggerLoginComponent.builder()
                .loginPresenterModule(new LoginPresenterModule(loginFragment))
                .build()
                .inject(this);
    }
}