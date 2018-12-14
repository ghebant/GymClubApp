package app.gymclubapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.gymclubapp.R;
import app.gymclubapp.videoPlayer.VideoPlayerManager;

public class VideoPlayerFragment extends Fragment {

    private VideoPlayerManager videoPlayerManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_player_fragment, null);
        videoPlayerManager = new VideoPlayerManager(getContext());
        videoPlayerManager.initializePlayer(view);

        return view;
    }

}
