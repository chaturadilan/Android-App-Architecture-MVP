package com.ceyleon.androidarchitectureapp.comp.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Chatura Dilan Perera on 4/3/2017.
 */

@Module
public class AppModule {

    Application application;

    public AppModule(Application mApplication) {
        this.application = mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }
}