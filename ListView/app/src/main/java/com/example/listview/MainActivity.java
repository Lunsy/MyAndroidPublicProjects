package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listViewTest);

        ArrayList<String> testArrayList= new ArrayList<String>();
        testArrayList.add("Красный");
        testArrayList.add("Оранжевый");
        testArrayList.add("Желтый");
        testArrayList.add("Зелёный");
        testArrayList.add("Голубой");
        testArrayList.add("Синий");
        testArrayList.add("Фиолетовый");
        testArrayList.add("Розовый");
        for (int i = 0; i < 8; i++){
            Log.i("tests ",testArrayList.get(i));
         }
        ArrayAdapter<String> testArrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, testArrayList);
        listView.setAdapter(testArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Номер " +
                        i + " - " + testArrayList.get(i), Toast.LENGTH_SHORT).show();
            }
        });
       }
}