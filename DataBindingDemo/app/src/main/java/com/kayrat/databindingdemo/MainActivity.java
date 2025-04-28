package com.kayrat.databindingdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kayrat.databindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private MainActivityButtonsHandler mainActivityButtonsHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_main
        );
        activityMainBinding.setBook(getCurrentBook());

        mainActivityButtonsHandler = new MainActivityButtonsHandler(this);
        activityMainBinding.setButtonHandler(mainActivityButtonsHandler);
    }

    private Book getCurrentBook() {

        Book book = new Book();
        book.setTitle("Hamlet");
        book.setAuthor("Shakespeare");
        return book;

    }

    public class MainActivityButtonsHandler {

        Context context;

        public MainActivityButtonsHandler(Context context) {
            this.context = context;
        }

        public void onOkClicked(View view) {

//            Toast.makeText(context, "Ok", Toast.LENGTH_LONG).show();
            startActivity(new Intent(MainActivity.this,
                   OkActivity.class));

        }

        public void onCancelClicked(View view) {

//            Toast.makeText(context, "Cancel", Toast.LENGTH_LONG).show();

            startActivity(new Intent(MainActivity.this,
                    TwoWayActivity.class));

        }


    }
}