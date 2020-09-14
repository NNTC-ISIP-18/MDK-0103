package com.nntc.activinator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DependentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependent);

        ((TextView) findViewById(R.id.result_text)).setText("Age is " + getIntent().getStringExtra("age"));
    }
}