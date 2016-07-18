package io.github.xudaojie.login;

import javax.inject.Inject;

import io.github.xudaojie.BasePresenter;

/**
 * Created by xdj on 16/7/18.
 * 注入进行注入的构造方法必须显示注解@Inject
 * 测试无参构造函数注入
 */
public class LoginEmptyPresenter implements BasePresenter {

    @Inject
    public LoginEmptyPresenter() {
    }

    @Override
    public void start() {
    }
}
