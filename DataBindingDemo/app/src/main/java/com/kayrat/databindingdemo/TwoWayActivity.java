package com.kayrat.databindingdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.kayrat.databindingdemo.databinding.ActivityTwoWayBinding;


public class TwoWayActivity extends AppCompatActivity {

    private ActivityTwoWayBinding activityTwoWayBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_way);

        activityTwoWayBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_two_way);
        activityTwoWayBinding.setGreeting(getCurrentGreeting());
    }

    private Greeting getCurrentGreeting(){
        return new Greeting("John","Hello!");
    }
}