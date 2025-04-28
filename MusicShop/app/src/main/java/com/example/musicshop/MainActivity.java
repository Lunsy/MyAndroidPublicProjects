package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    int qntty = 0;
    Spinner itmSpnr;
    ArrayList spnrArrayList;
    ArrayAdapter spnrAdapter;
    HashMap goodsMap;
    String goodsName;
    double price;
    EditText userNameET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameET = findViewById(R.id.enterNameET);

        createSpinner();

        createHashMap();

        createQuantity();

    }

    void createSpinner(){
        itmSpnr = findViewById(R.id.itmSpinner);
        itmSpnr.setOnItemSelectedListener(this);
        spnrArrayList = new ArrayList();

        spnrArrayList.add("Smart Watch");
        spnrArrayList.add("BlueThooth HeadPhones");
        spnrArrayList.add("SmartPhones");

        spnrAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spnrArrayList);
        spnrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        itmSpnr.setAdapter(spnrAdapter);
    }

    void createQuantity(){
        qntty = 1;
        TextView quantityCounter = findViewById(R.id.quantityCount);
        quantityCounter.setText("" + qntty);
    }

    void createHashMap(){
        goodsMap = new HashMap();
        goodsMap.put("Smart Watch", 50.0);
        goodsMap.put("BlueThooth HeadPhones", 25.0);
        goodsMap.put("SmartPhones", 200.0);
    }
    public void incQntty(View view) {
        qntty ++;
        TextView quantityCounter = findViewById(R.id.quantityCount);
        quantityCounter.setText("" + qntty);
        TextView prcCnt = findViewById(R.id.priceCount);
        prcCnt.setText("" + qntty * price);
    }

    public void decQntty(View view) {
        qntty --;
        if (qntty < 1){
            qntty = 1;
        }
        TextView quantityCounter = findViewById(R.id.quantityCount);
        quantityCounter.setText("" + qntty);
        TextView prcCnt = findViewById(R.id.priceCount);
        prcCnt.setText("" + qntty * price);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        goodsName = itmSpnr.getSelectedItem().toString();
        price = (double) goodsMap.get(goodsName);
        TextView prcCnt = findViewById(R.id.priceCount);
        prcCnt.setText("" + qntty * price);

        ImageView goodsImageView = findViewById(R.id.goodImage);

       switch (goodsName){
           case "Smart Watch":
               goodsImageView.setImageResource(R.drawable.smartwatch);
               break;
           case "BlueThooth HeadPhones":
               goodsImageView.setImageResource(R.drawable.bluetoothearphone2);
               break;
           case "SmartPhones":
               goodsImageView.setImageResource(R.drawable.smartphone);
               break;
           default:
               goodsImageView.setImageResource(R.drawable.smartwatch);
               break;
       }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void addToCart(View view) {

        Order order = new Order();

        order.userName = userNameET.getText().toString();


        order.goodsName = goodsName;


        order.qntty = qntty;

        order.price = price;


        order.orderPrice = qntty * price;

        Intent orderIntent = new Intent(MainActivity.this, OrderActivity.class);
        orderIntent.putExtra("userNameForIntent", order.userName);
        orderIntent.putExtra("goodsName", order.goodsName);
        orderIntent.putExtra("quantity", order.qntty);
        orderIntent.putExtra("price", order.price);
        orderIntent.putExtra("orderPrice", order.orderPrice);

        startActivity(orderIntent);
    }
}