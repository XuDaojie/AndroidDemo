package com.example.xdj.androiddemo.dagger;

/**
 * Created by xdj on 16/7/17.
 */
public class LoginPresenter implements LoginContact.Presenter {

    private final LoginContact.View mLoginView;

    public LoginPresenter(LoginContact.View mLoginView) {
        this.mLoginView = mLoginView;

        this.mLoginView.setPresenter(this);
    }

    @Override
    public void start() {
    }

    @Override
    public void login(String username, String password) {
        if ("Dagger2".equals(username)
                && "123456".equals(password)) {
            mLoginView.loginSuccess();
        } else {
            mLoginView.pwdFail();
        }
    }
}
