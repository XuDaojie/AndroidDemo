package io.github.xudaojie.androiddemo.listview.viewmodel;

/**
 * Created by xdj on 2016/10/12.
 */

public abstract class BaseViewModel<T> {
    public T mModel;

    abstract int getType();
}