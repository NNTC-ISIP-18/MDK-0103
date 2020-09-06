package com.example.reiteration_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    double num1 = 0;
    double num2 = 0;
    boolean start = true;
    char operation = ' ';
    String result = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        EditText editText = findViewById(R.id.editText);
        Button button = (Button)view;
            switch (button.getText().toString()) {
                case "/":
                    if (start) {
                        num1 = Double.parseDouble(editText.getText().toString());
                        editText.setText("0");
                        operation = '/';
                        start = false;
                    } else {
                        num2 = Double.parseDouble(editText.getText().toString());
                        editText.setText("0");
                        num1 = num1 / num2;
                    }
                    break;
                case "*":
                    if (start) {
                        num1 = Double.parseDouble(editText.getText().toString());
                        editText.setText("0");
                        operation = '*';
                        start = false;
                    } else {
                        num2 = Double.parseDouble(editText.getText().toString());
                        editText.setText("0");
                        num1 = num1 * num2;
                    }
                    break;
                case "-":
                    if (start) {
                        num1 = Double.parseDouble(editText.getText().toString());
                        editText.setText("0");
                        operation = '-';
                        start = false;
                    } else {
                        num2 = Double.parseDouble(editText.getText().toString());
                        editText.setText("0");
                        num1 = num1 - num2;
                    }
                    break;
                case "+":
                    if (start) {
                        num1 = Double.parseDouble(editText.getText().toString());
                        editText.setText("0");
                        operation = '+';
                        start = false;
                    } else {
                        num2 = Double.parseDouble(editText.getText().toString());
                        editText.setText("0");
                        num1 = num1 + num2;
                    }
                    break;
                case "%":
                    if (start) {
                        num1 = Double.parseDouble(editText.getText().toString());
                        editText.setText("0");
                        operation = '%';
                        start = false;
                    } else {
                        num2 = Double.parseDouble(editText.getText().toString());
                        editText.setText("0");
                        num1 = (num1 / 100) * num2;
                    }
                    break;
                case "=":
                    if (start) {
                    } else {
                        switch (operation) {
                            case '/':
                                num2 = Double.parseDouble(editText.getText().toString());
                                if((num1 / num2) % 1 == 0) {
                                    result = String.valueOf((int)(num1 / num2));
                                }
                                else {
                                    result = String.valueOf(num1 / num2);
                                }
                                break;
                            case '*':
                                num2 = Double.parseDouble(editText.getText().toString());
                                if((num1 * num2) % 1 == 0) {
                                    result = String.valueOf((int)(num1 * num2));
                                }
                                else {
                                    result = String.valueOf(num1 * num2);
                                }
                                break;
                            case '+':
                                num2 = Double.parseDouble(editText.getText().toString());
                                if((num1 + num2) % 1 == 0) {
                                    result = String.valueOf((int)(num1 + num2));
                                }
                                else {
                                    result = String.valueOf(num1 + num2);
                                }
                                break;
                            case '-':
                                num2 = Double.parseDouble(editText.getText().toString());
                                if((num1 - num2) % 1 == 0) {
                                    result = String.valueOf((int)(num1 - num2));
                                }
                                else {
                                    result = String.valueOf(num1 - num2);
                                }
                                break;
                            case '%':
                                num2 = Double.parseDouble(editText.getText().toString());
                                if(((num1 / 100) * num2) % 1 == 0) {
                                    result = String.valueOf((int)((num1 / 100) * num2));
                                }
                                else {
                                    result = String.valueOf(((num1 / 100) * num2));
                                }
                                break;
                        }
                        editText.setText(result);
                    }
                    break;
                case ".":
                    String a = editText.getText().toString();
                    int dot = a.indexOf(".");
                    if(dot == -1) {
                        editText.setText(a + ".");
                    }
                    break;
                case "+/-":
                    double negative = Double.parseDouble(editText.getText().toString());
                    String tmp = new String();
                    if(negative % 1 == 0)
                        tmp = String.valueOf((int)negative);
                    if(negative > 0) {
                        editText.setText("-" + tmp);
                    }
                    else {
                        tmp = tmp.replaceAll("-","");
                        editText.setText(tmp);
                    }
                    break;
                case "<-":
                    if(editText.getText().length() > 1){
                        editText.setText(editText.getText().toString().substring(0, editText.getText().toString().length() - 1));
                    }
                    else {
                        editText.setText("0");
                    }
                    break;
                case "C":
                    num1 = 0;
                    num2 = 0;
                    start = true;
                    editText.setText("0");
                    break;
                default:
                    if((Double.parseDouble(editText.getText().toString()) == 0) && (editText.getText().length() == 1)) {
                        editText.setText(button.getText().toString());
                    }
                    else {
                        editText.setText(editText.getText() + button.getText().toString());
                    }
                    break;
            }
    }
}