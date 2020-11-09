package com.example.youtubeplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailView;

public class MainActivity extends YouTubeBaseActivity {

    private static final String TAG = "MainActivity";

    private YouTubePlayerView youTubePlayerView;
    private Button buttonPlay;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

        youTubePlayerView = findViewById(R.id.youtubePlayer);
        buttonPlay = findViewById(R.id.playButton);



        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "onInitializationSuccess: Here you go!");
                youTubePlayer.loadVideo("UkTSU0zaeuk");
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onInitializationFailure: This video couldn't find!");
            }
        };
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: YouTube Player Is Loading!");
                youTubePlayerView.initialize(YouTubeConfig.getApiKey(), onInitializedListener);
            }
        });
     }
}