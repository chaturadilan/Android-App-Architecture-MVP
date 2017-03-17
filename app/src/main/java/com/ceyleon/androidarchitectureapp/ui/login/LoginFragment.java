package com.ceyleon.androidarchitectureapp.ui.login;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.ceyleon.androidarchitectureapp.R;
import com.ceyleon.androidarchitectureapp.core.login.LoginContract;
import com.ceyleon.androidarchitectureapp.models.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginContract.View {

    @BindView(R.id.editTextUsername)
    EditText editTextUsername;

    @BindView(R.id.editTextPassword)
    EditText editTextPassword;

    LoginContract.Presenter presenter;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.buttonLogin)
    public void onButtonLoginClick(View view) {
        Timber.d("Login button is clicked");
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();
        presenter.login(username, password);
    }


    @Override
    public void onLoginSuccess(User user) {
        Toast.makeText(getActivity(), "user " + user.getName() + " logged in successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailure(Throwable t) {
        Toast.makeText(getActivity(), "Login Failure", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
