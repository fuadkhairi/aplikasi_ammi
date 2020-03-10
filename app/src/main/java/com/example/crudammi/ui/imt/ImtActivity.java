package com.example.crudammi.ui.imt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crudammi.R;

public class ImtActivity extends AppCompatActivity {

    EditText height, weight;
    TextView result;
    Button calculate;
    Button wanita;
    Button pria;

    boolean isWanita = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imt);

        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
        calculate = (Button) findViewById(R.id.calculate);

        wanita = (Button) findViewById(R.id.btnwanita);
        pria = (Button) findViewById(R.id.btnpria);

        wanita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isWanita = true;
                Toast.makeText(getBaseContext(), "wanita", Toast.LENGTH_LONG).show();
            }
        });

        pria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isWanita = false;
                Toast.makeText(getBaseContext(), "pria", Toast.LENGTH_LONG).show();
            }
        });

        calculate.setOnClickListener((view -> { calculateBMI();}));
    }
    private void calculateBMI () {
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