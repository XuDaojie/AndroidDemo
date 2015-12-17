package com.example.focus.androidnote.retrofitsample;

import android.os.Bundle;
import android.widget.Toast;

import com.example.focus.androidnote.BaseActivity;
import com.example.focus.androidnote.R;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
//import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by xdj on 15/11/8.
 */
public class RetrofitActivity
        extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://121.41.128.239:8105/jizhong/index.php/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GitHubService service = retrofit.create(GitHubService.class);

        String timeline = String.valueOf(System.currentTimeMillis());
        String sign = Times.getMd5(timeline, "bocweb", "1");
        Call<WelcomeBean> call = service.welcome(timeline, sign, "1");
        call.enqueue(new Callback<WelcomeBean>() {
            @Override
            public void onResponse(Response<WelcomeBean> response, Retrofit retrofit) {
                Toast.makeText(mContext, response.body().getMsg(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(mContext, t.getMessage() + "", Toast.LENGTH_SHORT).show();
            }
        });

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
    }

}
