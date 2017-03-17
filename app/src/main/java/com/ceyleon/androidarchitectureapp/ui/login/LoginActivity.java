package com.ceyleon.androidarchitectureapp.ui.login;

import android.os.Bundle;

import com.ceyleon.androidarchitectureapp.R;
import com.ceyleon.androidarchitectureapp.app.App;
import com.ceyleon.androidarchitectureapp.app.Utils;
import com.ceyleon.androidarchitectureapp.comp.base.BaseActivity;
import com.ceyleon.androidarchitectureapp.core.login.DaggerLoginComponent;
import com.ceyleon.androidarchitectureapp.core.login.LoginModule;
import com.ceyleon.androidarchitectureapp.core.login.LoginPresenter;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity {

    @Inject
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if(loginFragment == null){
            loginFragment = LoginFragment.newInstance();
            Utils.ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), loginFragment, R.id.contentFrame);
        }

        DaggerLoginComponent.builder()
                .netComponent(((App) getApplicationContext()).getNetComponent())
                .loginModule(new LoginModule(loginFragment)).build().inject(this);

        loginFragment.setPresenter(loginPresenter);

    }


    @Override
    protected void onResume() {
        super.onResume();
    }
}
