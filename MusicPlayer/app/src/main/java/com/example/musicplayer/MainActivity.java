package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    ImageView playPauseIco;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playPauseIco = findViewById(R.id.playImageView);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.fuckyououtput);

        seekBar = findViewById(R.id.sonLenSeekBar);
        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int prog, boolean frmUsr) {
                if(frmUsr){
                    mediaPlayer.seekTo(prog);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
            }
        }, 0, 1000);

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                // Do something when media player end playing
                playPauseIco.setImageResource(R.drawable.baseline_play_arrow_24);
            }
        });
    }

    public void prevTrack(View view) {
        seekBar.setProgress(0);
        mediaPlayer.seekTo(0);
        mediaPlayer.pause();
        playPauseIco.setImageResource(R.drawable.baseline_pause_24);
    }

    public void stopTrack(View view) {
        if (mediaPlayer.isPlaying()){
            seekBar.setProgress(0);
            mediaPlayer.seekTo(0);
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.fuckyououtput);
            playPauseIco.setImageResource(R.drawable.baseline_play_arrow_24);
        } else {
            seekBar.setProgress(0);
            mediaPlayer.seekTo(0);
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.fuckyououtput);
            playPauseIco.setImageResource(R.drawable.baseline_play_arrow_24);
        }
    }

    public void playTrack(View view) {

        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            playPauseIco.setImageResource(R.drawable.baseline_play_arrow_24);
        } else {
            mediaPlayer.start();
            playPauseIco.setImageResource(R.drawable.baseline_pause_24);
            }

        }

    public void nextTrack(View view) {
        seekBar.setProgress(mediaPlayer.getDuration());
        mediaPlayer.seekTo(mediaPlayer.getDuration());
        mediaPlayer.pause();
        playPauseIco.setImageResource(R.drawable.baseline_pause_24);
    }

}