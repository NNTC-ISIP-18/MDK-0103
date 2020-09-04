package com.example.shmakulator;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mpClick;
    MediaPlayer mpClickAlert;

    private String n1 = "";
    private String n2 = "";
    Operator operator = Operator.none;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mpClick = MediaPlayer.create(this, R.raw.click);
        mpClickAlert = MediaPlayer.create(this, R.raw.click_del);
    }

    public void onKeyboardClick(View view) {
        if (view.getId() == R.id.btnDelete) {
            mpClickAlert.seekTo(0);
            mpClickAlert.start();
        } else {
            mpClick.seekTo(0);
            mpClick.start();
        }
        String label = ((Button) view).getText().toString();
        if (Character.isDigit(label.charAt(0))) {
            try {
                int number = Integer.parseInt(label);
                if (operator == Operator.none) {
                    n1 += number;
                } else {
                    n2 += number;
                }
            } catch (Exception ignored) {
            }
        } else {
            switch (view.getId()) {
                case R.id.btnDelete: {
                    if (operator == Operator.none && n1.length() > 0) {
                        n1 = n1.substring(0, n1.length() - 1);
                    } else if (n2.length() > 0) {
                        n2 = n2.substring(0, n2.length() - 1);
                    }
                    break;
                }
                case R.id.btnClear: {
                    n1 = "";
                    n2 = "";
                    operator = Operator.none;
                }
                case R.id.btnPlus: {
                    operator = Operator.plus;
                    break;
                }
                case R.id.btnMinus: {
                    operator = Operator.minus;
                    break;
                }
                case R.id.btnMultiply: {
                    operator = Operator.multiply;
                    break;
                }
                case R.id.btnDiv: {
                    operator = Operator.divide;
                    break;
                }
                case R.id.btnEqual: {
                    if (operator == Operator.none) {
                        return;
                    }
                    double result = 0d;
                    double num1 = Double.parseDouble(n1);
                    double num2 = Double.parseDouble(n2);
                    switch (operator) {
                        case plus:
                            result = num1 + num2;
                            break;
                        case minus:
                            result = num1 - num2;
                            break;
                        case multiply:
                            result = num1 * num2;
                            break;
                        case divide:
                            if (num2 == 0) {
                                mpClickAlert.seekTo(0);
                                mpClickAlert.start();
                                return;
                            }
                            result = num1 / num2;
                            break;
                    }
                    n1 = Double.toString(result);
                    n2 = "";
                    operator = Operator.none;
                    break;
                }
            }
        }
        if (operator == Operator.none) {
            ((TextView) findViewById(R.id.inputBox)).setText(n1);
        } else {
            ((TextView) findViewById(R.id.inputBox)).setText(n2);
        }
    }

    enum Operator {
        none, plus, minus, multiply, divide
    }
}
