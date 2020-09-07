package com.nntc.complexlistinator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onSimpleListClick(View view) {
        startActivity(new Intent(this, SimpleListActivity.class));
    }

    public void onButtonsListClick(View view) {
        startActivity(new Intent(this, ListWithButtonsActivity.class));
    }

    public void onAutocompleteBoxClick(View view) {
        startActivity(new Intent(this, AutocompletingTextBox.class));
    }

    public void onSimpleListClick(MenuItem item) {
        onSimpleListClick((View) null);
    }

    public void onButtonsListClick(MenuItem item) {
        onButtonsListClick((View) null);
    }

    public void onAutocompleteBoxClick(MenuItem item) {
        onAutocompleteBoxClick((View) null);
    }
}