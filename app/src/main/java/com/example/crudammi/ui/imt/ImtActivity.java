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
    AppCompatRadioButton rbpria, rbwanita;
    EditText lingkarPinggangET;

    boolean isWanita = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imt);

        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
        calculate = (Button) findViewById(R.id.calculate);

        rbpria = findViewById(R.id.rdpria);
        rbwanita = findViewById(R.id.rdwanita);

        lingkarPinggangET = findViewById(R.id.lingkarPinggang);

        rbwanita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isWanita = true;
                Toast.makeText(getBaseContext(), "wanita", Toast.LENGTH_LONG).show();
            }
        });

        rbpria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isWanita = false;
                Toast.makeText(getBaseContext(), "pria", Toast.LENGTH_LONG).show();
            }
        });

        calculate.setOnClickListener((view -> { calculateBMI();}));
    }
    public void onRadioButtonClicked(View view){
        boolean isSelected = ((AppCompatRadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.rdpria:
                if (isSelected){
                    rbpria.setTextColor(Color.WHITE);
                    rbwanita.setTextColor(Color.RED);
                }
                break;
            case R.id.rdwanita:
                if (isSelected){
                    rbwanita.setTextColor(Color.WHITE);
                    rbpria.setTextColor(Color.RED);
                }
                break;
        }
    }
    private void calculateBMI () {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE); //
        imm.hideSoftInputFromWindow(calculate.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
        String heightStr = height.getText() .toString();
        String weightStr = weight.getText() .toString();

        if (heightStr !=null && !"".equals(heightStr) && weightStr !=null && !"".equals(weightStr)) {
            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue);

            if (isWanita) {
                displayBMIperempuan(bmi);
            } else {
                displayBMIlaki(bmi);
            }

           // displayBMI(bmi);

        }
    }

    private void calculateLingkarPinggang() {
        int lingkarPinggang = Integer.parseInt(lingkarPinggangET.getText().toString());
        if (isWanita) {
            if (lingkarPinggang<80) {

            }

        } else {

        }
    }

    private void displayBMIperempuan(float bmi){
        String bmiLabel = "";

        if(Float.compare(bmi, 17f) <= 0){
            bmiLabel = "kurus";
        } else if(Float.compare(bmi, 17f) > 0 && Float.compare(bmi, 23f) <= 0){
            bmiLabel = "normal";
        } else if(Float.compare(bmi, 23f) > 0 && Float.compare(bmi, 27f) <= 0){
            bmiLabel = "kegemukan";
        } else {
            bmiLabel = "obesitas";
        }

        bmiLabel = bmi + "\n" + bmiLabel;
        result.setText(bmiLabel);
    }

    private void displayBMIlaki(float bmi){
        String bmiLabel = "";

        if(Float.compare(bmi, 18f) <= 0){
            bmiLabel = "kurus";
        } else if(Float.compare(bmi, 18f) > 0 && Float.compare(bmi, 25f) <= 0){
            bmiLabel = "normal";
        } else if(Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 27f) <= 0){
            bmiLabel = "kegemukan";
        } else {
            bmiLabel = "obesitas";
        }

        bmiLabel = bmi + "\n" + bmiLabel;
        result.setText(bmiLabel);
    }
}