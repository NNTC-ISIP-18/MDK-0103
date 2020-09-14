package com.example.naebankinator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onATM(View view) {
        Intent intent = new Intent(this,ATM_Separation.class);
        startActivity(intent);
    }

    public void onValue(View view) {
        Intent intent = new Intent(this,Value.class);
        startActivity(intent);
    }
}