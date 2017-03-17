package com.ceyleon.androidarchitectureapp.comp.di;

import com.ceyleon.androidarchitectureapp.comp.schedulers.BaseSchedulerProvider;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Chatura Dilan Perera on 4/3/2017.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {

    Retrofit retrofit();

    BaseSchedulerProvider schedulerProvider();
}
