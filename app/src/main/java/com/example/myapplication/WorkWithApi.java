package com.example.myapplication;
import android.os.Build;

import androidx.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;


public class WorkWithApi {
    static private final String apiBase = "https://api.opendota.com/api/";
    public static JSONObject getMatches(long id) throws JSONException {
        String apiFunc = "matches/" + id;
        return new JSONObject(getData(apiBase + apiFunc));
    }

    public static JSONObject getPlayer(final long id) throws JSONException {
        String apiFunc = "/players/" + id;
        return new JSONObject(getData(apiBase + apiFunc));
    }

    public static JSONObject getPlayerWL(final long id) throws JSONException {
        String apiFunc = "/players/" + id + "/wl";
        return new JSONObject(getData(apiBase + apiFunc));
    }


    public static JSONArray getPlayerRecentMatches(final long id) throws JSONException {
        String apiFunc = "/players/" + id + "/recentmatches";
        return new JSONArray(getData(apiBase + apiFunc));
    }


    public static JSONArray getPlayerMatches(final long id) throws JSONException {
        String apiFunc = "/players/" + id + "/matches";
        return new JSONArray(getData(apiBase + apiFunc));
    }

    public static JSONArray getPlayerHeroes(final long id) throws JSONException {
        String apiFunc = "/players/" + id + "/heroes";
        return new JSONArray(getData(apiBase + apiFunc));
    }


    public static JSONArray getPlayerPeers(final long id) throws JSONException {
        String apiFunc = "/players/" + id + "/peers";
        return new JSONArray(getData(apiBase + apiFunc));
    }


    public static JSONArray getPlayerPros(final long id) throws JSONException {
        String apiFunc = "/players/" + id + "/pros";
        return new JSONArray(getData(apiBase + apiFunc));
    }


    public static JSONArray getPlayerTotals(final long id) throws JSONException {
        String apiFunc = "/players/" + id + "/totals";
        return new JSONArray(getData(apiBase + apiFunc));
    }


    public static JSONObject getPlayerCounts(final long id) throws JSONException {
        String apiFunc = "/players/" + id + "/counts";
        return new JSONObject(getData(apiBase + apiFunc));
    }


    public static JSONObject getPlayerWardMap(final long id) throws JSONException {
        String apiFunc = "/players/" + id + "/wardmap";
        return new JSONObject(getData(apiBase + apiFunc));
    }


    public static JSONObject getPlayerWordCloud(final long id) throws JSONException {
        String apiFunc = "/players/" + id + "/wordcloud";
        return new JSONObject(getData(apiBase + apiFunc));
    }


    public static JSONArray getPlayerRatings(final long id) throws JSONException {
        String apiFunc = "/players/" + id + "/ratings";
        return new JSONArray(getData(apiBase + apiFunc));
    }


    public static JSONArray getPlayerRankings(final long id) throws JSONException {
        String apiFunc = "/players/" + id + "/rankings";
        return new JSONArray(getData(apiBase + apiFunc));
    }


    public static void postPlayerRefresh(final long id) {
        String apiFunc = "/players/" + id + "/refresh";
        postData(apiBase + apiFunc);
    }

    public static JSONArray getProPlayers() throws JSONException {
        String apiFunc = "proplayers";
        return new JSONArray(getData(apiBase + apiFunc));
    }


    public static JSONArray getProMatches() throws JSONException {
        String apiFunc = "proplayers";
        return new JSONArray(getData(apiBase + apiFunc));
    }

    public static JSONArray getPublicMatches() throws JSONException {
        String apiFunc = "publicMatches";
        return new JSONArray(getData(apiBase + apiFunc));
    }
    public static JSONArray getHeroStats() throws JSONException {
        String apiFunc = "herostats";
        return new JSONArray(getData(apiBase + apiFunc));
    }


    public static JSONObject getDistributions() throws JSONException {
        String apiFunc = "distributions";
        return new JSONObject(getData(apiBase + apiFunc));
    }


    public static JSONObject getStatus() throws JSONException {
        String apiFunc = "status";
        return new JSONObject(getData(apiBase + apiFunc));
    }


    public static JSONObject getHealth() throws JSONException {
        String apiFunc = "health";
        return new JSONObject(getData(apiBase + apiFunc));
    }


    public static JSONArray getHeroes() throws JSONException {
        String apiFunc = "heroes";
        return new JSONArray(getData(apiBase + apiFunc));
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void getHeroImage(int id, String path) throws IOException, JSONException {
        JSONArray heroes = getHeroStats();


        JSONObject hero;
        if (id < 23) {
            hero = heroes.getJSONObject(id - 1);
        } else {
            hero = heroes.getJSONObject(id - 2);
        }

        String apiFunc = hero.getString("img");

        try (InputStream in = new URL(apiBase.substring(0, apiBase.length() - 5) + apiFunc).openStream()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                Files.copy(in, Paths.get(path + "/" + id + ".png"));
            }
        }
    }


    private static String getData(String apiCall) {
        StringBuilder result = new StringBuilder();

        try {
            URL url = new URL(apiCall);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            while ((output = br.readLine()) != null) {
                result.append(output);
            }

            conn.disconnect();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return result.toString();
    }


    private static void postData(String apiCall) {

        try {
            URL url = new URL(apiCall);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setFixedLengthStreamingMode(0);
            conn.setDoOutput(true);

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            conn.disconnect();
        } catch (IOException e) {

            e.printStackTrace();
        }}}





