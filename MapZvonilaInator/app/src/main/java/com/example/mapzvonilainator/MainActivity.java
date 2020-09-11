package com.example.mapzvonilainator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onMapClick(View view) {
        intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:-0.78547489, -54.48569654"));
        startActivity(intent);
    }

    public void onCallClick(View view) {
        intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:8800553535"));
        startActivity(intent);

    }

    public void onWebClick(View view) {
        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Bur1y"));
        startActivity(intent);
    }
}