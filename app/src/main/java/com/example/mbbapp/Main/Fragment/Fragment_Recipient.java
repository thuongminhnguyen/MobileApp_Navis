package com.example.mbbapp.Main.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mbbapp.Login.LoginActivity;
import com.example.mbbapp.Main.API_Interface;
import com.example.mbbapp.Main.Adapter.Recipient_Adapter;
import com.example.mbbapp.Main.Model.RecipientModel;
import com.example.mbbapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment_Recipient extends Fragment {


    private RecyclerView recyclerView;
    private List<RecipientModel> recipientModelList;
    private ArrayList<RecipientModel> resultsData = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view;
        view = inflater.inflate(R.layout.fragment__recipient, container, false);

        recyclerView = view.findViewById(R.id.recycleView_Recipient);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recipientModelList = new ArrayList<>();
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        showListAllRecipient();

        return view;
    }

    private void  showListAllRecipient(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_Interface.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        API_Interface api_interface = retrofit.create(API_Interface.class);

        api_interface.getAllRecipient(LoginActivity.token).enqueue(new Callback<List<RecipientModel>>() {
            @Override
            public void onResponse(Call<List<RecipientModel>> call, Response<List<RecipientModel>> response) {
                recipientModelList = response.body();
                Recipient_Adapter recipient_adapter = new Recipient_Adapter(recipientModelList);
                recyclerView.setAdapter(recipient_adapter);
            }

            @Override
            public void onFailure(Call<List<RecipientModel>> call, Throwable t) {

            }
        });
    }
}

