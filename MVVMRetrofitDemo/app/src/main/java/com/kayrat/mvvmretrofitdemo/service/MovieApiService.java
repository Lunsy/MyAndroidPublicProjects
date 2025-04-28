package com.kayrat.mvvmretrofitdemo.service;

import com.kayrat.mvvmretrofitdemo.model.MovieApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface MovieApiService {

//    @Headers({"Authorization", "Bearer "+ api_token})
    @GET("movie/popular")
    Call<MovieApiResponse> getPopularMovies(@Query("api_key") String apiKey,
                                            @Query("language") String lang);


    Call<MovieApiResponse> getApiKey(@Query("api_key") String apiKey);
    Call<MovieApiResponse> getApiToken(@Query("api_token") String apiKey);

}
