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
import com.example.mbbapp.Model.DriverModel;
import com.example.mbbapp.Model.OwnerATMModel;
import com.example.mbbapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment_Owner_ATM extends Fragment {


    private RecyclerView recyclerView;
    private List<OwnerATMModel> ownerATMModelList;
    private ArrayList<OwnerATMModel> resultsData = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view;
        view = inflater.inflate(R.layout.fragment__owner__a_t_m, container, false);

        recyclerView = view.findViewById(R.id.recycleView_owner_ATM);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        ownerATMModelList = new ArrayList<>();
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        showListOwnerATM();

        return view;
    }

    private void showListOwnerATM(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_Interface.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        API_Interface api_interface = retrofit.create(API_Interface.class);

        api_interface.getAllATM(LoginActivity.token).enqueue(new Callback<List<OwnerATMModel>>() {
            @Override
            public void onResponse(Call<List<OwnerATMModel>> call, Response<List<OwnerATMModel>> response) {
                ownerATMModelList = response.body();
                ATM_Adapter atm_adapter = new ATM_Adapter(ownerATMModelList);
                recyclerView.setAdapter(atm_adapter);
            }

            @Override
            public void onFailure(Call<List<OwnerATMModel>> call, Throwable t) {

            }
        });
    }
}

