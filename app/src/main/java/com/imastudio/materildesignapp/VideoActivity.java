package com.imastudio.materildesignapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoActivity extends AppCompatActivity {

    @BindView(R.id.myVideo)
    VideoView myVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
        MediaController controller = new MediaController(this);
        Uri uri = Uri.parse("android.resource://"+
                getPackageName()+"/"+R.raw.video);
        //set alamat file video
        myVideo.setVideoURI(uri);
        //controller video ex play,pause,stop
        myVideo.setMediaController(controller);
        myVideo.start();
    }
}
