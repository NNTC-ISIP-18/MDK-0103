package com.nntc.parrotconvertinator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Converter[][] converters = {
            {
                new Converter(getString(R.string.meters), getString(R.string.meters), (n) -> n),
                new Converter(getString(R.string.meters), getString(R.string.parrots), (n) -> n * 7.6)
            },
            {
                new Converter(getString(R.string.parrots), getString(R.string.meters), (n) -> n / 7.6),
                new Converter(getString(R.string.parrots), getString(R.string.parrots), (n) -> n)
            }
        };

        AtomicInteger selectedInput = new AtomicInteger();
        AtomicInteger selectedOutput = new AtomicInteger();

        ArrayAdapter<Converter> inputAdapter = new ArrayAdapter<Converter>(
            this,
            R.layout.point_item_layout,
            R.id.item_radio,
            converters[0]
        ) {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = convertView;
                if (v == null) {
                    LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    v = vi.inflate(R.layout.point_item_layout, null);
                }
                RadioButton r = v.findViewById(R.id.item_radio);
                r.setChecked(position == selectedInput.get());
                r.setTag(position);
                r.setText(converters[position][0].getFrom());
                r.setOnClickListener(view -> {
                    selectedInput.set((Integer) view.getTag());
                    notifyDataSetChanged();
                    Converter conv = converters[selectedInput.get()][selectedOutput.get()];
                    EditText input = findViewById(R.id.input_box);
                    TextView output = findViewById(R.id.result_box);
                    try {
                        Double inp = Double.parseDouble(input.getText().toString());
                        output.setText(conv.convert(inp).toString());
                    } catch (NumberFormatException e) {
                        output.setText(R.string.invalid);
                    }
                });
                return v;
            }
        };

        ArrayAdapter<Converter> outputAdapter = new ArrayAdapter<Converter>(
            this,
            R.layout.point_item_layout,
            R.id.item_radio,
            converters[1]
        ) {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = convertView;
                if (v == null) {
                    LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    v = vi.inflate(R.layout.point_item_layout, null);
                }
                RadioButton r = v.findViewById(R.id.item_radio);
                r.setChecked(position == selectedOutput.get());
                r.setTag(position);
                r.setText(converters[0][position].getTo());
                r.setOnClickListener(view -> {
                    selectedOutput.set((Integer) view.getTag());
                    notifyDataSetChanged();
                    Converter conv = converters[selectedInput.get()][selectedOutput.get()];
                    EditText input = findViewById(R.id.input_box);
                    TextView output = findViewById(R.id.result_box);
                    try {
                        Double inp = Double.parseDouble(input.getText().toString());
                        output.setText(conv.convert(inp).toString());
                    } catch (NumberFormatException e) {
                        output.setText(R.string.invalid);
                    }
                });
                return v;
            }
        };

        ListView inputList = findViewById(R.id.inputUnitsList);
        inputList.setAdapter(inputAdapter);

        ListView outputList = findViewById(R.id.outputUnitsList);
        outputList.setAdapter(outputAdapter);
    }
}