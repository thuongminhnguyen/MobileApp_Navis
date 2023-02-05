package com.example.mbbapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mbbapp.API_GetAllAtmTechnicianByUser.GetATMTechByUserActivity;
import com.example.mbbapp.API_GetAllDevice.GetDeviceActivity;

import com.example.mbbapp.Test.TestActivity;

public class GetActivity extends AppCompatActivity {
    private Button buttonGetATM;
    private Button buttonGetAllDevice;
    private Button buttongetUserUnit;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);
        buttonGetATM = findViewById(R.id.btn_getATM);
        buttonGetAllDevice= findViewById(R.id.btn_GetAllDevice);
        buttongetUserUnit = findViewById(R.id.get_uer_unit_test);

        buttonGetATM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GetActivity.this, GetATMTechByUserActivity.class));
               // setContentView(R.layout.activity_get_atm_tech_by_user);
            }
        });

        buttonGetAllDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GetActivity.this, GetDeviceActivity.class));
               // setContentView(R.layout.activity_get_all_device);
            }
        });

        buttongetUserUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unitIntent = new Intent(GetActivity.this, TestActivity.class);
                if(unitIntent != null)
                {
                    startActivity(unitIntent);
                }


            }
        });

    }

}