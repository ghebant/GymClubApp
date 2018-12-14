package app.gymclubapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import app.gymclubapp.R;
import app.gymclubapp.fragments.LoginFragment;
import app.gymclubapp.services.HttpClient;
import app.gymclubapp.services.HttpService;
import app.gymclubapp.services.models.RetroResponse;
import app.gymclubapp.services.models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private HttpService httpService;
    private LoginFragment loginFragment;
    public static FragmentManager fragmentManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container_layout);

        fragmentManager = getSupportFragmentManager();
        loginFragment = new LoginFragment();
        retrofit = HttpClient.getClient();
        httpService = retrofit.create(HttpService.class);

        loginFragment.setLoginListener(new LoginFragment.LoginListener() {
            @Override
            public void onLoginButtonClicked() {
                tryLogin();
            }

            @Override
            public void onRegisterButtonClicked() {

            }
        });
        //CHECK SI CA CALL ONCREATE QUAND ON CHANGE DE FRAGMENT
        //CHECK SI CA CALL ONCREATE QUAND ON CHANGE DE FRAGMENT
        //CHECK SI CA CALL ONCREATE QUAND ON CHANGE DE FRAGMENT
        //CHECK SI CA CALL ONCREATE QUAND ON CHANGE DE FRAGMENT
        loadFragment(loginFragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
            return true;
        }
        return false;
    }

    private void tryLogin() {
        if (loginFragment.getUsernameEditText() != null && loginFragment.getPasswordEditText() != null) {
            final String userStr = loginFragment.getUsernameEditText().getText().toString();
            final String pwdStr = loginFragment.getPasswordEditText().getText().toString();

            Call<RetroResponse> call = httpService.login2(new User(userStr, pwdStr));
            call.enqueue(new Callback<RetroResponse>() {
                @Override
                public void onResponse(Call<RetroResponse> call, Response<RetroResponse> response) {
                    Log.d("LOGTAG", response.body().getSuccess());
                    if (response.body().getSuccess().equals("true")) {
                        Intent intent = new Intent(getApplicationContext(), MainScreenActivity.class);
                        startActivity(intent);
                    } else {
                        Log.d("LOGTAG", "Wrong password");
                        EditText edUsername = findViewById(R.id.login_username);
                        EditText edPassword = findViewById(R.id.login_password);
                        edUsername.setError("Wrong combination");
                        edPassword.setError("");
                    }
                }

                @Override
                public void onFailure(Call<RetroResponse> call, Throwable t) {
                    Log.d("LOGTAG", "Fail: " + t);
                }
            });
        }
    }
}
