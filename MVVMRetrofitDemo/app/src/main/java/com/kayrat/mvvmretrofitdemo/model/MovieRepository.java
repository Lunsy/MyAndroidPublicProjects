package com.kayrat.mvvmretrofitdemo.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.kayrat.mvvmretrofitdemo.R;
import com.kayrat.mvvmretrofitdemo.service.MovieApiService;
import com.kayrat.mvvmretrofitdemo.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private ArrayList<Result> results = new ArrayList<>();
    private MutableLiveData<List<Result>> mutableLiveData =
            new MutableLiveData<>();
    private Application application;

    public MovieRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Result>> getMutableLiveData() {



        MovieApiService movieApiService = RetrofitInstance.getService();

        Call<MovieApiResponse> call = movieApiService
                .getPopularMovies(application.getString(R.string.api_key),
                        application.getString(R.string.language));

        call.enqueue(new Callback<MovieApiResponse>() {
            @Override
            public void onResponse(Call<MovieApiResponse> call,
                                   Response<MovieApiResponse> response) {

                MovieApiResponse movieApiResponse =
                        response.body();
                if (movieApiResponse != null
                        && movieApiResponse.getResults() != null){

                    results = (ArrayList<Result>) movieApiResponse
                            .getResults();

                    mutableLiveData.setValue(results);

                }

            }

            @Override
            public void onFailure(Call<MovieApiResponse> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }
}
