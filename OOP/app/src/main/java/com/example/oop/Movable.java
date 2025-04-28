package com.example.oop;

import android.util.Log;

public interface Movable {

    int speedOfMoving = 100;
    default void move(){
        Log.i("move()","Move kissy");
    }

    static void someMethod(){
        Log.i("someMethod()","SomeMethod kissy");
    }
}
