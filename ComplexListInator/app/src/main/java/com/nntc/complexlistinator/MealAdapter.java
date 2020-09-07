package com.nntc.complexlistinator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MealAdapter extends ArrayAdapter<Meal> {
    private LayoutInflater inflater;
    private int layout;
    private List<Meal> meals;

    public MealAdapter(Context context, int resource, List<Meal> meals) {
        super(context, resource, meals);
        this.meals = meals;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    static class ViewHolder {
        TextView name;
        TextView count;

        public ViewHolder(Meal meal, TextView name, TextView count) {
            this.name = name;
            this.count = count;
            name.setTag(meal);
            count.setTag(meal);
            name.setText(meal.getName());
            count.setText(Integer.toString(meal.getCount()));
        }
    }

    @SuppressLint("SetTextI18n")
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layout, parent, false);
            final ViewHolder vh = new ViewHolder(
                    meals.get(position),
                    (TextView) convertView.findViewById(R.id.name),
                    (TextView) convertView.findViewById(R.id.count)
            );
            convertView.setTag(vh);
            convertView.findViewById(R.id.count_plus).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Meal m = meals.get(position);
                    int count = m.getCount();
                    m.setCount(count + 1);
                    vh.count.setText(Integer.toString(m.getCount()));
                }
            });
            convertView.findViewById(R.id.count_minus).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Meal m = meals.get(position);
                    int count = m.getCount();
                    if (count == 0) return;
                    m.setCount(count - 1);
                    vh.count.setText(Integer.toString(m.getCount()));
                }
            });
        }
        return convertView;
    }
}
