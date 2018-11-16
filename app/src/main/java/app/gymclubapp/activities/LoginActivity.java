package app.gymclubapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import app.gymclubapp.R;
import app.gymclubapp.fragments.LoginFragment;
import app.gymclubapp.fragments.MainScreenActivity;
import app.gymclubapp.fragments.RegisterFragment;
import app.gymclubapp.services.HttpClient;
import app.gymclubapp.services.HttpService;
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

        loadFragment(loginFragment);
        loginFragment.setLoginButtonClickListener(new LoginFragment.LoginListener() {
            @Override
            public void onLoginButtonClicked() {
                tryLogin();
            }
        });
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

            Call<List<User>> call = httpService.getUsers();
            call.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                    Log.d("LOGTAG", "Response ok");
                    for (User user : response.body()) {
                        if (userStr == user.getUsername() && pwdStr == user.getPassword()) {
                            //login
                            Log.d("LOGTAG", "login");
                            Intent intent = new Intent(getApplicationContext(), MainScreenActivity.class);
                            startActivity(intent);
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {
                    Log.d("LOGTAG", "Response fail");
                }
            });
        }
    }
}
