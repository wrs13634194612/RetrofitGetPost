package com.example.iosdialogdemo;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GetIpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_same);


        Retrofit retrofit = new Retrofit.Builder()
                                    .baseUrl("http://172.17.7.157:5000/")
                                    .build();

        Api api = retrofit.create(Api.class);

        api.sendRequest("api/shop/").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    final String body = response.body().string();
                    Log.e("TAG","onResponse:"+response+body);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }



            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("TAG","onFailure:"+t);

            }
        });

    }}