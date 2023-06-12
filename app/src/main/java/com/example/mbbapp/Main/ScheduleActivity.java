package com.example.mbbapp.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mbbapp.Login.LoginActivity;
import com.example.mbbapp.Main.Adapter.ScheduleAdapter;
import com.example.mbbapp.Main.Model.Model;
import com.example.mbbapp.Main.Model.ScheduleModel;
import com.example.mbbapp.R;
import com.google.gson.JsonIOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ScheduleActivity extends AppCompatActivity {

    private Spinner spinner;
    private EditText edtDateStart;
    private EditText edtDateFinish;
    private RecyclerView recyclerView;
    private Button button;

    private List<ScheduleModel> listScheduleByUnitModelList;

    private  String startDate, finishDate;
    private  int unitID, unitID_start;
    private ArrayList<String> getUnitNameName = new ArrayList<String>();
    private ArrayList<ScheduleModel> resultsData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_user_unit2);

        spinner = findViewById(R.id.spinner);
        edtDateStart = findViewById(R.id.edtDateStart);
        edtDateFinish = findViewById(R.id.edtDateFinish);
        recyclerView = findViewById(R.id.rcv_schedule);
        button = findViewById(R.id.button);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        listScheduleByUnitModelList = new ArrayList<>();
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        String curentDay = getCurrentDate();
        getUnitName();
        edtDateStart.setText(getCurrentDate());
        edtDateFinish.setText(getCurrentDate());
        displaySchedule(curentDay, curentDay, unitID_start);


        edtDateStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int check = 1;
                showDate(check);
            }
        });
        edtDateFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int check = 2;
                showDate(check);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displaySchedule(startDate, finishDate, unitID);
            }
        });

    }

    private String getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(currentDate);
        return formattedDate;
        // Sử dụng formattedDate theo nhu cầu của bạn
//        Log.d("CurrentDate", formattedDate);
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
                    startDate = edtDateStart.getText().toString();
                }
                if(check == 2){
                    edtDateFinish.setText(simpleDateFormat.format(calendar.getTime()));
                    finishDate = edtDateFinish.getText().toString();
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
                            for (int i = 0; i <jsonArray.length(); i++){
                                Model model = new Model();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                model.setId(jsonObject.getInt("id"));
                                model.setName(jsonObject.getString("name"));
                                getUnitNameData.add(model);
                            }

                                for (int i = 0; i < getUnitNameData.size(); i++) {
                                    Model model = getUnitNameData.get(i);
                                    if (model.getName() != null) {
                                        getUnitNameName.add(model.getName().toString());
                                    }
                                }
                            unitID_start = getUnitNameData.get(0).getId();
                            ArrayAdapter<String> spinUnitNameAdapter = new ArrayAdapter<String>( ScheduleActivity.this, android.R.layout.simple_spinner_item, getUnitNameName );

                            spinUnitNameAdapter.setDropDownViewResource(R.layout.dropdown_item);
                           spinner.setAdapter(spinUnitNameAdapter);
                           spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                               @Override
                               public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    unitID = getUnitNameData.get(position).getId();
                                    Log.d("GetRespone", String.valueOf(unitID));
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
                Toast.makeText(ScheduleActivity.this, "Failure UnitName", Toast.LENGTH_LONG).show();
            }
        });
    }
    private void displaySchedule(String startDate,String finishDate , int unitID){

        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_Interface.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        API_Interface api_interface = retrofit.create(API_Interface.class);
        api_interface.getSchedule(LoginActivity.token, startDate, finishDate, unitID).enqueue(new Callback<List<ScheduleModel>>() {
            @Override
            public void onResponse(Call<List<ScheduleModel>> call, Response<List<ScheduleModel>> response) {
                listScheduleByUnitModelList = response.body();
                ScheduleAdapter scheduleAdapter = new ScheduleAdapter(listScheduleByUnitModelList);
                recyclerView.setAdapter(scheduleAdapter);
            }
            @Override
            public void onFailure(Call<List<ScheduleModel>> call, Throwable t) {
                Toast.makeText(ScheduleActivity.this, "Failure", Toast.LENGTH_LONG).show();
            }
        });
    }
}