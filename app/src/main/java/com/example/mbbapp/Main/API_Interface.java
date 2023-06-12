package com.example.mbbapp.Main;
import com.example.mbbapp.Main.Model.DriverModel;
import com.example.mbbapp.Main.Model.EscortModel;
import com.example.mbbapp.Main.Model.OwnerATMModel;
import com.example.mbbapp.Main.Model.RecipientModel;
import com.example.mbbapp.Main.Model.ScheduleModel;
import com.example.mbbapp.Main.Model.TechATMModel;
import com.example.mbbapp.Main.Model.VehicleModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface API_Interface {

     String BASE_URL = "http://203.171.20.94:8903";

    @GET("/VehicleGroup/GetVehicleGroupByUser")
    Call<String> getUnitName(@Header("Cookie")  String authToken);

    //http://203.171.20.94:8903/Schedule/GetListScheduleByUnit?fromDate=2023-02-03&toDate=2023-02-03&unitId=33
    @GET("/Schedule/GetListScheduleByUnit")
    Call<List<ScheduleModel>> getSchedule(@Header("Cookie")  String authToken,
                                          @Query("fromDate") String fromDate,
                                          @Query("toDate") String toDate,
                                          @Query("unitId") int unitId);

    //http://203.171.20.94:8903/Driver/GetAllDriverByUser
    @GET("/Driver/GetAllDriverByUser")
    Call<List<DriverModel>> getAllDriver(@Header("Cookie")  String authToken);

    @GET("/AtmTechnician/GetAllAtmTechnicianByUser")
    Call<List<OwnerATMModel>> getAllATM(@Header("Cookie")  String authToken);


    @GET("/Escort/GetAllEscortByUser")
    Call<List<EscortModel>> getAllEscort(@Header("Cookie")  String authToken);

    @GET("/Recipient/GetAllRecipientByUser")
    Call<List<RecipientModel>> getAllRecipient(@Header("Cookie")  String authToken);

    @GET("/AtmTechnician/GetAllAtmTechnicianByUser")
    Call<List<TechATMModel>> getTechATM(@Header("Cookie")  String authToken);

    @GET("/Vehicle/GetAllVehicleByUser")
    Call<List<VehicleModel>> getVehicle(@Header("Cookie")  String authToken);
}
