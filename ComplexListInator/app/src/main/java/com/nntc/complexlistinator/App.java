package com.nntc.complexlistinator;

import android.app.Application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App extends Application {
    public static final ArrayList<String> cities = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();

        try {
            try (InputStream is = getResources().openRawResource(R.raw.cities)) {
                try (InputStreamReader ir = new InputStreamReader(is)) {
                    try (BufferedReader br = new BufferedReader(ir)) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            cities.add(line);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}