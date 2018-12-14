package app.gymclubapp.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.util.Util;

import app.gymclubapp.R;
import app.gymclubapp.videoPlayer.VideoPlayerManager;

public class VideoPlayerActivity extends AppCompatActivity {

    private VideoPlayerManager videoPlayerManager = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_player_fragment);

        PlayerView playerView = findViewById(R.id.player_view);
        videoPlayerManager = new VideoPlayerManager(this, playerView);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("LOGTAG", "onStart");
        if (Util.SDK_INT > 23) {
            if (videoPlayerManager != null)
                videoPlayerManager.initializePlayer();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("LOGTAG", "onResume");
        if (Util.SDK_INT > 23) {
            if (videoPlayerManager != null)
                videoPlayerManager.initializePlayer();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("LOGTAG", "onPause");
        if (Util.SDK_INT > 23) {
            if (videoPlayerManager != null)
                videoPlayerManager.releasePlayer();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("LOGTAG", "onStop");
        if (Util.SDK_INT > 23) {
            if (videoPlayerManager != null) {
                videoPlayerManager.releasePlayer();
                Log.d("LOGTAG", "Player stopped");
            }
        }
    }
}
