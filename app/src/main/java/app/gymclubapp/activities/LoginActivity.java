package app.gymclubapp.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import app.gymclubapp.R;
import app.gymclubapp.fragments.LoginFragment;
import app.gymclubapp.fragments.RegisterFragment;

public class LoginActivity extends AppCompatActivity {

    private EditText loginUsername;
    private EditText passwordUsername;
    private Button loginButton;
    private Button registerButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new LoginFragment());
        setupButtons();
    }

    private void setupButtons() {

        loginButton = findViewById(R.id.login_button);
        registerButton = findViewById(R.id.register_button);

        if (loginButton != null) {
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //login
                    Log.d("LOGTAG", "Clicked on login");
                }
            });
        } else
            Log.d("LOGTAG", "login btn is null");

        if (registerButton != null) {
            registerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("LOGTAG", "Clicked on register");
                    Fragment fragment = new RegisterFragment();
                    loadFragment(fragment);
                }
            });
        }
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
