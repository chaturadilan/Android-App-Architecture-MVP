package com.ceyleon.androidarchitectureapp.comp.test;

import com.ceyleon.androidarchitectureapp.api.LoginAPI;
import com.ceyleon.androidarchitectureapp.models.LoginResponse;

import retrofit2.http.Query;
import retrofit2.mock.BehaviorDelegate;
import rx.Observable;

/**
 * Created by Chatura Dilan Perera on 17/3/2017.
 */

public class MockService implements LoginAPI {

    private final BehaviorDelegate<LoginAPI> delegate;

    public MockService(BehaviorDelegate<LoginAPI> delegate) {
        this.delegate = delegate;
    }


    @Override
    public Observable<LoginResponse> login(@Query("username") String username, @Query("password") String password) {
        return delegate.returningResponse("test").login("dilan", "chatura");
    }
}
