package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onHelloClick(View view) {
        ((TextView) findViewById(R.id.textHello)).setText("Привет, Билли Джин!");
    }

    public void onClickClick(View view) {
        // Прибовляем и выдаем ответ
        counter += 1;
        ((TextView) findViewById(R.id.textClick)).setText("" + counter);
    }
}
