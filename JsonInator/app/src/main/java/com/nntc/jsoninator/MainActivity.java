package com.nntc.jsoninator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayAdapter<Phone> adapter;
    private EditText nameText, priceText;
    private List<Phone> phones;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.nameText);
        priceText = findViewById(R.id.priceText);

        phones = new ArrayList<>();
        listView = findViewById(R.id.list);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, phones);
        listView.setAdapter(adapter);
    }

    public void onAddPhoneClick(View view) {
        String name = nameText.getText().toString();
        int price = 0;
        try {
            price = Integer.parseInt(priceText.getText().toString());
        } catch (NumberFormatException ex) {
            Toast.makeText(this, "Invalid price specified", Toast.LENGTH_SHORT).show();
            return;
        }
        Phone phone = new Phone(name, price);
        phones.add(phone);
        adapter.notifyDataSetChanged();
    }

    public void onSaveClick(View view) {
        boolean result = JsonWorker.save(this, phones);
        if (result) {
            Toast.makeText(this, R.string.data_saved, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, R.string.data_save_fail, Toast.LENGTH_LONG).show();
        }
    }

    public void onOpenClick(View view) {
        phones = JsonWorker.load(this);
        if (phones != null) {
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, phones);
            listView.setAdapter(adapter);
            Toast.makeText(this, R.string.data_loaded, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, R.string.data_load_fail, Toast.LENGTH_LONG).show();
        }
    }
}