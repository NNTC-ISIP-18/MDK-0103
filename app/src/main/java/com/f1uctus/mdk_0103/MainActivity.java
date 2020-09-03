package com.f1uctus.mdk_0103;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSendMessageClick(View view) {
        setContentView(R.layout.activity_messages);
    }

    public void onBackClick(View view) {
        setContentView(R.layout.activity_main);
    }
}