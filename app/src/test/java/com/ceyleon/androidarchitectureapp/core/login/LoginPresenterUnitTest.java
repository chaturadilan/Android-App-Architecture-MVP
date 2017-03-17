package com.ceyleon.androidarchitectureapp.core.login;

import com.ceyleon.androidarchitectureapp.api.LoginAPI;
import com.ceyleon.androidarchitectureapp.comp.schedulers.ImmediateSchedulerProvider;
import com.ceyleon.androidarchitectureapp.comp.test.DaggerMockNetComponent;
import com.ceyleon.androidarchitectureapp.comp.test.MockNetModule;
import com.ceyleon.androidarchitectureapp.comp.test.MockService;
import com.ceyleon.androidarchitectureapp.models.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import retrofit2.Retrofit;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by Chatura Dilan Perera on 15/3/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterUnitTest {


    Retrofit retrofit;

    LoginPresenter colorPresenter;

    @Mock
    LoginContract.View view;

    MockService mockService;

    private final NetworkBehavior behavior = NetworkBehavior.create();

    @Before
    public void setUp() throws Exception {

        retrofit = DaggerMockNetComponent.builder().mockNetModule(new MockNetModule()).build().retrofit();

        MockRetrofit mockRetrofit = new MockRetrofit.Builder(retrofit)
                .networkBehavior(behavior).build();

        BehaviorDelegate<LoginAPI> delegate = mockRetrofit.create(LoginAPI.class);

        mockService = new MockService(delegate);

        colorPresenter = new LoginPresenter(view, mockRetrofit.retrofit(), new ImmediateSchedulerProvider());
    }

    @Test
    public void login() throws Exception {
        colorPresenter.login("dilan", "dilan123");
        verify(view).onLoginSuccess(any(User.class));
    }

}