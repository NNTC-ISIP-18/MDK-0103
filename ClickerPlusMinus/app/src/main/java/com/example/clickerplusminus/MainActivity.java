package com.example.clickerplusminus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void counterMinus(View view) {
        counter--;
        ((TextView) findViewById(R.id.countView)).setText("" + counter);
            }

    public void counterPlus(View view) {
        counter += 1;
        ((TextView) findViewById(R.id.countView)).setText("" + counter);

    }
}
