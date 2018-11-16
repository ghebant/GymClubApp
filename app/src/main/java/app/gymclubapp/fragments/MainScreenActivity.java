package app.gymclubapp.fragments;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import app.gymclubapp.R;
import app.gymclubapp.activities.LoginActivity;
import app.gymclubapp.fragments.bottomNavigationFragments.NewsFragment;
import app.gymclubapp.fragments.bottomNavigationFragments.TrainingClassesFragment;

public class MainScreenActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen_layout);

        fragmentManager = getSupportFragmentManager();

        navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()) {
                    case R.id.navigation_news:
                        fragment = new NewsFragment();
                        Log.d("LOGTAG", "NEWS");
                        return loadFragment(fragment);
                    case R.id.navigation_training_classes:
                        fragment = new TrainingClassesFragment();
                        Log.d("TAG", "TRAINING");
                        return loadFragment(fragment);
                }
                return false;
            }
        };

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.main_screen_navigation);
        navigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        loadFragment(new NewsFragment());
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
}
