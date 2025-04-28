package com.example.audiofilesplay;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    MediaPlayer audioplayer;
    Button button;
    SeekBar volumeSeekBar;
    AudioManager audioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        volumeSeekBar = findViewById(R.id.volumeSeekBar);
        volumeSeekBar.setMax(maxVolume);
        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progr, boolean frmUsr) {
                Log.d("Progress changed: ", "" + progr);
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progr, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        button = findViewById(R.id.playBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(audioplayer.isPlaying()){
                    Pause();
                } else {
                    Play();
                }
            }
        });

        audioplayer = MediaPlayer.create(getApplicationContext(), R.raw.fuckyououtput);

    }

    public void Play() {
        audioplayer.start();
        button.setText("Pause");
    }

    public void Pause() {
        audioplayer.pause();
        button.setText("Play");
    }
}