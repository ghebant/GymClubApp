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

public class LoginFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflatedView = inflater.inflate(R.layout.activity_login, container, false);

        if (inflatedView != null) {
            Button loginButton = inflatedView.findViewById(R.id.login_button);

            if (loginButton != null) {
                loginButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("LOGTAG", "LOGIN");
                    }
                });
            }
        }

        return inflatedView;
        //return inflater.inflate(R.layout.activity_login, null);
    }
}