package com.example.focus.androidnote.retrofitsample;

import java.util.List;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by xdj on 15/11/8.
 */
public interface GitHubService {

//    @POST("welcome")
//    Call welcome(@Field("timeline") String timeline, @Field("sign") String sign, @Field("ctype")  String ctype);
    @FormUrlEncoded
    @POST("welcome")
    Call<WelcomeBean> welcome(@Field("timeline") String timeline, @Field("sign") String sign, @Field("ctype")  String ctype);

    @FormUrlEncoded
    @POST("welcome")
    Call welcome1(@Field("timeline") String timeline, @Field("sign") String sign, @Field("ctype")  String ctype);

    @FormUrlEncoded
    @POST("userLogin")
    Call<TestBean> welcome2(@Field("mobile") String timeline, @Field("password") String sign);
}
