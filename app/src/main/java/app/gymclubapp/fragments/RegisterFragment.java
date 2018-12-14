package app.gymclubapp.fragments;

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

public class RegisterFragment extends Fragment {

    private EditText registerUsername;
    private EditText registerPassword;
    private EditText registerPasswordCheck;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_register, null);
        Button registerButton = view.findViewById(R.id.register_button);
        Button returnLoginButton = view.findViewById(R.id.return_login_button);

        setupRegisterButtons(view);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("LOGTAG", "register");
                //login
            }
        });

        returnLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new LoginFragment()).commit();
            }
        });

        return view;
    }

    public void setupRegisterButtons(View view) {
        registerUsername = view.findViewById(R.id.register_username);
        registerPassword = view.findViewById(R.id.register_password);
        registerPasswordCheck = view.findViewById(R.id.register_password_check);

        registerUsername.setText("user");
        registerPassword.setText("pass1");
        registerPasswordCheck.setText("pass1");
    }
}