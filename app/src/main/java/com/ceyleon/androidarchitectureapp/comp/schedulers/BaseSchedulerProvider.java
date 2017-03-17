package com.ceyleon.androidarchitectureapp.comp.schedulers;

import android.support.annotation.NonNull;

import rx.Scheduler;

/**
 * Created by Chatura Dilan Perera on 4/3/2017.
 */

public interface BaseSchedulerProvider {

    @NonNull
    Scheduler computation();

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();
}
