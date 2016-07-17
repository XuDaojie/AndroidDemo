package io.github.xudaojie.androiddemo.dagger;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xdj on 16/7/17.
 */
@Module
public class LoginPresenterModule {
    private LoginContact.View mView;

    public LoginPresenterModule(LoginContact.View mView) {
        this.mView = mView;
    }

    @Provides
    public LoginContact.View provideLoginView() {
        return mView;
    }
}
