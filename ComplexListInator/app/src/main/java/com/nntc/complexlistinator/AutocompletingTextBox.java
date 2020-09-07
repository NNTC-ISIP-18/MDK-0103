package com.nntc.complexlistinator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

public class AutocompletingTextBox extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocompleting_text_box);

        AutoCompleteTextView autoCompleteTextView1 = findViewById(R.id.autocomplete);
        autoCompleteTextView1.setAdapter(new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, App.cities));

        MultiAutoCompleteTextView autoCompleteTextView2 = findViewById(R.id.autocompleteMulti);
        autoCompleteTextView2.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        autoCompleteTextView2.setAdapter(new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, App.cities));

    }

    public void onBackClick(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}