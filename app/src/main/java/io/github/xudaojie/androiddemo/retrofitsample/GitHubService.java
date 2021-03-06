package io.github.xudaojie.androiddemo.retrofitsample;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

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
