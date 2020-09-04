package com.example.pickerinator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatePicker dp = (DatePicker) this.findViewById(R.id.datePicker);
        dp.init(2015, 02, 01, null);
        TimePicker tp = (TimePicker) this.findViewById(R.id.timePicker);
        java.util.Formatter timeF = new java.util.Formatter();
tp.setIs24HourView(true);
tp.setCurrentHour(new Integer(10));
tp.setCurrentMinute(new Integer(10));
}

}
