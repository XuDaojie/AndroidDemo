package io.github.xudaojie.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import io.github.xudaojie.R;
import io.github.xudaojie.util.ActivityUtils;

/**
 * Created by xdj on 16/7/17.
 * Dagger2
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
        DaggerLoginComponent.builder()
                .loginPresenterModule(new LoginPresenterModule(loginFragment))
                .build()
                .inject(this);
    }
}