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

import app.gymclubapp.R;
import app.gymclubapp.activities.LoginActivity;

public class RegisterFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_register, null);
        Button registerButton = view.findViewById(R.id.register_button);
        Button returnLoginButton = view.findViewById(R.id.return_login_button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //login
                Log.d("LOGTAG", "register");
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
}