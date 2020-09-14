package com.nntc.parrotconvertinator;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.function.Function;

public class Converter {
    private final String from;
    private final String to;
    private final Function<Double, Double> converter;

    public Converter(String from, String to, Function<Double, Double> converter) {
        this.from = from;
        this.to = to;
        this.converter = converter;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Double convert(Double input) {
        return converter.apply(input);
    }

    @Override
    public String toString() {
        return from + " -> " + to;
    }
}
