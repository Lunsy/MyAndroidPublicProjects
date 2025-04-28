package com.kayrat.retrofitdemo.services;

import com.kayrat.retrofitdemo.model.CountryInfo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountryService {

    @GET("53dff841-2d89-4aca-bf9b-fa432fe169e7/57de7912-883f-4ed7-9e04-6272a3318d71")
    Call<CountryInfo> getResults();

}
