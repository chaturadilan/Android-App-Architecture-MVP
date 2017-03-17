package com.ceyleon.androidarchitectureapp.api;

import com.ceyleon.androidarchitectureapp.models.LoginResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Chatura Dilan Perera on 5/3/2017.
 */

public interface LoginAPI {

    @GET("login")
    Observable<LoginResponse> login(@Query("username") String username, @Query("password") String password);
}
