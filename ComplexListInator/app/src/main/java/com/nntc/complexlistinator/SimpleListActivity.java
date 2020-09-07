package com.nntc.complexlistinator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SimpleListActivity extends AppCompatActivity {
    private String[] languages = new String[]{
            "Action Script",
            "C++/CLI",
            "C#",
            "ColdFusion",
            "D",
            "Delphi",
            "Dylan",
            "Eiffel",
            "Game Maker Language (GML)",
            "Groovy",
            "Haxe",
            "Io",
            "Java",
            "JavaScript",
            "MC#",
            "Object Pascal",
            "Objective-C",
            "Perl",
            "PHP",
            "Pike",
            "Python",
            "Ruby",
            "Self",
            "Simula",
            "Smalltalk",
            "Swift",
            "Vala",
            "Visual Basic",
            "Visual DataFlex",
            "Zonnon",
            "Ada",
            "Активный Оберон",
            "Компонентный Паскаль",
            "Модула-3",
            "Оберон-2"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);
        ListView list = findViewById(R.id.list);
        list.setAdapter(new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, languages));
    }

    public void onBackClick(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}