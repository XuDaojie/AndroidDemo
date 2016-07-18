package io.github.xudaojie.simple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import io.github.xudaojie.R;
import io.github.xudaojie.util.ActivityUtils;

/**
 * Created by xdj on 16/7/17.
 * 如果需要注入的对象都可通过默认的无产构造函数生成,则可无需Module
 */
public class LoginActivity extends AppCompatActivity {

    @Inject
    LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dagger_act);

        LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager()
                .findFragmentById(R.id.content_frame);

        if (loginFragment == null) {
            loginFragment = LoginFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    loginFragment, R.id.content_frame);
        }

//        new LoginPresenter(loginFragment);
        DaggerLoginComponent.create()
                .inject(LoginActivity.this);
    }
}