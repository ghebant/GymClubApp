package app.gymclubapp.fragments;

import android.content.Intent;
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

public class LoginFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_login, null);
        Button loginButton = view.findViewById(R.id.login_button);
        Button createAccountButton = view.findViewById(R.id.create_account_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //login
                Log.d("LOGTAG", "login");
                Intent intent = new Intent(getActivity(), MainScreenActivity.class);
                startActivity(intent);
            }
        });

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new RegisterFragment()).commit();
            }
        });

        return view;
    }
}