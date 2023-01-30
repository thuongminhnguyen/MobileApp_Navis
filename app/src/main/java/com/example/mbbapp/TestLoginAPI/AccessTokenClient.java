package com.example.mbbapp.TestLoginAPI;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AccessTokenClient {

    @POST("/api/users/login")
    Call<AccessToken> Login(@Body LoginModel loginModel);


}
