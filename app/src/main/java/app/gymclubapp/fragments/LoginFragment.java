package app.gymclubapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import app.gymclubapp.R;
import app.gymclubapp.activities.LoginActivity;

public class LoginFragment extends Fragment {

    // Listener
    public interface LoginListener {
        void onLoginButtonClicked();
    }

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button createAccountButton;
    //private LoginListener loginListener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_login, null);

        setupItems(view);

        return view;
    }

    public void setupItems(View view) {
        loginButton = view.findViewById(R.id.login_button);
        createAccountButton = view.findViewById(R.id.create_account_button);
        usernameEditText = view.findViewById(R.id.login_username);
        passwordEditText = view.findViewById(R.id.login_password);
    }

    public void setLoginButtonClickListener(final LoginListener loginListener) {
        if (loginButton != null) {
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loginListener.onLoginButtonClicked();
                }
            });
        } else {
            Log.d("LOGTAG", "LoginButton is null");
        }

        if (createAccountButton != null) {
            createAccountButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LoginActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new RegisterFragment()).commit();
                }
            });
        } else {
            Log.d("LOGTAG", "CreateAccountButton is null");
        }
    }

    public EditText getPasswordEditText() {
        return passwordEditText;
    }

    public EditText getUsernameEditText() {
        return usernameEditText;
    }
}