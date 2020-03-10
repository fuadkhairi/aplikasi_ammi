package com.example.crudammi.ui.riwayatpenyakit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.crudammi.R;

import java.util.ArrayList;

public class RiwayatpenyakitActivity extends AppCompatActivity {

    private CheckBox mHipertensi, mDiabetesMellitus, mKolestrol, mAsamUrat, mAsma, mGagalGinjal, mStroke, mGagalJantung;
    private Button mWriteResultButton;
    private TextView mResultTextView;
    private ArrayList<String> mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayatpenyakit);

        mHipertensi = findViewById(R.id.check_hipertensi);
        mDiabetesMellitus = findViewById(R.id.check_diabetes);
        mKolestrol = findViewById(R.id.check_kolestrol);
        mAsamUrat = findViewById(R.id.check_urat);
        mAsma = findViewById(R.id.check_asma);
        mGagalGinjal = findViewById(R.id.check_ginjal);
        mStroke = findViewById(R.id.check_stroke);
        mGagalJantung = findViewById(R.id.check_jantung);

        mWriteResultButton = findViewById(R.id.write_result);
        mResultTextView = findViewById(R.id.result);
        mResult = new ArrayList<>();
        mResultTextView.setEnabled(false);

        mHipertensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mHipertensi.isChecked())
                    mResult.add("Hipertensi");
                else
                    mResult.remove("Hipertensi");
            }
        });

        mDiabetesMellitus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDiabetesMellitus.isChecked())
                    mResult.add("Diabetes Mellitus");
                else
                    mResult.remove("Diabetes Mellitus");

            }
        });

        mKolestrol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mKolestrol.isChecked())
                    mResult.add("Kolestrol");
                else
                    mResult.remove("Kolestrol");
            }
        });

        mAsamUrat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAsamUrat.isChecked())
                    mResult.add("Asam Urat");
                else
                    mResult.remove("Asam Urat");
            }
        });

        mAsma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAsma.isChecked())
                    mResult.add("Asma");
                else
                    mResult.remove("Asma");
            }
        });

        mGagalGinjal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mGagalGinjal.isChecked())
                    mResult.add("Gagal Ginjal");
                else
                    mResult.remove("Gagal Ginjal");
            }
        });

        mStroke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStroke.isChecked())
                    mResult.add("Stroke");
                else
                    mResult.remove("Stoke");
            }
        });

        mGagalJantung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mGagalJantung.isChecked())
                    mResult.add("Gagal Jantung");
                else
                    mResult.remove("Gagal Jantung");
            }
        });

        mWriteResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String s : mResult)
                    stringBuilder.append(s) .append("\n");

                mResultTextView.setText(stringBuilder.toString());
                mResultTextView.setEnabled(false);
            }
        });
    }
}

