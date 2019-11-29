package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.nio.DoubleBuffer;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText firstValue = findViewById(R.id.editText_FirstNumber);
        final EditText secondValue = findViewById(R.id.editText_SecondNumber);
        ImageButton buttonAdd = findViewById(R.id.buttonAdd);
        ImageButton buttonSubtract = findViewById(R.id.buttonSubtract);
        ImageButton buttonMultiply = findViewById(R.id.buttonMultiply);
        ImageButton buttonDivide = findViewById(R.id.buttonDivide);

        final TextView result = findViewById(R.id.textViewResult);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value1 = Integer.parseInt(firstValue.getText().toString());
                int value2 = Integer.parseInt(secondValue.getText().toString());
                int answer = value1 + value2;
                result.setText(Integer.toString(answer));
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value1 = Integer.parseInt(firstValue.getText().toString());
                int value2 = Integer.parseInt(secondValue.getText().toString());
                int answer = value1 - value2;
                result.setText(Integer.toString(answer));
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value1 = Integer.parseInt(firstValue.getText().toString());
                int value2 = Integer.parseInt(secondValue.getText().toString());
                int answer = value1 * value2;
                result.setText(Integer.toString(answer));
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value1 = Integer.parseInt(firstValue.getText().toString());
                int value2 = Integer.parseInt(secondValue.getText().toString());
                double answer = (double) value1 / (double) value2;
                result.setText(Double.toString(answer));
            }
        });
    }
}
