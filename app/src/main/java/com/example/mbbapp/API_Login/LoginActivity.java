package com.example.mbbapp.API_Login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.mbbapp.GetActivity;
import com.example.mbbapp.NavigationActivity;
import com.example.mbbapp.R;
import com.example.mbbapp.Test.TestActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    public static String token;

    EditText userName;
    EditText passWord;
    Button button_Login;
    Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://203.171.20.94:8903")
            .addConverterFactory(GsonConverterFactory.create());
    Retrofit retrofit = builder.build();
    AccessTokenClient accessTokenClient = retrofit.create(AccessTokenClient.class);
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_login);
        passWord = (EditText) findViewById(R.id.edt_pass);
        userName = (EditText) findViewById(R.id.edt_user);
        button_Login = (Button) findViewById(R.id.btn_login);
        button_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginModel loginModel = new LoginModel();
                loginModel.setUsername(userName.getText().toString());
                loginModel.setPassword(passWord.getText().toString());
                Call<AccessTokenModel> call = accessTokenClient.Login(loginModel);
                call.enqueue(new Callback<AccessTokenModel>() {
                    @Override
                    public void onResponse(Call<AccessTokenModel> call, Response<AccessTokenModel> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Login is success", Toast.LENGTH_SHORT).show();
                            token = "x-access-token=" + response.body().getData().getAccessToken();
                            startActivity(new Intent(LoginActivity.this, NavigationActivity.class));
                        }else {
                            Toast.makeText(LoginActivity.this, "Login is not correct", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<AccessTokenModel> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}