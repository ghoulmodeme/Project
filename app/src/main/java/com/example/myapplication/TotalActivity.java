package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.Api.Api;
import com.example.myapplication.Api.Totals;
import com.example.myapplication.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TotalActivity extends AppCompatActivity {
    private static final String BASE_URL = "https://api.opendota.com";
    TextView t1,t2,t3,t4,t5,t6;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);
        t1=findViewById(R.id.textView8);
        t2=findViewById(R.id.textView16);
        t3=findViewById(R.id.textView17);
        t4=findViewById(R.id.textView18);
        t5=findViewById(R.id.textView19);
        t6=findViewById(R.id.textView20);
        back = findViewById(R.id.button3);

        String id;
        Intent intent = getIntent();
        id = intent.getStringExtra("ID");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Call<ArrayList<Totals>> call =api.getTotals(id);
        call.enqueue(new Callback<ArrayList<Totals>>() {
            @Override
            public void onResponse(Call<ArrayList<Totals>> call, Response<ArrayList<Totals>> response) {
                ArrayList<Totals> arrayList =response.body();
                t1.setText(arrayList.get(0).field+" = "+" "+arrayList.get(1).n);
                t2.setText(arrayList.get(1).field+" = "+" "+arrayList.get(2).n);
                t3.setText(arrayList.get(2).field+" = "+" "+arrayList.get(3).n);
                t4.setText(arrayList.get(3).field+" = "+" "+arrayList.get(4).n);
                t5.setText(arrayList.get(4).field+" = "+" "+arrayList.get(5).n);
                t6.setText(arrayList.get(5).field+" = "+" "+arrayList.get(6).n);
            }

            @Override
            public void onFailure(Call<ArrayList<Totals>> call, Throwable t) {

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(TotalActivity.this,ProfileActivity.class);
                intent1.putExtra("ID",id);
                startActivity(intent1);
            }
        });
    }
}