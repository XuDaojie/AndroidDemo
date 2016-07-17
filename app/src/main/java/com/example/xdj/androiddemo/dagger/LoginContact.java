package com.example.xdj.androiddemo.dagger;

import com.example.xdj.androiddemo.BasePresenter;
import com.example.xdj.androiddemo.BaseView;

/**
 * Created by xdj on 16/7/17.
 */

public interface LoginContact {
    interface View extends BaseView<Presenter> {
        void loginSuccess();

        void pwdFail();
    }

    interface Presenter extends BasePresenter{
        void login(String username, String password);
    }
}
