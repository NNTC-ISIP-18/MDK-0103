package com.example.naebankinator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ATM_Separation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_t_m__separation);

        ListView atmSep = findViewById(R.id.listAtmSep);

        final String[] catNames = new String[] {
                "Банкомат #1", "Банкомат #2", "Банкомат #3", "Банкомат #4", "Банкомат #5", "Банкомат #6", "Банкомат #7", "Банкомат #8", "Банкомат #9", "Банкомат #10", "Банкомат #11", "Банкомат #12", "Банкомат #13",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, catNames);

        atmSep.setAdapter(adapter);
    }
}