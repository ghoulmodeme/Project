package com.example.myapplication.data;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceOfServer {
    private static Retrofit instance;
    public static Retrofit getInstance(){
        if(instance== null){
            instance = new Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:8080")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();        }
        return instance;
    }

}
