package com.example.mbbapp.API_Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mbbapp.R;

public class Sign_up_activity extends AppCompatActivity {

    TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        login = findViewById(R.id.loginRedirectText);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sign_up_activity.this, LoginActivity.class));
            }
        });
    }
}