package com.example.mbbapp.Main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mbbapp.API_Login.LoginActivity;
import com.example.mbbapp.Main.Model.TechATMModel;
import com.example.mbbapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Fragment_Tech_ATM extends Fragment {
    private RecyclerView recyclerView;
    private List<TechATMModel> techATMModelList;
    private ArrayList<TechATMModel> resultsData = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view =  inflater.inflate(R.layout.fragment__tech__a_t_m, container, false);
        recyclerView = view.findViewById(R.id.recycleView_techATM);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        techATMModelList = new ArrayList<>();
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        showListTechATM();

        return view;

    }
    private void showListTechATM(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_Interface.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        API_Interface api_interface = retrofit.create(API_Interface.class);

        api_interface.getTechATM(LoginActivity.token).enqueue(new Callback<List<TechATMModel>>() {
            @Override
            public void onResponse(Call<List<TechATMModel>> call, Response<List<TechATMModel>> response) {
                techATMModelList = response.body();
                ATM_Tech_Adapter atm_tech_adapter = new ATM_Tech_Adapter(techATMModelList);
                recyclerView.setAdapter(atm_tech_adapter);
            }

            @Override
            public void onFailure(Call<List<TechATMModel>> call, Throwable t) {

            }
        });
    }
}