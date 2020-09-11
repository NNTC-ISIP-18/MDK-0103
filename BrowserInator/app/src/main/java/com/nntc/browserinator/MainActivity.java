package com.nntc.browserinator;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBrowserClick(View view) {
        Intent intent = new Intent("com.nntc.Browser");
        intent.setData(Uri.parse("http://github.com"));
        startActivity(intent);
    }
}