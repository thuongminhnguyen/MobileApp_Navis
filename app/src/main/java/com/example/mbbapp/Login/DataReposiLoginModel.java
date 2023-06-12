package com.example.mbbapp.Login;

public class DataReposiLoginModel {
    private String accessToken;
    private String scope;

    public DataReposiLoginModel(String accessToken, String scope) {
        this.accessToken = accessToken;
        this.scope = scope;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
