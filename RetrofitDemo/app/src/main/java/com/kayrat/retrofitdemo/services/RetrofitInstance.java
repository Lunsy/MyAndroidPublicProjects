package com.kayrat.retrofitdemo.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit = null;

    private  static  String BASE_URL = "https://api.jsonstorage.net/v1/json/";

    public static CountryService getService() {

        if (retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }



        return retrofit.create(CountryService.class);

    }

}
