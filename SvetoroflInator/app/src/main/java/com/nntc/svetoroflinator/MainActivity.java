package com.nntc.svetoroflinator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onLight1Click(View view) {
        findViewById(R.id.mainBack).setBackgroundColor(Color.parseColor("#F44336"));
    }

    public void onLight2Click(View view) {
        findViewById(R.id.mainBack).setBackgroundColor(Color.parseColor("#4CAF50"));
    }

    public void onLight3Click(View view) {
        findViewById(R.id.mainBack).setBackgroundColor(Color.parseColor("#00BCD4"));
    }
}
