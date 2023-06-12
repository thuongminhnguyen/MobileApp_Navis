package com.example.mbbapp.Main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mbbapp.API_Login.LoginActivity;
import com.example.mbbapp.Main.Model.TechATMModel;
import com.example.mbbapp.Main.Model.VehicleModel;
import com.example.mbbapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class VehicelFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<VehicleModel> vehicleModelList;
    private ArrayList<VehicleModel> resultsData = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vehicel, container, false);
        recyclerView = view.findViewById(R.id.recycleView_vehicle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        vehicleModelList = new ArrayList<>();
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        showListVehicle();

        return view;
    }

    private void showListVehicle() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_Interface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API_Interface api_interface = retrofit.create(API_Interface.class);

        api_interface.getVehicle(LoginActivity.token).enqueue(new Callback<List<VehicleModel>>() {
            @Override
            public void onResponse(Call<List<VehicleModel>> call, Response<List<VehicleModel>> response) {
                vehicleModelList = response.body();
                Vehicle_Adapter vehicle_adapter = new Vehicle_Adapter(vehicleModelList);
                recyclerView.setAdapter(vehicle_adapter);
            }

            @Override
            public void onFailure(Call<List<VehicleModel>> call, Throwable t) {
                // Handle failure here
            }
        });
    }
}
