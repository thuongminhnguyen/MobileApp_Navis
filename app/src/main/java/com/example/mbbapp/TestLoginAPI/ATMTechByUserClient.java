package com.example.mbbapp.TestLoginAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ATMTechByUserClient {

    @GET("/AtmTechnician/GetAllAtmTechnicianByUser")
    Call<List<ATMTechByUser>> getAllAtmTech(@Header("Cookie")  String authToken);
}
