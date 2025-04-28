package com.kayrat.databindingdemo;

import android.os.Bundle;

//import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;


import androidx.databinding.DataBindingUtil;



import com.kayrat.databindingdemo.databinding.ActivityOkBinding;

public class OkActivity extends AppCompatActivity {


//    private ActivityOkBinding binding;

    private ActivityOkBinding activityOkBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        binding = ActivityOkBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        setSupportActionBar(binding.toolbar);
//
//        binding.fab.setOnClickListener(view -> Snackbar.make(view,
//                        "Replace with your own action",
//                        Snackbar.LENGTH_LONG)
//                .setAnchorView(R.id.fab)
//                .setAction("Action", null).show());

        activityOkBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_ok);

        activityOkBinding.setBook(getCurrentBook());
    }


    private Book getCurrentBook() {

        Book book = new Book();
        book.setTitle("Hamlet");
        book.setAuthor("Shakespeare");
        return book;

    }
}