/**
 * Created by Chatura Dilan Perera on 1/3/2017.
 */
package com.ceyleon.androidarchitectureapp.core.login;

import com.ceyleon.androidarchitectureapp.api.LoginAPI;
import com.ceyleon.androidarchitectureapp.app.Utils;
import com.ceyleon.androidarchitectureapp.comp.schedulers.BaseSchedulerProvider;
import com.ceyleon.androidarchitectureapp.models.ErrorResponse;
import com.ceyleon.androidarchitectureapp.models.LoginResponse;

import java.io.IOException;
import java.lang.annotation.Annotation;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.HttpException;
import retrofit2.Retrofit;
import rx.Observer;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    Retrofit retrofit;
    BaseSchedulerProvider schedulerProvider;

    @Inject
    public LoginPresenter(LoginContract.View view, Retrofit retrofit, BaseSchedulerProvider schedulerProvider) {
        this.view = view;
        this.schedulerProvider = schedulerProvider;
        this.retrofit = retrofit;
    }

    @Override
    public void login(final String username, String password) {

        retrofit.create(LoginAPI.class).login(username, password)
                .subscribeOn(schedulerProvider.computation())
                .observeOn(schedulerProvider.ui())
                .subscribe(new Observer<LoginResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable t) {
                        if (t instanceof HttpException) {
                            Converter<ResponseBody, ErrorResponse> errorConverter = retrofit.responseBodyConverter(ErrorResponse.class, new Annotation[0]);
                            try {
                                ErrorResponse errorResponse = errorConverter.convert(((HttpException) t).response().errorBody());
                                view.onLoginFailure(errorResponse.getError());
                            } catch (IOException e) {
                                view.onLoginFailure(Utils.ErrorUtil.returnUnknownError());
                            }
                        }
                    }

                    @Override
                    public void onNext(LoginResponse loginResponse) {
                        view.onLoginSuccess(loginResponse.getUser());
                    }
                });
    }

    @Override
    public void start() {

    }

}
