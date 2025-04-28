package com.example.pizzarecipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private GridLayoutManager layoutManager;
    private int columnCounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        columnCounts = getResources().getInteger(R.integer.column_count);

        ArrayList<PizzaRecipeItem> pizzaRecipeItems = new ArrayList<>();

        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_1,
               getResources().getString(R.string.PIZZA_1_NAME), getResources().getString(R.string
                .PIZZA_1_DESCRIPTION), getResources().getString(R.string.PIZZA_1_RECIPE)));

        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_2,
                getResources().getString(R.string.PIZZA_2_NAME), getResources().getString(R.string
                .PIZZA_2_DESCRIPTION), getResources().getString(R.string.PIZZA_2_RECIPE)));

        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_3,
                getResources().getString(R.string.PIZZA_3_NAME), getResources().getString(R.string
                .PIZZA_3_DESCRIPTION), getResources().getString(R.string.PIZZA_3_RECIPE)));

        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_4,
                getResources().getString(R.string.PIZZA_4_NAME), getResources().getString(R.string
                .PIZZA_4_DESCRIPTION), getResources().getString(R.string.PIZZA_4_RECIPE)));

        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_5,
                getResources().getString(R.string.PIZZA_5_NAME), getResources().getString(R.string
                .PIZZA_5_DESCRIPTION), getResources().getString(R.string.PIZZA_5_RECIPE)));

        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_6,
                getResources().getString(R.string.PIZZA_6_NAME), getResources().getString(R.string
                .PIZZA_6_DESCRIPTION), getResources().getString(R.string.PIZZA_6_RECIPE)));

        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_7,
                getResources().getString(R.string.PIZZA_7_NAME), getResources().getString(R.string
                .PIZZA_7_DESCRIPTION), getResources().getString(R.string.PIZZA_7_RECIPE)));

        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_8,
                getResources().getString(R.string.PIZZA_8_NAME), getResources().getString(R.string
                .PIZZA_8_DESCRIPTION), getResources().getString(R.string.PIZZA_8_RECIPE)));

        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_9,
                getResources().getString(R.string.PIZZA_9_NAME), getResources().getString(R.string
                .PIZZA_9_DESCRIPTION), getResources().getString(R.string.PIZZA_9_RECIPE)));

        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_10,
                getResources().getString(R.string.PIZZA_10_NAME), getResources().getString(R.string
                .PIZZA_10_DESCRIPTION), getResources().getString(R.string.PIZZA_10_RECIPE)));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        adapter = new PizzaRecipeAdapter(pizzaRecipeItems, this);
        layoutManager = new GridLayoutManager(this, columnCounts);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        }
}