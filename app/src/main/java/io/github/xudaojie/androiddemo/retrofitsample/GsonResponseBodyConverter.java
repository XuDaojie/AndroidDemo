package io.github.xudaojie.androiddemo.retrofitsample;

import android.util.Log;

import com.google.gson.Gson;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.lang.reflect.Type;

import retrofit.Converter;

//import retrofit.Utils;

/**
 * Created by xdj on 15/11/30.
 */
public class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final Type type;

    GsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String content = value.string();
        Log.d("GsonResponseBodyConverter", content);
        return gson.fromJson(content, type);

//        Reader reader = value.charStream();
//        try {
//            return gson.fromJson(reader, type);
//        } finally {
//            Utils.closeQuietly(reader);
//        }
    }
}
