package com.example.myapplication.Api;

import retrofit2.http.GET;
import retrofit2.http.Path;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

    @GET("/api/players/{id}/totals")
    Call<ArrayList<Totals>> getTotals(@Path("id") String id);

    @GET("api/players/{id}")
    Call<Player> getPlayer(@Path("id") String id);

    @GET("api/players/{id}/wl")
    Call<PlayerWl> getPlayerWL(@Path("id") String id);

    @GET("/api/players/{id}/recentmatches")
    Call<PlayerMatches> getPlayerRecentMatches(@Path("id") String id);


    @GET("/api/players/{id}/peers")
    Call<ArrayList<PlayerPeers>> getPlayerPeers(@Path("id") String id);




    @GET("/api/players/{id}/wordcloud")
    Call<WordCloud> getPlayerWordCloud(@Path("id") String id);

    @GET("/api/players/{id}/ratings")
    Call<PlayerRatings> getPlayerRatings(@Path("id") int id);

    @GET("/api/players/{id}/rankings")
    Call<ArrayList<Rankings>> getPlayerRankings(@Path("id") String id);



}

