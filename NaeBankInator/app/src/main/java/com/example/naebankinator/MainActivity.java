package com.example.naebankinator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(getLayoutInflater().inflate(R.layout.dialog_signin, null));

        builder.setPositiveButton("Войти", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                onAutorisated();
            }
        });
        builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });

        alertDialog = builder.create();

    }

    public void onATM(View view) {
        Intent intent = new Intent(this, ATM_Separation.class);
        startActivity(intent);
    }

    public void onValue(View view) {
        Intent intent = new Intent(this, Value.class);
        startActivity(intent);
    }
    public void onAutorisated(){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

    public void hui(View v) {
        alertDialog.show();
    }

}