package com.example.myapplication.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.util.Patterns;

import com.example.myapplication.data.LoginRepository;
import com.example.myapplication.data.Result;
import com.example.myapplication.data.model.LoggedInUser;
import com.example.myapplication.R;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private LoginRepository loginRepository;

    LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public void login(String password) {
        // can be launched in a separate asynchronous job
        Result<LoggedInUser> result = loginRepository.login(password);

        if (result instanceof Result.Success) {
            LoggedInUser data = ((Result.Success<LoggedInUser>) result).getData();
            loginResult.setValue(new LoginResult(new LoggedInUserView(data.getDisplayName())));
        } else {
            loginFormState.setValue(new LoginFormState(null,R.string.invalid_id));
        }
    }

    public void loginDataChanged(String password) {
         if (!isPasswordValid(password)) {
            loginFormState.setValue(new LoginFormState(null, R.string.invalid_password));
        } else  {
            loginFormState.setValue(new LoginFormState(true));
             }


        }






    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() ==10;
    }
}