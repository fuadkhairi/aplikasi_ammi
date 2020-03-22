package com.example.crudammi.ui.riwayatpenyakit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crudammi.R;

import java.util.Arrays;
import java.util.List;

public class Riwayatpenyakit extends AppCompatActivity {

    Button mBtn;
    TextView mTextV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayatpenyakit);

        mBtn = findViewById(R.id.btnRP);
        mTextV = findViewById(R.id.textViewRP);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Riwayatpenyakit.this);
                //String array for alert dialog multichoice items
                String[] colorsArray = new String[] {"Asam Urat", "Asma", "Diabetes Mellitus", "Gagal Ginjal", "Hipertensi", "Jantung", "Kolestrol", "Stroke"};
                //Boolean array for initial selected items
                final boolean[] checkedColorsArray = new boolean[] {
                        false, //for asam urat
                        false, //for asma
                        false, // for diabetes mellitus
                        false, // for gagal ginjal
                        false, // for hipertensi
                        false, //for gagal ginjal
                        false, // for jantung
                        false, //for kolestrol
                        false, //for stroke
                };

                final List<String> colorList = Arrays.asList(colorsArray);

                builder.setTitle("Pilih Riwayat Penyakit Anda");

                builder.setIcon(R.drawable.ico);

                builder.setMultiChoiceItems(colorsArray, checkedColorsArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                        checkedColorsArray[which] = isChecked;

                        String currentItem = colorList.get(which);

                        Toast.makeText(Riwayatpenyakit.this, currentItem+" " + isChecked, Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        mTextV.setText("Riwayat Penyakit Anda ..\n");
                        for (int i=0; i<checkedColorsArray.length; i++){
                            boolean checked = checkedColorsArray[i];
                            if (checked){
                                mTextV.setText(mTextV.getText() + colorList.get(i) + "\n");
                            }
                        }
                    }
                });

                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}

