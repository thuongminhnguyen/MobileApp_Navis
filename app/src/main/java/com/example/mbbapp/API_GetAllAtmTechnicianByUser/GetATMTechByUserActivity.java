package com.example.mbbapp.API_GetAllAtmTechnicianByUser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mbbapp.R;
import com.example.mbbapp.API_Login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetATMTechByUserActivity extends AppCompatActivity {

    Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://203.171.20.94:8903")
            .addConverterFactory(GsonConverterFactory.create());
    Retrofit retrofit = builder.build();
    Get_ATMTechByUserInterface atmTechByUserClient = retrofit.create(Get_ATMTechByUserInterface.class);
    private List<ATMTechByUserModel> listAtmTechByUsers;
    private RecyclerView recyclerView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_atm_tech_by_user);
        recyclerView = findViewById(R.id.rcv_atm);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        listAtmTechByUsers = new ArrayList<>();
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        callApiGetAtmByUser();

    }

    private void callApiGetAtmByUser(){
        atmTechByUserClient.getAllAtmTech(LoginActivity.token).enqueue(new Callback<List<ATMTechByUserModel>>() {
            @Override
            public void onResponse(Call<List<ATMTechByUserModel>> call, Response<List<ATMTechByUserModel>> response) {
                listAtmTechByUsers = response.body();
                GetATMAdapter getATMAdapter = new GetATMAdapter(listAtmTechByUsers);
                recyclerView.setAdapter(getATMAdapter);
            }

            @Override
            public void onFailure(Call<List<ATMTechByUserModel>> call, Throwable t) {
                Toast.makeText(GetATMTechByUserActivity.this, "Failure", Toast.LENGTH_LONG).show();
            }
        });
    }
}