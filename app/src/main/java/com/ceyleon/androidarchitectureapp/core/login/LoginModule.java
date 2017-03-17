/**
 * Created by Chatura Dilan Perera on 3/3/2017.
 */
package com.ceyleon.androidarchitectureapp.core.login;


import com.ceyleon.androidarchitectureapp.comp.di.PerActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    private final LoginContract.View view;

    public LoginModule(LoginContract.View view) {
        this.view = view;
    }

    @Provides
    @PerActivityScope
    public LoginContract.View provideView() {
        return view;
    }

}
