package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Api.Api;
import com.example.myapplication.Api.PlayerPeers;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeersActivity extends AppCompatActivity {
    private static final String BASE_URL = "https://api.opendota.com";
    ImageView av1,av2,av3;
    TextView t1,t2,t3;
    TextView t4,t5,t6;
    TextView t7,t8,t9;
    TextView t10,t11,t12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_peers);
        String id;
        Intent intent = getIntent();
        id = intent.getStringExtra("ID");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        t1 =findViewById(R.id.textView6);
        t2=findViewById(R.id.textView7);
        t3=findViewById(R.id.textView15);
        t4=findViewById(R.id.textView9);
        t5=findViewById(R.id.textView10);
        t6=findViewById(R.id.textView11);
        t7=findViewById(R.id.textView12);
        t8=findViewById(R.id.textView13);
        t9=findViewById(R.id.textView14);
        Button button = findViewById(R.id.button);


        Call<ArrayList<PlayerPeers>> call =api.getPlayerPeers(id);
        call.enqueue(new Callback<ArrayList<PlayerPeers>>() {
            @Override
            public void onResponse(Call<ArrayList<PlayerPeers>> call, Response<ArrayList<PlayerPeers>> response) {
                ArrayList<PlayerPeers> playerPeers=response.body();
                t1.setText("Name="+" "+playerPeers.get(0).personaname);
                t4.setText("Name="+" "+playerPeers.get(1).personaname);
                t7.setText("Name="+" "+playerPeers.get(2).personaname);
                t2.setText("Games with="+" "+playerPeers.get(0).games);
                t5.setText("Games with="+" "+playerPeers.get(1).games);
                t8.setText("Games with="+" "+playerPeers.get(2).games);
                t3.setText("Account id="+" "+ playerPeers.get(0).account_id);
                t6.setText("Account id ="+" "+ playerPeers.get(1).account_id);
                t9.setText("Account id ="+" "+ playerPeers.get(2).account_id);

            }

            @Override
            public void onFailure(Call<ArrayList<PlayerPeers>> call, Throwable t) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(PeersActivity.this,ProfileActivity.class);
                intent1.putExtra("ID",id);
                startActivity(intent1);
            }
        });
    }
}