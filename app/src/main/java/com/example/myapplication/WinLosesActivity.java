package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.Api.Api;
import com.example.myapplication.Api.PlayerWl;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WinLosesActivity extends AppCompatActivity {
    private static final String BASE_URL = "https://api.opendota.com";
    TextView Wins,Loses;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_loses);
        String id;
        Intent intent = getIntent();
        Button b1 = findViewById(R.id.Wl);
        id = intent.getStringExtra("ID");
        System.out.println(id);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        back= findViewById(R.id.back);
        Wins = findViewById(R.id.Win);
        Loses = findViewById(R.id.Loses);
        Api api = retrofit.create(Api.class);

        Call<PlayerWl> call =api.getPlayerWL(id);
        call.enqueue(new Callback<PlayerWl>() {
            @Override
            public void onResponse(Call<PlayerWl> call, Response<PlayerWl> response) {

                PlayerWl playerWl = response.body();
                if(response.body()!=null){
                Wins.setText("You have"+" "+ playerWl.win+"wins");
                Loses.setText("You have"+" " + playerWl.lose+" loses");
            }if(response.body().lose.equals("0")){
                    Wins.setText("Your id is invalid");
                    Loses.setText("");
                }

            }


            @Override
            public void onFailure(Call<PlayerWl> call, Throwable t) {

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WinLosesActivity.this,ProfileActivity.class);
                startActivity(i);
            }
        });
    }
}