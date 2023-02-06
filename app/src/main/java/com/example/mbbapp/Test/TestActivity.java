package com.example.mbbapp.Test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mbbapp.API_GetAllDevice.GetDeviceActivity;
import com.example.mbbapp.API_Login.LoginActivity;
import com.example.mbbapp.R;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class TestActivity extends AppCompatActivity {

    private Spinner spinner;
    private EditText edtDateStart;
    private EditText edtDateFinish;
    private RecyclerView recyclerView;
    private Button button;

    private  String startDate, finishDate;
    private  int unitID;
    private ArrayList<String> getUnitNameName = new ArrayList<String>();
    private ArrayList<GetListScheduleByUnitModel> resultsData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_user_unit2);

        spinner = findViewById(R.id.spinner);
        edtDateStart = findViewById(R.id.edtDateStart);
        edtDateFinish = findViewById(R.id.edtDateFinish);
        recyclerView = findViewById(R.id.rcv_schedule);
        button = findViewById(R.id.button);

        getUnitName();
        edtDateStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int check = 1;
                showDate(check);
                startDate = edtDateStart.getText().toString();
            }


        });

        edtDateFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int check = 2;
                showDate(check);
                finishDate = edtDateFinish.getText().toString();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displaySchedule();
            }
        });

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(getApplicationContext(), resultsData);
        recyclerView.setAdapter(scheduleAdapter);
//        displaySchedule();

    }

    private void showDate(int check) {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                if(check == 1){
                    edtDateStart.setText(simpleDateFormat.format(calendar.getTime()));
                }
                if(check == 2){
                    edtDateFinish.setText(simpleDateFormat.format(calendar.getTime()));
                }

            }
        }, year, month, day);
        datePickerDialog.show();
    }

    private void getUnitName() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_Interface.BASE_URL).addConverterFactory(ScalarsConverterFactory.create()).build();
        API_Interface api_interface = retrofit.create(API_Interface.class);

        Call<String> call = api_interface.getUnitName(LoginActivity.token);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    if(response.body() != null){
                        try {
                            String getResponse = response.body().toString();
                            List<Model> getUnitNameData = new ArrayList<Model>();
                            JSONArray jsonArray = new JSONArray(getResponse);
                            getUnitNameData.add(new Model());
                            for (int i = 0; i <jsonArray.length(); i++){
                                Model model = new Model();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                model.setUnitName(jsonObject.getString("unitName"));
                                getUnitNameData.add(model);
                            }


                                for (int i = 0; i < getUnitNameData.size(); i++) {
                                    Model model = getUnitNameData.get(i);
                                    if (model.getUnitName() != null) {
                                        getUnitNameName.add(model.getUnitName().toString());
                                    }
                                }


                            ArrayAdapter<String> spinUnitNameAdapter = new ArrayAdapter<String>( TestActivity.this, android.R.layout.simple_spinner_item, getUnitNameName );

                            spinUnitNameAdapter.setDropDownViewResource(R.layout.dropdown_item);
                           spinner.setAdapter(spinUnitNameAdapter);
                           spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                               @Override
                               public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    unitID = getUnitNameData.get(position).getUnitId();
                               }

                               @Override
                               public void onNothingSelected(AdapterView<?> parent) {

                               }
                           });

                        }
                        catch (JsonIOException | JSONException exception){
                            exception.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(TestActivity.this, "Failure UnitName", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void displaySchedule(){


        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_Interface.BASE_URL).addConverterFactory(ScalarsConverterFactory.create()).build();
        API_Interface api_interface = retrofit.create(API_Interface.class);

        Call<String> call = api_interface.getSchedule(LoginActivity.token, startDate, finishDate, unitID);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    if(response.body() != null){
                        String getResponse = response.body().toString();
                        if(getResponse != null) {
                            if (getResponse != "Empty") {
                                List<GetListScheduleByUnitModel> getScheduleData = new ArrayList<>();
                                try {
                                    JSONArray jsonArray = new JSONArray(getResponse);
                                    getScheduleData.add(new GetListScheduleByUnitModel());
                                    for (int i = 0; i < jsonArray.length(); i++) {
                                        GetListScheduleByUnitModel getListScheduleByUnitModel = new GetListScheduleByUnitModel();
                                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                                        getListScheduleByUnitModel.setScheduleName(jsonObject.getString("scheduleName"));
                                        getListScheduleByUnitModel.setUnitName(jsonObject.getString("unitName"));
                                        getListScheduleByUnitModel.setCarPlateNumber(jsonObject.getString("carPlateNumber"));
                                        getListScheduleByUnitModel.setSecurityName(jsonObject.getString("securityName"));
                                        getListScheduleByUnitModel.setDriverName(jsonObject.getString("driverName"));
                                        getListScheduleByUnitModel.setOwnerName(jsonObject.getString("ownerName"));
                                        getListScheduleByUnitModel.setEscortName(jsonObject.getString("escortName"));
                                        getScheduleData.add(getListScheduleByUnitModel);
                                    }
                                    resultsData.addAll(getScheduleData);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                    }
                }
//                recyclerView.setHasFixedSize(true);
//                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
//                recyclerView.setLayoutManager(linearLayoutManager);
//                ScheduleAdapter scheduleAdapter = new ScheduleAdapter(getApplicationContext(), resultsData);
//                recyclerView.setAdapter(scheduleAdapter);

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(TestActivity.this, "Failure", Toast.LENGTH_LONG).show();
            }
        });

    }
}