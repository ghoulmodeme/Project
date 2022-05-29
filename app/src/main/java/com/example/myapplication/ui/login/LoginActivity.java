package com.example.myapplication.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.ProfileActivity;
import com.example.myapplication.R;
import com.example.myapplication.data.ServiceOfServer;
import com.example.myapplication.data.model.BodyOfId;
import com.example.myapplication.data.model.ResponseExample;
import com.example.myapplication.data.model.Service1;
import com.example.myapplication.databinding.ActivityLoginBinding;

import java.math.BigInteger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {
    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getBooleanExtra("result", false)) {
                Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(context, "Server error", Toast.LENGTH_SHORT).show();
            }
        }
    };

    private LoginViewModel loginViewModel;
    private ActivityLoginBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        final EditText Id = findViewById(R.id.id);

        final Button loginButton = binding.login;
        final ProgressBar loadingProgressBar = binding.loading;

        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                loginButton.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getPasswordError() != null) {
                    Id.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });

        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);
                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null) {
                    updateUiWithUser(loginResult.getSuccess());
                }
                setResult(Activity.RESULT_OK);

                //Complete and destroy login activity once successful

            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(Id.getText().toString());
            }
        };
        Id.addTextChangedListener(afterTextChangedListener);
        Id.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(Id.getText().toString());
                }
                return false;
            }
        });
        loginButton.setOnClickListener(view -> {
            Retrofit r = ServiceOfServer.getInstance();
            Service1 service=r.create(Service1.class);
            BodyOfId body =  new BodyOfId();
            BigInteger pas = new BigInteger(Id.getText().toString());
            body.setId(pas);
            Call<ResponseExample> call = service.body(body);
            call.enqueue(new Callback<ResponseExample>() {
                @Override
                public void onResponse(Call<ResponseExample> call, Response<ResponseExample> response) {
                    if (response.code() == 200) {
                        Toast.makeText(LoginActivity.this, "Welcome in dota skills", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(LoginActivity.this, ProfileActivity.class);
                        i.putExtra("ID", pas.toString());
                        startActivity(i);
                    }
                    ResponseExample responseExample = response.body();
                    System.out.println(response.raw().toString());
                }

                @Override
                public void onFailure(Call<ResponseExample> call, Throwable t) {
                    t.printStackTrace();
                    Toast.makeText(LoginActivity.this, "see log,", Toast.LENGTH_SHORT).show();
                }
            });
        });

        }


    private void updateUiWithUser(LoggedInUserView model) {
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }
}