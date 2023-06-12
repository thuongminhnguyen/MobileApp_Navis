package com.example.mbbapp.Login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AccessTokenClient {
    @POST("/api/users/login")
    Call<AccessTokenModel> Login(@Body LoginModel loginModel);

}
