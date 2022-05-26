package com.example.myapplication.data.model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Service1 {
    @POST("/auth/login")
    Call<ResponseExample> body(@Body BodyOfId body);
}
