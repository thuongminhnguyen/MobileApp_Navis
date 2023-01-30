package com.example.mbbapp.TestLoginAPI;

public class AccessToken {
    private int statusCode;
    private Data data;

    public AccessToken(int statusCode, Data data) {
        this.statusCode = statusCode;
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
