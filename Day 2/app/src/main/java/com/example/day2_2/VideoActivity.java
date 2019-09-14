package com.example.day2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        videoView = findViewById(R.id.videoView);
        Uri uri=Uri.parse("https://as1.cdn.asset.aparat.com/aparat-video/4b2eff15b37dc45e10e5d88c4c83bca716701018-144p__15560.mp4");
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
    }
}
