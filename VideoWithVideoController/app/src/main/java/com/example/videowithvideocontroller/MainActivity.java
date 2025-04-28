package com.example.videowithvideocontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;


public class MainActivity extends AppCompatActivity {

// Your Video URL
    String  path = "https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       VideoView myVV = findViewById(R.id.myVV);

       Uri uri = Uri.parse(path);
       myVV.setVideoURI(uri);
//     for local video files path
//     myVV.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.fuckfuck);

       MediaController mediaController = new MediaController(this);
       mediaController.setAnchorView(myVV);
        myVV.setMediaController(mediaController);
       myVV.start();
   }

}