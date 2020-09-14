package com.nntc.activinator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSubmitClick(View view) {
        String age = ((TextView) findViewById(R.id.age_text)).getText().toString();
        Intent i = new Intent(this, DependentActivity.class);
        i.putExtra("age", age);
        startActivity(i);
    }
}