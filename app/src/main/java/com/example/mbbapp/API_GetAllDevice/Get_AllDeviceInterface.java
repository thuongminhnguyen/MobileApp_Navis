package com.example.mbbapp.API_GetAllDevice;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
public interface Get_AllDeviceInterface {
    @GET("/Device/GetAlllDevice")
    Call<List<GetAlllDeviceModel>> getAllDevice(@Header("Cookie")  String authToken);
}
