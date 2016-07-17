package io.github.xudaojie.androiddemo.retrofitsample;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;

import io.github.xudaojie.androiddemo.BaseActivity;
import io.github.xudaojie.androiddemo.R;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

//import retrofit.GsonConverterFactory;

/**
 * Created by xdj on 15/11/8.
 */
public class RetrofitActivity
        extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrofit_activity);
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://121.41.128.239:8105/jizhong/index.php/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        GitHubService service = retrofit.create(GitHubService.class);
//
//        String timeline = String.valueOf(System.currentTimeMillis());
//        String sign = Times.getMd5(timeline, "bocweb", "1");
//        Call<WelcomeBean> call = service.welcome(timeline, sign, "1");
//        call.enqueue(new Callback<WelcomeBean>() {
//            @Override
//            public void onResponse(Response<WelcomeBean> response, Retrofit retrofit) {
//                Toast.makeText(mContext, response.body().getMsg(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                Toast.makeText(mContext, t.getMessage() + "", Toast.LENGTH_SHORT).show();
//            }
//        });

//        Call call1 = service.welcome1(timeline, sign, "1");
//        call1.enqueue(new Callback() {
//            @Override
//            public void onResponse(Response response, Retrofit retrofit) {
//                Toast.makeText(mContext, response.body().toString(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//        });

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.github.com")
//                .build();
//
//        GitHubService service = retrofit.create(GitHubService.class);
//        Call<List<Repo>> repos = service.listRepos("octocat");
        test();
    }

    private void test() {
//        http://192.168.0.239/ch/index.php/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.239/ch/index.php/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GitHubService service = retrofit.create(GitHubService.class);
        String timeline = String.valueOf(System.currentTimeMillis());
        Call<TestBean> call = service.welcome2("18768143566", "123456");
        call.enqueue(new Callback<TestBean>() {
            @Override
            public void onResponse(Response<TestBean> response, Retrofit retrofit) {
                if (response.body() == null) {
                    Toast.makeText(RetrofitActivity.this, "xx", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RetrofitActivity.this, response.body().getTimeline() + "", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(RetrofitActivity.this, "ss", Toast.LENGTH_SHORT).show();
            }
        });
        OkHttpClient okHttpClient = new OkHttpClient();
        FormEncodingBuilder builder = new FormEncodingBuilder()
                .add("mobile", "18768143566")
                .add("password", "123456");
        Request request = new Request.Builder()
                .url("http://192.168.0.239/ch/index.php/user/userLogin")
                .post(builder.build())
                .build();
        com.squareup.okhttp.Call okCall = okHttpClient.newCall(request);
        okCall.enqueue(new com.squareup.okhttp.Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(com.squareup.okhttp.Response response) throws IOException {
                String content = response.body().string();
                Log.d("xxx", content);
            }
        });
    }
}
