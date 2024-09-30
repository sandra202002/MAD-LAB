package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button one, two, three, four, five, six, seven, eight, nine, zero;
    Button add, sub, mul, div, equ, back;
    String input = "", operator = "";
    double num1 = 0, num2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        equ = findViewById(R.id.equ);
        back = findViewById(R.id.back);
        setButtonListeners();
    }
    private void setButtonListeners() {

        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                input += b.getText().toString();
                textView.setText(input);
            }
        };

        one.setOnClickListener(numberClickListener);
        two.setOnClickListener(numberClickListener);
        three.setOnClickListener(numberClickListener);
        four.setOnClickListener(numberClickListener);
        five.setOnClickListener(numberClickListener);
        six.setOnClickListener(numberClickListener);
        seven.setOnClickListener(numberClickListener);
        eight.setOnClickListener(numberClickListener);
        nine.setOnClickListener(numberClickListener);
        zero.setOnClickListener(numberClickListener);
    add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            performOperation("+");
        }
    });

        sub.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            performOperation("-");
        }
    });

        mul.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            performOperation("*");
        }
    });

        div.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            performOperation("/");
        }
    });

        equ.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            calculateResult();
        }
    });

        back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (input.length() > 0) {
                input = input.substring(0, input.length() - 1);
                textView.setText(input);
            }
        }
    });
}

private void performOperation(String op) {
    if (!input.equals("")) {
        num1 = Double.parseDouble(input);
        operator = op;
        input = "";
    }
}

private void calculateResult() {
    if (!input.equals("") && !operator.equals("")) {
        num2 = Double.parseDouble(input);
        double result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    textView.setText("Error");
                    return;
                }
                break;
        }

        textView.setText(String.valueOf(result));
        input = String.valueOf(result); // Store the result for further operations
    }
}
}

