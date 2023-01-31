package com.example.mbbapp.API_GetAllAtmTechnicianByUser;

import com.example.mbbapp.Model.ATMTechByUserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface Get_ATMTechByUserInterface {

    @GET("/AtmTechnician/GetAllAtmTechnicianByUser")
    Call<List<ATMTechByUserModel>> getAllAtmTech(@Header("Cookie")  String authToken);
}
