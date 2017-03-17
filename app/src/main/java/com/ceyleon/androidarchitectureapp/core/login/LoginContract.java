package com.ceyleon.androidarchitectureapp.core.login;

import com.ceyleon.androidarchitectureapp.comp.base.BasePresenter;
import com.ceyleon.androidarchitectureapp.comp.base.BaseView;
import com.ceyleon.androidarchitectureapp.models.User;

/**
 * Created by Chatura Dilan Perera on 1/3/2017.
 */

public interface LoginContract {

    public interface View extends BaseView<Presenter> {

        public void onLoginSuccess(User user);

        public void onLoginFailure(Throwable t);
    }

    public interface Presenter extends BasePresenter {
        public void login(String username, String password);
    }

}
