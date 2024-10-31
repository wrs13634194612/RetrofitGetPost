package com.example.iosdialogdemo;




import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PostUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_same);

        Retrofit retrofit = new Retrofit.Builder()
                                    .baseUrl("http://172.17.7.157:5000/")
                                    .build();

        Api api = retrofit.create(Api.class);

        Shop mShop = new Shop();
        mShop.setPosition("772024102801");
        mShop.setName("老凤祥");
        mShop.setIcon("http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg");
        mShop.setPhone("13952141236");
        mShop.setAddress("成都市双流区华阳时代广场a栋701室");
        Gson gson = new Gson();
        String json = gson.toJson(mShop);
        Log.d("TAG",""+ json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json); //json 형태를 RequestBody로 바꿔줌.
        api.postUser(requestBody).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.d("RetrofitExample", response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("onFailure",""+ t);

            }
        });

    }
}
