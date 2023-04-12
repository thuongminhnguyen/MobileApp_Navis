package com.example.mbbapp.API_Login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
    TextView sign_up;
    boolean passwordVisible;
    Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://203.171.20.94:8903")
            .addConverterFactory(GsonConverterFactory.create());
    Retrofit retrofit = builder.build();
    AccessTokenClient accessTokenClient = retrofit.create(AccessTokenClient.class);
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        passWord = (EditText) findViewById(R.id.login_password);
        userName = (EditText) findViewById(R.id.login_username);
        button_Login = (Button) findViewById(R.id.login_button);
        sign_up = findViewById(R.id.signupRedirectText);
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

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, Sign_up_activity.class));
            }
        });

        passWord.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right = 2;
                if(event.getAction() == MotionEvent.ACTION_UP){
                    if(event.getRawX()>= passWord.getRight() - passWord.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = passWord.getSelectionEnd();
                        if(passwordVisible){
                            passWord.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24,0);

                            passWord.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible= false;
                        }else{
                            passWord.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24,0);

                            passWord.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible= true;
                        }
                        passWord.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });
    }
}