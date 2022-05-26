package com.example.myapplication.Api;

public class PlayerRatings {
    public int account_id;
    public int match_id;
    public int solo_competitive_rank;
    public int competitive_rank;
    public int time;

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public int getSolo_competitive_rank() {
        return solo_competitive_rank;
    }

    public void setSolo_competitive_rank(int solo_competitive_rank) {
        this.solo_competitive_rank = solo_competitive_rank;
    }

    public int getCompetitive_rank() {
        return competitive_rank;
    }

    public void setCompetitive_rank(int competitive_rank) {
        this.competitive_rank = competitive_rank;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
