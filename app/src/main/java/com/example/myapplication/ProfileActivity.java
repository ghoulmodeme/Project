package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Api.Api;
import com.example.myapplication.Api.Rankings;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileActivity extends AppCompatActivity {
    private static final String BASE_URL = "https://api.opendota.com";
    Button b1,b2,b3,b4,b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        String id;
        Intent intent = getIntent();
        Button b1 = findViewById(R.id.Wl);
        Button b2 =findViewById(R.id.Rankgins);
        id = intent.getStringExtra("ID");
        System.out.println(id);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Call<ArrayList<Rankings>> call= api.getPlayerRankings(id);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ProfileActivity.this, WinLosesActivity.class);
                intent1.putExtra("ID",id);
                startActivity(intent1);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(ProfileActivity.this,RankingsActivity.class);
                intent2.putExtra("ID",id);
                startActivity(intent2);
            }
        });



    }
}