package io.github.xudaojie.androiddemo.reflact;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import io.github.xudaojie.androiddemo.BaseActivity;
import io.github.xudaojie.androiddemo.R;

/**
 * Created by xdj on 16/1/4.
 */
public class ReflactActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reflact_activity);
    }

    public void buttonOnClick(View view) {
        Class<?> demo = null;

        try {
            demo = Class.forName("com.example.xdj.androidnote.reflact.TestBean");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        TestBean bean = null;
        Constructor<?>[] constructors = demo.getConstructors();
        try {
            bean = (TestBean) constructors[0].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Log.d("ReflactActivity", bean.getName());

        try {
            Method method = bean.getClass().getMethod("getName");
            String name = (String) method.invoke(bean);
            Log.d("ReflactActivity", name);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
