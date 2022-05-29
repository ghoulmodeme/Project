package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.Api.Api;
import com.example.myapplication.Api.Rankings;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RankingsActivity extends AppCompatActivity {
    private static final String BASE_URL = "https://api.opendota.com";
Button back;
TextView t1,t2,t3,t4,t5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rankings);
        String id;
        Intent intent = getIntent();
        t1 = findViewById(R.id.textView);
        t2=findViewById(R.id.textView2);
        t3=findViewById(R.id.textView3);
        t4=findViewById(R.id.textView4);
        t5=findViewById(R.id.textView5);
        back =findViewById(R.id.back1);
        id = intent.getStringExtra("ID");



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Call<ArrayList<Rankings>> call =api.getPlayerRankings(id);
        call.enqueue(new Callback<ArrayList<Rankings>>() {
            @Override
            public void onResponse(Call<ArrayList<Rankings>> call, Response<ArrayList<Rankings>> response) {
                ArrayList<Rankings > rankings =response.body();
                t1.setText("Your score on hero with id "+" "+rankings.get(0).hero_id+"="+rankings.get(0).score);
                t2.setText("Your score on hero with id "+" "+rankings.get(1).hero_id+"="+rankings.get(1).score);
                t3.setText("Your score on hero with id "+" "+rankings.get(2).hero_id+"="+rankings.get(2).score);
                t4.setText("Your score on hero with id "+" "+rankings.get(2).hero_id+"="+rankings.get(2).score);
                t5.setText("Your score on hero with id "+" "+rankings.get(3).hero_id+"="+rankings.get(3).score);


            }

            @Override
            public void onFailure(Call<ArrayList<Rankings>> call, Throwable t) {

            }
        });
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(RankingsActivity.this,ProfileActivity.class);
                intent1.putExtra("ID",id);
                startActivity(intent1);
            }
        });
    }
}