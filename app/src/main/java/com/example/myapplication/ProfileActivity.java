package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Api.Api;
import com.example.myapplication.Api.Player;
import com.example.myapplication.Api.Rankings;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileActivity extends AppCompatActivity {
    private static final String BASE_URL = "https://api.opendota.com";
    Button b1,b2,b3,b4;
    ImageView avatar;
    TextView name,lastlogin,mmr,rank;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        String id;
        Intent intent = getIntent();
        Button b1 = findViewById(R.id.Wl);
        Button b2 =findViewById(R.id.Rankgins);
        b3 =findViewById(R.id.button2);
        b4= findViewById(R.id.button6);
        name = findViewById(R.id.name);
        mmr = findViewById(R.id.mmr);
        lastlogin=findViewById(R.id.last_login);
        rank=findViewById(R.id.rank);
        id = intent.getStringExtra("ID");
        avatar = findViewById(R.id.avatar);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Call<Player> call = api.getPlayer(id);
        call.enqueue(new Callback<Player>() {
            @Override
            public void onResponse(Call<Player> call, Response<Player> response) {
                Player player = response.body();
                Picasso.get().load(player.profile.avatarfull).into(avatar);
                name.setText("Name="+" "+player.profile.personaname);
                mmr.setText("Mmr="+" "+player.mmr_estimate.estimate);
                rank.setText("Rank="+" "+player.rank_tier);
                lastlogin.setText("Id="+" "+player.profile.account_id);



            }

            @Override
            public void onFailure(Call<Player> call, Throwable t) {

            }
        });
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
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(ProfileActivity.this,PeersActivity.class);
                intent3.putExtra("ID",id);
                startActivity(intent3);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(ProfileActivity.this,TotalActivity.class);
                intent4.putExtra("ID",id);
                startActivity(intent4);
            }
        });



    }
}