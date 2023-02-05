package com.example.mbbapp.API_GetAllDevice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mbbapp.API_Login.LoginActivity;
import com.example.mbbapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetDeviceActivity extends AppCompatActivity {

    Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://203.171.20.94:8903")
            .addConverterFactory(GsonConverterFactory.create());
    Retrofit retrofit = builder.build();
    Get_AllDeviceInterface get_allDeviceInterface = retrofit.create(Get_AllDeviceInterface.class);
    private List<GetAlllDeviceModel> alllDeviceModelList;
    private RecyclerView recyclerView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all_device);
        recyclerView = findViewById(R.id.get_allDevice);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        alllDeviceModelList = new ArrayList<>();
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        callAPIGetAllDevice();
    }

    private void callAPIGetAllDevice() {
        get_allDeviceInterface.getAllDevice(LoginActivity.token).enqueue(new Callback<List<GetAlllDeviceModel>>() {
            @Override
            public void onResponse(Call<List<GetAlllDeviceModel>> call, Response<List<GetAlllDeviceModel>> response) {
                alllDeviceModelList = response.body();
                GetAllDeviceAdapter getAllDeviceAdapter = new GetAllDeviceAdapter(alllDeviceModelList);
                recyclerView.setAdapter(getAllDeviceAdapter);
            }

            @Override
            public void onFailure(Call<List<GetAlllDeviceModel>> call, Throwable t) {
                Toast.makeText(GetDeviceActivity.this, "Failure", Toast.LENGTH_LONG).show();
            }
        });
    }
}