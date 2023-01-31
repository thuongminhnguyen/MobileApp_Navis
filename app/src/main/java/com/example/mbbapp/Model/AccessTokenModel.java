package com.example.mbbapp.Model;

import com.example.mbbapp.Model.DataReposiLoginModel;

public class AccessTokenModel {
    private int statusCode;
    private DataReposiLoginModel data;

    public AccessTokenModel(int statusCode, DataReposiLoginModel data) {
        this.statusCode = statusCode;
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public DataReposiLoginModel getData() {
        return data;
    }

    public void setData(DataReposiLoginModel data) {
        this.data = data;
    }
}
