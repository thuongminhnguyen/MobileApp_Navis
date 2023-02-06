package com.example.mbbapp.Test;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface API_Interface {

     String BASE_URL = "http://203.171.20.94:8903";

    @GET("/UserUnit/GetUserUnit")
    Call<String> getUnitName(@Header("Cookie")  String authToken);

    @GET("/Schedule/GetListScheduleByUnit")
    Call<String> getSchedule(@Header("Cookie")  String authToken,
                                                 @Query("fromDate") String fromDate,
                                                 @Query("toDate") String toDate,
                                                 @Query("unitId") int unitId);
}
