package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.Api.Api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RankingsActivity extends AppCompatActivity {
    private static final String BASE_URL = "https://api.opendota.com";
Button back;
TextView t1;
TextView t2;
TextView t3;
TextView t4;
TextView t5;
TextView t6;
TextView t7;
TextView t8;
TextView t9;
TextView t10;
TextView t11;
TextView t12;
TextView t13;
TextView t14;
TextView t15;
TextView t16;
TextView t17;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rankings);
        String id;
        Intent intent = getIntent();
        id = intent.getStringExtra("ID");
        System.out.println(id);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Call<ArrayList<com.example.myapplication.Api.Rankings>> call = api.getPlayerRankings(id);
        call.enqueue(new Callback<ArrayList<com.example.myapplication.Api.Rankings>>() {
            @Override
            public void onResponse(Call<ArrayList<com.example.myapplication.Api.Rankings>> call, Response<ArrayList<com.example.myapplication.Api.Rankings>> response) {
                ArrayList<com.example.myapplication.Api.Rankings> rankings = response.body();
                if(rankings.get(0).hero_id.equals("83")){

                }
                if(rankings.get(1).hero_id.equals("83")){

                }
                if(rankings.get(2).hero_id.equals("83")){

                }
                if(rankings.get(3).hero_id.equals("83")){

                }
                if(rankings.get(4).hero_id.equals("83")){

                }
                if(rankings.get(5).hero_id.equals("83")){

                }
                if(rankings.get(6).hero_id.equals("83")){

                }
                if(rankings.get(7).hero_id.equals("83")){

                }
                if(rankings.get(8).hero_id.equals("83")){

                }
                if(rankings.get(9).hero_id.equals("83")){

                }
                if(rankings.get(10).hero_id.equals("83")){

                }
                if(rankings.get(11).hero_id.equals("83")){

                }
                if(rankings.get(12).hero_id.equals("83")){

                }
                if(rankings.get(13).hero_id.equals("83")){

                }
                if(rankings.get(14).hero_id.equals("83")){

            }
}
            @Override
            public void onFailure(Call<ArrayList<com.example.myapplication.Api.Rankings>> call, Throwable t) {

            }
        });
    }
}