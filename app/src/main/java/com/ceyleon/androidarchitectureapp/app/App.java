/**
 * Created by Chatura Dilan Perera on 1/3/2017.
 */
package com.ceyleon.androidarchitectureapp.app;

import android.app.Application;

import com.ceyleon.androidarchitectureapp.comp.di.AppModule;
import com.ceyleon.androidarchitectureapp.comp.di.DaggerNetComponent;
import com.ceyleon.androidarchitectureapp.comp.di.NetComponent;
import com.ceyleon.androidarchitectureapp.comp.di.NetModule;

import timber.log.Timber;

public class App extends Application {

    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://private-d1e873-colorsapi.apiary-mock.com/"))
                .build();

    }

    public NetComponent getNetComponent() {
        return netComponent;
    }


}
