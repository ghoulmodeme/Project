package com.example.myapplication.Api;

public class PlayerMatches {
    public int match_id;
    public int duration;
    public int game_mode;
    public int hero_id;
    public int kill;
    public int deaths;
    public int assists;
    public int party_size;

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getGame_mode() {
        return game_mode;
    }

    public void setGame_mode(int game_mode) {
        this.game_mode = game_mode;
    }

    public int getHero_id() {
        return hero_id;
    }

    public void setHero_id(int hero_id) {
        this.hero_id = hero_id;
    }

    public int getKill() {
        return kill;
    }

    public void setKill(int kill) {
        this.kill = kill;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getParty_size() {
        return party_size;
    }

    public void setParty_size(int party_size) {
        this.party_size = party_size;
    }
}
