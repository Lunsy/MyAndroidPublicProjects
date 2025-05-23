package com.kayrat.mvvmretrofitdemo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kayrat.mvvmretrofitdemo.R;
import com.kayrat.mvvmretrofitdemo.model.MovieApiResponse;
import com.kayrat.mvvmretrofitdemo.model.Result;
import com.kayrat.mvvmretrofitdemo.service.MovieApiService;
import com.kayrat.mvvmretrofitdemo.service.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;

public class MovieDetailsActivity extends AppCompatActivity {

    private Result result;
    private ImageView posterImageView;
    private String posterPath;
    private TextView titleMovieDetailsTextView;
    private TextView releaseDateTextView;
    private TextView voteCountTextView;
    private TextView overviewTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        posterImageView = findViewById(R.id.imageView);
        titleMovieDetailsTextView = findViewById(R.id.titleMovieDetailsTextView);
        releaseDateTextView = findViewById(R.id.releaseDateTextView);
        voteCountTextView = findViewById(R.id.voteCountTextView);
        overviewTextView = findViewById(R.id.overviewTextView);



        Intent intent = getIntent();



        if(intent != null && intent.hasExtra("movieData")) {

            result = intent.getParcelableExtra("movieData");

//            Toast.makeText(this, result.getOriginalTitle(),
//                    Toast.LENGTH_LONG).show();

            posterPath = result.getPosterPath();
            String imagePath = "https://image.tmdb.org/t/p/w500/" + posterPath;

            Glide.with(this)
                    .load(imagePath)
                    .placeholder(R.drawable.progress_circle)
                    .into(posterImageView);




        titleMovieDetailsTextView.setText(result.getOriginalTitle());
            releaseDateTextView.setText(result.getReleaseDate());

            voteCountTextView.setText(Integer.toString(result.getVoteCount()));
            overviewTextView.setText(result.getOverview());


        }

    }
}