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

import com.google.android.exoplayer2.util.Util;

import app.gymclubapp.R;
import app.gymclubapp.fragments.bottomNavigationFragments.NewsFragment;
import app.gymclubapp.fragments.bottomNavigationFragments.TrainingClassesFragment;
import app.gymclubapp.videoPlayer.VideoPlayerManager;

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
                    case R.id.navigation_video_player:
                        fragment = new VideoPlayerFragment();
                        Log.d("TAG", "VIDEO PLAYER");
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

    @Override
    protected void onStart() {
        super.onStart();
        if (Util.SDK_INT > 23) {
            //videoPlayerManager.initializePlayer();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Util.SDK_INT > 23) {
            //videoPlayerManager.initializePlayer();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (Util.SDK_INT <= 23) {
            //videoPlayerManager.releasePlayer();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (Util.SDK_INT > 23) {
            //videoPlayerManager.releasePlayer();
        }
    }
}
