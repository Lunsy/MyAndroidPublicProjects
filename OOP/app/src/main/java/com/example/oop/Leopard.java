package com.example.oop;

import android.util.Log;

public class Leopard extends KittyCat implements Printable{

    @Override
    public void draw() {
        Log.i("draw","Draw leo");

    }

    @Override
    public void print() {

    }
}
