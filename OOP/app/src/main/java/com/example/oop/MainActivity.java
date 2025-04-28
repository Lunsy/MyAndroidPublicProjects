package com.example.oop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Printable{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Printable printable = new Kissy();
        printable.print();
        ((Kissy) printable).move();

       Movable.someMethod();

       Kissy kissy = new Kissy();
       Log.i("speedOfMoving","" + kissy.speedOfMoving);

       Log.i("speedOfMoving","" + ((Kissy)printable).speedOfMoving);
       Log.i("speedOfMoving","" + Movable.speedOfMoving);
    }
    void  printAnyObject(Printable printable){

    }
    void printAnyObject(Kissy kissy){

    }


    @Override
    public void print() {

    }
}