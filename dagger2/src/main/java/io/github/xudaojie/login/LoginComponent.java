package io.github.xudaojie.login;

import dagger.Component;

/**
 * Created by xdj on 16/7/17.
 */
@Component(modules = LoginPresenterModule.class)
public interface LoginComponent {
    void inject(LoginActivity activity);
}
