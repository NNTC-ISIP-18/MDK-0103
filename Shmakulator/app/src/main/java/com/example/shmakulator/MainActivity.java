package com.example.shmakulator;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer mpClick = MediaPlayer.create(this, R.raw.click);
        ArrayList<View> allButtons = findViewById(R.id.buttonsContainer).getTouchables();
        for (View v : allButtons) {
            Button btn = (Button) v;
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mpClick.start();
                }
            });
        }
        final MediaPlayer mpClickDel = MediaPlayer.create(this, R.raw.click_del);
        findViewById(R.id.butdelet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpClickDel.start();
            }
        });
    }
}
