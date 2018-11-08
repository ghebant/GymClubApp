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

public class RegisterFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.activity_login, container, false);

        if (inflatedView != null) {
            Button registerButton = inflatedView.findViewById(R.id.register_button);

            if (registerButton != null) {
                registerButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("LOGTAG", "REGISTER");
                    }
                });
            }
        }

        return inflatedView;
        //return inflater.inflate(R.layout.activity_register, null);
    }
}