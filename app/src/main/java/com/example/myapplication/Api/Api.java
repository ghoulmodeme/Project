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


    @GET("api/matches/{idm}")
    Call<Match> getMatch(@Path("idm") String idm);


    @GET("api/players/{id}")
    Call<Player> getPlayer(@Path("id") String id);

    @GET("api/players/{id}/wl")
    Call<PlayerWl> getPlayerWL(@Path("id") String id);

    @GET("/api/players/{id}/recentmatches")
    Call<RecentMatches> getPlayerRecentMatches(@Path("id") int id);

    @GET("/api/players/{id}/matches")
    Call<PlayerMatches> getPlayerMatches(@Path("id") int id);

    @GET("/api/players/{id}/heroes")
    Call<Heroes> getPlayerHeroes(@Path("id") String id);

    @GET("/api/players/{id}/peers")
    Call<PlayerPeers> getPlayerPeers(@Path("id") int id);

    @GET("/api/players/{id}/totals")
    Call<PlayersTotals> getPlayerTotals(@Path("id") int id);

    @GET("/api/players/{id}/wardmap")
    Call<WardMap> getPlayerWardMap(@Path("id") int id);

    @GET("/api/players/{id}/wordcloud")
    Call<WordCloud> getPlayerWordCloud(@Path("id") int id);

    @GET("/api/players/{id}/ratings")
    Call<PlayerRatings> getPlayerRatings(@Path("id") int id);

    @GET("/api/players/{id}/rankings")
    Call<ArrayList<Rankings>> getPlayerRankings(@Path("id") String id);



}

