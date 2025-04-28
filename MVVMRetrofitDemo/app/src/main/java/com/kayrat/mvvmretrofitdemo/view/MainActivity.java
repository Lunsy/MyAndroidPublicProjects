package com.kayrat.mvvmretrofitdemo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.kayrat.mvvmretrofitdemo.R;
import com.kayrat.mvvmretrofitdemo.adapter.ResultAdapter;
import com.kayrat.mvvmretrofitdemo.model.MovieApiResponse;
import com.kayrat.mvvmretrofitdemo.model.Result;
import com.kayrat.mvvmretrofitdemo.service.MovieApiService;
import com.kayrat.mvvmretrofitdemo.service.RetrofitInstance;
import com.kayrat.mvvmretrofitdemo.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Result> results;
    private RecyclerView recyclerView;
    private ResultAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityViewModel = new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(MainActivityViewModel.class);

        getPopularMovies();

        swipeRefreshLayout =
                findViewById(R.id.swipeRefreshLayout);

        swipeRefreshLayout.setColorSchemeColors(0x9C27B0);
        swipeRefreshLayout.setOnRefreshListener(() -> {

            getPopularMovies();

        });
    }

    public void getPopularMovies(){

        mainActivityViewModel.getAllMovieData()
                .observe(this,
                        resultsList -> {
                            results = (ArrayList<Result>) resultsList;
                            fillRecyclerView();
                        });

    }

    private void fillRecyclerView() {

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new ResultAdapter(this, results);

        if(getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        } else {

            recyclerView.setLayoutManager(
                    new GridLayoutManager(this, 4)
            );

        }

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);


    }
}