package com.example.oop;

import android.util.Log;

public class Kissy extends KittyCat implements Movable, Printable{

    Kissy(){
        Log.i("Constructor", "Constructor Kissy");
    }
    @Override
    public void draw() {
        Log.i("draw()","Draw kissy");
    }

    @Override
    public void move() {
        Log.i("move()","Move overridden kissy");
    }

    @Override
    public void print() {
        Log.i("print()","Print kissy");
    }
}
