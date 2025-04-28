package com.example.carsdb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import Data.DatabaseHandler;
import Model.Car;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        Log.d("CarsCount:", String.valueOf(databaseHandler.getCarCount()));

        databaseHandler.addCar(new Car("Toyota", "30 000 $"));
        databaseHandler.addCar(new Car("Opel", "25 000 $"));
        databaseHandler.addCar(new Car("Mercedes", "50 000 $"));
        databaseHandler.addCar(new Car("Honda", "30 000 $"));
        databaseHandler.addCar(new Car("Hundai", "28 000 $"));
        databaseHandler.addCar(new Car("KIA", "20 000 $"));
        databaseHandler.addCar(new Car("Lada", "5 000 $"));

        databaseHandler.addCar(new Car("Mazda", "20 000 $"));
        databaseHandler.addCar(new Car("BMW", "40 000 $"));
        databaseHandler.addCar(new Car("Renault", "45 000 $"));
        databaseHandler.addCar(new Car("Ford", "35 000 $"));
        databaseHandler.addCar(new Car("Chevrolet", "5 000 $"));



      /*  Car delCar = databaseHandler.getCar(8);
        databaseHandler.deleteCar(delCar);*/

        List<Car> carList = databaseHandler.getAllCar();
        for (Car car : carList){
            Log.d("Car_Info: ", "ID " + car.getId() + ", name " + car.getName() +
                    ", price " + car.getPrice());
        }
       /* Car car = databaseHandler.getCar(1);



        car.setName("Tesla");
        car.setPrice("50 000$");

        int updatedCarId = databaseHandler.updateCar(car);

        Log.d("Car_Info: ", "ID " + car.getId() + ", name " + car.getName() +
                ", price " + car.getPrice() + ", updatedCarId " + updatedCarId);*/


    }
}