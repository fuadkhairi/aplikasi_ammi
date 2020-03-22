package com.example.crudammi.ui.imt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crudammi.R;

public class ImtActivity extends AppCompatActivity {

    EditText height, weight;
    TextView result;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imt);

        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
        calculate = (Button) findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI(){
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if (heightStr !=null && !"".equals(heightStr) && weightStr !=null && !"".equals(weightStr)){
            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue);

            displayBMI(bmi);
        }
    }

    private void displayBMI(float bmi){
        String bmiLabel = "";

        if (Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = "Berat Badan Kurang";
        } else if (Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 22.9f) <= 0) {
            bmiLabel = "Normal";
        } else if (Float.compare(bmi, 22.9f) > 0 && Float.compare(bmi, 23f) <= 0) {
            bmiLabel = "Berat Badan Lebih";
        } else if (Float.compare(bmi, 23f) > 0 && Float.compare(bmi,24.9f) <= 0) {
            bmiLabel = "Beresiko";
        } else if (Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 29.9f) <= 0) {
            bmiLabel = "Obesitas I";
        } else  {
            bmiLabel = "Obesitas II";
        }

        bmiLabel = bmi + "\n" + bmiLabel;
        result.setText(bmiLabel);
    }
}