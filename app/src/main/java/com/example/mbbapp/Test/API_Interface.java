package com.example.mbbapp.Test;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface API_Interface {

     String BASE_URL = "http://203.171.20.94:8903";

    @GET("/UserUnit/GetUserUnit")
    Call<String> getUnitName(@Header("Cookie")  String authToken);
}
