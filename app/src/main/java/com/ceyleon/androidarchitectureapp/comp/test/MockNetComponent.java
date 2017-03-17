package com.ceyleon.androidarchitectureapp.comp.test;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Chatura Dilan Perera on 5/3/2017.
 */

@Singleton
@Component(modules = {MockNetModule.class})
public interface MockNetComponent {

    Retrofit retrofit();
}
