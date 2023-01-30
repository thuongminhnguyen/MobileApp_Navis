package com.example.mbbapp.TestLoginAPI;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mbbapp.R;

public class GetActivity extends AppCompatActivity {
    private Button buttonGetATM;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_atmtech_by_user);
        buttonGetATM = findViewById(R.id.btn_getATM);
        buttonGetATM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GetActivity.this, GetATMTechByUser.class));
                setContentView(R.layout.activity_view_list_atm);
            }
        });

    }

}