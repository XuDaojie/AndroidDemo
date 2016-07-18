package io.github.xudaojie.simple;

import io.github.xudaojie.BasePresenter;
import io.github.xudaojie.BaseView;

/**
 * Created by xdj on 16/7/17.
 */

public interface LoginContact {
    interface View extends BaseView<Presenter> {
        void loginSuccess();

        void pwdFail();
    }

    interface Presenter extends BasePresenter {
        void login(String username, String password);
    }
}
