package com.kayrat.mvvmretrofitdemo.service;

import static android.provider.Settings.System.getString;

import com.kayrat.mvvmretrofitdemo.R;

import okhttp3.Interceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class RetrofitInstance {

    private static Retrofit retrofit = null;
    private static String BASE_URL = "https://api.themoviedb.org/3/";


//    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//            Request newRequest  = chain.request().newBuilder()
//                    .addHeader("Authorization", "Bearer " + token)
//                    .build();
//            return chain.proceed(newRequest);
//        }
//    }).build();

    public static MovieApiService getService() {

        if (retrofit == null) {

            retrofit = new Retrofit
                    .Builder()
//                    .client(client)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

        return retrofit.create(MovieApiService.class);

    }



}
