package com.example.myapplication.Api;


public class Player{
    public String tracked_until;
    public String solo_competitive_rank;
    public String competitive_rank;
    public String rank_tier;
    public String leaderboard_rank;
    public Profile profile;
    public Mmr_estimate mmr_estimate;

public class Mmr_estimate{
    public String estimate;

    public String getEstimate() {
        return estimate;
    }

    public void setEstimate(String estimate) {
        this.estimate = estimate;
    }
}
public class Profile{
    public String account_id;
    public String personaname;
    public String name;
    public String plus;
    public String cheese;
    public String steamid;
    public String avatar;
    public String avatarmedium;
    public String avatarfull;
    public String profileurl;
    public String last_login;
    public String loccountrycode;
    public String is_contributor;



    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getPersonaname() {
        return personaname;
    }

    public void setPersonaname(String personaname) {
        this.personaname = personaname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlus() {
        return plus;
    }

    public void setPlus(String plus) {
        this.plus = plus;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public String getSteamid() {
        return steamid;
    }

    public void setSteamid(String steamid) {
        this.steamid = steamid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatarmedium() {
        return avatarmedium;
    }

    public void setAvatarmedium(String avatarmedium) {
        this.avatarmedium = avatarmedium;
    }

    public String getAvatarfull() {
        return avatarfull;
    }

    public void setAvatarfull(String avatarfull) {
        this.avatarfull = avatarfull;
    }

    public String getProfileurl() {
        return profileurl;
    }

    public void setProfileurl(String profileurl) {
        this.profileurl = profileurl;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public String getLoccountrycode() {
        return loccountrycode;
    }

    public void setLoccountrycode(String loccountrycode) {
        this.loccountrycode = loccountrycode;
    }

    public String getIs_contributor() {
        return is_contributor;
    }

    public void setIs_contributor(String is_contributor) {
        this.is_contributor = is_contributor;
    }
}}

