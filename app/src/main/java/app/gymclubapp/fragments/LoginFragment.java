package app.gymclubapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
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
        void onRegisterButtonClicked();
    }

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button createAccountButton;
    private LoginListener loginListener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("LOGTAG", "On create");
        View view = inflater.inflate(R.layout.activity_login, null);

        setLoginButtonClickListener(view);

        return view;
    }

    private void setLoginButtonClickListener(View view) {
        loginButton = view.findViewById(R.id.login_button);
        createAccountButton = view.findViewById(R.id.create_account_button);
        usernameEditText = view.findViewById(R.id.login_username);
        usernameEditText.setText("user1");
        passwordEditText = view.findViewById(R.id.login_password);
        passwordEditText.setText("pass1");


        if (loginButton != null) {
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (loginListener != null)
                        loginListener.onLoginButtonClicked();
                    else
                        Log.d("LOGTAG", "Login listener is null because the fragment as reset");
                }
            });
        } else {
            Log.d("LOGTAG", "LoginButton is null");
        }

        if (createAccountButton != null) {
            createAccountButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RegisterFragment registerFragment = new RegisterFragment();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("listener", (Parcelable) loginListener);
                    registerFragment.setArguments(bundle);

                    //GET
                    //Listeneer litener = (Listener) getIntent().getSerializableExtra("listener");
                    LoginActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new RegisterFragment()).commit();
                }
            });
        } else {
            Log.d("LOGTAG", "CreateAccountButton is null");
        }
    }

    public void setLoginListener(LoginListener loginListener) {
        this.loginListener = loginListener;
    }

    public EditText getPasswordEditText() {
        return passwordEditText;
    }

    public EditText getUsernameEditText() {
        return usernameEditText;
    }
}