package com.nntc.complexlistinator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ListWithButtonsActivity extends AppCompatActivity {
    private String[] meals = new String[]{
            "Eggs",
            "Meat",
            "Cereals",
            "Rice",
            "Other",
            "Seafood",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_with_buttons);
        ListView list = findViewById(R.id.list);
        ArrayList<Meal> mealsList = new ArrayList<>();
        for (String meal : meals) {
            mealsList.add(new Meal(meal, 0));
        }
        list.setAdapter(new MealAdapter(this, R.layout.layout_list_item_with_buttons, mealsList));
    }

    public void onBackClick(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}