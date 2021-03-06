package com.example.shmakulator;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mpClick;
    private MediaPlayer mpClickAlert;
    private String n1 = "";
    private String n2 = "";
    private Operator operator = Operator.none;

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
            showToast(view);
        } else {
            mpClick.seekTo(0);
            mpClick.start();
            showToast(view);
        }
        String label = ((Button) view).getText().toString();
        if (Character.isDigit(label.charAt(0))) {
            try {
                int number = Integer.parseInt(label);
                showToast(view);
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
                    ((TextView) findViewById(R.id.resultBox)).setText(n1);
                    break;
                }
                // @formatter:off
                case R.id.btnPlus:
                    operator = Operator.plus;
                    break;
                case R.id.btnMinus:
                    operator = Operator.minus;
                    break;
                case R.id.btnMultiply:
                    operator = Operator.multiply;
                    break;
                case R.id.btnDiv:
                    operator = Operator.divide;
                    break;
                // @formatter:on
                case R.id.btnEqual: {
                    if (operator == Operator.none || n1.isEmpty() || n2.isEmpty()) {
                        return;
                    }
                    BigDecimal num1 = new BigDecimal(n1);
                    BigDecimal num2 = new BigDecimal(n2);
                    switch (operator) {
                        // @formatter:off
                        case plus:
                            num1 = num1.add(num2);
                            break;
                        case minus:
                            num1 = num1.subtract(num2);
                            break;
                        case multiply:
                            num1 = num1.multiply(num2);
                            break;
                        // @formatter:on
                        case divide:
                            if (num2.equals(BigDecimal.ZERO)) {
                                mpClickAlert.seekTo(0);
                                mpClickAlert.start();
                                return;
                            }
                            num1 = num1.divide(num2, 10, RoundingMode.HALF_UP);
                            break;
                    }
                    n1 = num1.stripTrailingZeros().toPlainString();
                    n2 = "";
                    ((TextView) findViewById(R.id.resultBox)).setText(n1);
                }
            }
        }
        ((TextView) findViewById(R.id.inputBox)).setText(operator == Operator.none ? n1 : n2);
    }

    enum Operator {
        none, plus, minus, multiply, divide
    }

    public void showToast(View view) {
        Toast message = Toast.makeText(getApplicationContext(),
                "Реклама", Toast.LENGTH_LONG);
        message.setGravity(Gravity.CENTER, 0, 0);
        LinearLayout toastContainer = (LinearLayout) message.getView();
        ImageView ImageView = new ImageView(getApplicationContext());
        ImageView.setImageResource(R.drawable.reclama);
        toastContainer.addView(ImageView, 1000,1000);
        message.show();
    }
}