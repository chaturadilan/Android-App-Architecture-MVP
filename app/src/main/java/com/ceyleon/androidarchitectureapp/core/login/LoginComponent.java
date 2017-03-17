/**
 * Created by Chatura Dilan Perera on 3/3/2017.
 */
package com.ceyleon.androidarchitectureapp.core.login;

import com.ceyleon.androidarchitectureapp.comp.di.NetComponent;
import com.ceyleon.androidarchitectureapp.comp.di.PerActivityScope;
import com.ceyleon.androidarchitectureapp.ui.login.LoginActivity;

import dagger.Component;

@PerActivityScope
@Component(dependencies = {NetComponent.class}, modules = LoginModule.class)
public interface LoginComponent {

    void inject(LoginActivity activity);

}