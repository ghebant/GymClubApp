package app.gymclubapp.videoPlayer;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.View;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;

import app.gymclubapp.R;

public class VideoPlayerManager {

    private SimpleExoPlayer player;
    private PlayerView playerView;
    //To start with the first item in the Timeline
    private int currentWindow = 0;
    //To start from the beginning
    private long playbackPosition = 0;
    private boolean playWhenReady = true;

    private Context context;

    public VideoPlayerManager(Context ctx) {
        context = ctx;
    }

    public void initializePlayer(View view) {
        playerView = view.findViewById(R.id.player_view);

        player = ExoPlayerFactory.newSimpleInstance(
                new DefaultRenderersFactory(context),
                new DefaultTrackSelector(),
                new DefaultLoadControl());
        if (player != null) {

            playerView.setPlayer(player);

            player.setPlayWhenReady(playWhenReady);
            player.seekTo(currentWindow, playbackPosition);

            Uri uri = Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
            MediaSource mediaSource = buildMediaSource(uri);
            player.prepare(mediaSource, true, false);
        } else {
            Log.d("LOGTAG", "Player is null");
        }

        /*playerView = context.getApplicationContext()
        if (player == null) {
            player = ExoPlayerFactory.newSimpleInstance(
                    new DefaultRenderersFactory(context),
                    new DefaultTrackSelector(),
                    new DefaultLoadControl());

            if (playerView != null)
                playerView.setPlayer(player);
            player.setPlayWhenReady(playWhenReady);
            player.seekTo(currentWindow, playbackPosition);
        }
        MediaSource mediaSource = buildMediaSource(Uri.parse(getString(R.string.media_url_mp4)));
        player.prepare(mediaSource, true, false);*/
    }

    public MediaSource buildMediaSource(Uri uri) {

        return new ExtractorMediaSource.Factory(
                new DefaultHttpDataSourceFactory("GymClubApp")).
                createMediaSource(uri);

        /*String userAgent = "exoplayer-codelab";

        if (uri.getLastPathSegment().contains("mp3") || uri.getLastPathSegment().contains("mp4")) {
            return ExtractorMediaSource.Factory(DefaultHttpDataSourceFactory(userAgent))
                    .createMediaSource(uri);
        } else if (uri.getLastPathSegment().contains("m3u8")) {
            return HlsMediaSource.Factory(DefaultHttpDataSourceFactory(userAgent))
                    .createMediaSource(uri);
        } else {
            String dashChunkSourceFactory = DefaultDashChunkSource.Factory(
                    DefaultHttpDataSourceFactory("ua", BANDWIDTH_METER));
            int manifestDataSourceFactory = DefaultHttpDataSourceFactory(userAgent);
            return DashMediaSource.Factory(dashChunkSourceFactory, manifestDataSourceFactory).createMediaSource(uri);
        }*/
    }

    public void releasePlayer() {
        if (player != null) {
            playbackPosition = player.getCurrentPosition();
            currentWindow = player.getCurrentWindowIndex();
            playWhenReady = player.getPlayWhenReady();
            player.release();
            player = null;
        }
    }
}
