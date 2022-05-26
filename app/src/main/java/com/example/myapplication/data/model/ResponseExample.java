package com.example.myapplication.data.model;


public class ResponseExample {
    String token;
    int status;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ResponseExample(String token, int status) {
        this.token = token;
        this.status = status;
    }
}

