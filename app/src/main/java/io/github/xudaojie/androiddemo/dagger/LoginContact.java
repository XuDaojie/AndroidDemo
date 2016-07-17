package io.github.xudaojie.androiddemo.dagger;

import io.github.xudaojie.androiddemo.BasePresenter;
import io.github.xudaojie.androiddemo.BaseView;

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
