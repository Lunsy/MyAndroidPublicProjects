package com.example.supermanandsupergirl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {



    boolean isSupergirlVisible = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }


    public void blindSupergirl(View view) {

        if (isSupergirlVisible) {

            ImageView supergirl= findViewById(R.id.supergirIV);
            ImageView superman = findViewById(R.id.supermanIV);


            supergirl.animate().alpha(0).scaleX(0.1f).scaleY(0.1f).rotation(supergirl.getRotation() + 3600).setDuration(3000);


            superman.animate().alpha(1).scaleX(1).scaleY(1).rotation(superman.getRotation() + 3600).setDuration(3000);


            isSupergirlVisible = false;
        } else {


            ImageView supergirl= findViewById(R.id.supergirIV);
            ImageView superman = findViewById(R.id.supermanIV);



            superman.animate().alpha(0).scaleX(0.1f).scaleY(0.1f).rotation(superman.getRotation() + 3600).setDuration(3000);



            supergirl.animate().alpha(1).scaleX(1).scaleY(1).rotation(supergirl.getRotation() + 3600).setDuration(3000);


            isSupergirlVisible = true;
        }

    }

}